package org.fbi.linking.server.lrbmargin.domain.tps;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.fbi.linking.server.lrbmargin.domain.tps.base.TpsMsg;
import org.fbi.linking.server.lrbmargin.domain.tps.base.TpsMsgBody;

/**
 InstCode	入账帐号	C	100	入账帐号
 InMemo	收款账号	C	100	即子账号
 */
@XStreamAlias("root")
public class TIAG00005 extends TpsMsg {
    private MsgBody body = new MsgBody();

    public MsgBody getBody() {
        return body;
    }

    public static class MsgBody extends TpsMsgBody {
        private String InstCode;
        private String InMemo;

        public String getInstCode() {
            return InstCode;
        }

        public void setInstCode(String instCode) {
            this.InstCode = instCode;
        }

        public String getInMemo() {
            return InMemo;
        }

        public void setInMemo(String inMemo) {
            this.InMemo = inMemo;
        }

        @Override
        public String toString() {
            return "MsgBody{" +
                    "InstCode='" + InstCode + '\'' +
                    ", InMemo='" + InMemo + '\'' +
                    '}';
        }
    }
}
