package org.fbi.linking.server.lrbmargin.processor;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.fbi.linking.server.lrbmargin.domain.tps.TIAG00005;
import org.fbi.linking.server.lrbmargin.domain.tps.TOAG00005;
import org.fbi.linking.server.lrbmargin.repository.dao.LrbMargTxnMapper;
import org.fbi.linking.server.lrbmargin.repository.model.LrbMargTxn;
import org.fbi.linking.server.lrbmargin.repository.model.LrbMargTxnExample;
import org.fbi.linking.server.lrbmargin.tcpserver.Processor;
import org.fbi.linking.server.lrbmargin.tcpserver.TxnContext;
import org.fbi.linking.server.lrbmargin.util.MybatisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhanrui on 2014/11/6.
 * ��ѯ���˺ŵ�����ϸ
 */
public class G00005Processor implements Processor {
    private static final Logger logger = LoggerFactory.getLogger(G00005Processor.class);

    @Override
    public void service(TxnContext ctx) {
        TOAG00005 toa = new TOAG00005();
        toa.getHead().setTransCode("G00005");
        toa.getHead().setTransDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        toa.getHead().setTransTime(new SimpleDateFormat("HHmmdd").format(new Date()));
        toa.getHead().setSeqNo(new SimpleDateFormat("yyyyMMddHHmmddSSS").format(new Date()));  //Ĭ��ֵ

        try {
            String msgtia = ctx.getMsgtia();
            TIAG00005 tia = (TIAG00005) new TIAG00005().toBean(msgtia);

            processTxn(tia, toa);

            //����toa��ˮ����tiaһ��
            toa.getHead().setSeqNo(tia.getHead().getSeqNo());

            ctx.setMsgtoa(toa.toXml(toa));
        } catch (Exception e) {
            logger.error("���״���ʧ��", e);
            toa.getBody().setResult("99");
            ctx.setMsgtoa(toa.toXml(toa));
        }
    }

    private void processTxn(TIAG00005 tia, TOAG00005 toa) {
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession session = null;
        try {
            sqlSessionFactory = MybatisFactory.ORACLE.getInstance();
            session = sqlSessionFactory.openSession();
            LrbMargTxnMapper mapper = session.getMapper(LrbMargTxnMapper.class);

            LrbMargTxnExample example = new LrbMargTxnExample();
            example.createCriteria()
                    .andInstcodeEqualTo(tia.getBody().getInstCode())
                    .andInmemoEqualTo(tia.getBody().getInMemo());

            List<LrbMargTxn> txnList = mapper.selectByExample(example);

            List<TOAG00005.MsgBody.Entity> listEntity = new ArrayList<>();
            int count = 0;
            for (LrbMargTxn txn : txnList) {
                TOAG00005.MsgBody.Entity entity = new TOAG00005.MsgBody.Entity();
                entity.setInDate(txn.getIndate());
                entity.setInAmount(txn.getInamount().toString());
                entity.setInName(txn.getInname());
                entity.setInAcct(txn.getInacct());
                entity.setInBankFLCode(txn.getInbankflcode());
                entity.rowNum = "" + count;
                listEntity.add(entity);
                count++;
            }
            toa.getBody().setResult("00");
            toa.getBody().setInMemo(tia.getBody().getInMemo());
            toa.getBody().setCount("" + count);
            toa.getBody().setListEntity(listEntity);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
