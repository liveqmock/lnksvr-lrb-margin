package org.fbi.linking.server.lrbmargin.repository.model;

public class LrbMargActKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column LNK.LRB_MARG_ACT.INSTCODE
     *
     * @mbggenerated Thu Nov 06 13:12:08 CST 2014
     */
    private String instcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column LNK.LRB_MARG_ACT.INSTSEQ
     *
     * @mbggenerated Thu Nov 06 13:12:08 CST 2014
     */
    private String instseq;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column LNK.LRB_MARG_ACT.INSTCODE
     *
     * @return the value of LNK.LRB_MARG_ACT.INSTCODE
     *
     * @mbggenerated Thu Nov 06 13:12:08 CST 2014
     */
    public String getInstcode() {
        return instcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column LNK.LRB_MARG_ACT.INSTCODE
     *
     * @param instcode the value for LNK.LRB_MARG_ACT.INSTCODE
     *
     * @mbggenerated Thu Nov 06 13:12:08 CST 2014
     */
    public void setInstcode(String instcode) {
        this.instcode = instcode == null ? null : instcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column LNK.LRB_MARG_ACT.INSTSEQ
     *
     * @return the value of LNK.LRB_MARG_ACT.INSTSEQ
     *
     * @mbggenerated Thu Nov 06 13:12:08 CST 2014
     */
    public String getInstseq() {
        return instseq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column LNK.LRB_MARG_ACT.INSTSEQ
     *
     * @param instseq the value for LNK.LRB_MARG_ACT.INSTSEQ
     *
     * @mbggenerated Thu Nov 06 13:12:08 CST 2014
     */
    public void setInstseq(String instseq) {
        this.instseq = instseq == null ? null : instseq.trim();
    }
}