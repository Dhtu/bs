package com.bs.springboot.pojo;

public class QuestionNaire {
    private int uid;
    private int qid;
    private String title;
    private String info;
    private int authority;
    private int itemType;
    private String itemInfo;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getAuthority() {
        return authority;
    }


    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public int getItemType() {
        return itemType;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

//    @Override
//    public String toString() {
//        return "QuestionNaire [qid = " + qid + ", uid = " + uid + ", title = " + title + ", info = " + info + ", authority = " + authority + "itemType = " + itemType + "itemInfo = " + itemInfo;
//    }


    @Override
    public String toString() {
        return "QuestionNaire{" +
                "uid=" + uid +
                ", qid=" + qid +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                ", authority=" + authority +
                ", itemType=" + itemType +
                ", itemInfo='" + itemInfo + '\'' +
                '}';
    }
}
