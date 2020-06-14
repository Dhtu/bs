package com.bs.springboot.pojo;

public class TableData {
    private int did;
    private int qid;
    private int uid;
    private String value;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TableData{" +
                "did=" + did +
                ", qid=" + qid +
                ", uid=" + uid +
                ", value='" + value + '\'' +
                '}';
    }


}
