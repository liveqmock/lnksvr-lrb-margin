package org.fbi.linking.server.lrbmargin.tcpserver;

/**
 * Created by zhanrui on 2014/11/6.
 */
public interface Processor {
    public void service(TxnContext ctx);
}
