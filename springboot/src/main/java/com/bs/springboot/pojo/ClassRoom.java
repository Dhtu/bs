package com.bs.springboot.pojo;

public class ClassRoom {

    private String classroom_id;
    private String classroom_type;
    private int classroom_number;



    public int getNumber() {
        return classroom_number;
    }
    public void setNumber(int number) {
        this.classroom_number = number;
    }
    public String getId() {
        return classroom_id;
    }
    public void setId(String id) {
        this.classroom_id = id;
    }
    public String getType() {
        return classroom_type;
    }
    public void setType(String type) {
        this.classroom_type = type;
    }
    @Override
    public String toString() {
        return "ClassRoom [id=" + classroom_id + ", type=" + classroom_type + ", number=" + classroom_number + "]";
    }






}
