package com.example.hotel_project.Model;

public class Roomcategory {
    private Integer roomcategory_id;

    private String roomcategory_name;

    private Double roomcategory_price;

    private Integer total_number;

    private Double roomcategory_score;

    private Integer locked_number;

    private Integer inuse_roomnumber;

    //Constructor
    public Roomcategory(String roomcategory_name, Double roomcategory_price, Integer total_number, Double roomcategory_score, Integer locked_number, Integer inuse_roomnumber) {
        this.roomcategory_name = roomcategory_name;
        this.roomcategory_price = roomcategory_price;
        this.total_number = total_number;
        this.roomcategory_score = roomcategory_score;
        this.locked_number = locked_number;
        this.inuse_roomnumber = inuse_roomnumber;
    }

    public Roomcategory(Integer roomcategory_id, String roomcategory_name, Double roomcategory_price, Integer total_number, Double roomcategory_score, Integer locked_number, Integer inuse_roomnumber) {
        this.roomcategory_id = roomcategory_id;
        this.roomcategory_name = roomcategory_name;
        this.roomcategory_price = roomcategory_price;
        this.total_number = total_number;
        this.roomcategory_score = roomcategory_score;
        this.locked_number = locked_number;
        this.inuse_roomnumber = inuse_roomnumber;
    }

    public Roomcategory(String nameOfCategory, Double priceOfCategory, Integer totalNumberOfCategory, Double scoreOfCategory) {
        this.roomcategory_name = nameOfCategory;
        this.roomcategory_price = priceOfCategory;
        this.total_number = totalNumberOfCategory;
        this.roomcategory_score = scoreOfCategory;
    }

    public Integer getRoomcategory_id() {
        return roomcategory_id;
    }

    public void setRoomcategory_id(Integer roomcategory_id) {
        this.roomcategory_id = roomcategory_id;
    }

    public String getRoomcategory_name() {
        return roomcategory_name;
    }

    public void setRoomcategory_name(String roomcategory_name) {
        this.roomcategory_name = roomcategory_name == null ? null : roomcategory_name.trim();
    }

    public Double getRoomcategory_price() {
        return roomcategory_price;
    }

    public void setRoomcategory_price(Double roomcategory_price) {
        this.roomcategory_price = roomcategory_price;
    }

    public Integer getTotal_number() {
        return total_number;
    }

    public void setTotal_number(Integer total_number) {
        this.total_number = total_number;
    }

    public Double getRoomcategory_score() {
        return roomcategory_score;
    }

    public void setRoomcategory_score(Double roomcategory_score) {
        this.roomcategory_score = roomcategory_score;
    }

    public Integer getLocked_number() {
        return locked_number;
    }

    public void setLocked_number(Integer locked_number) {
        this.locked_number = locked_number;
    }

    public Integer getInuse_roomnumber() {
        return inuse_roomnumber;
    }

    public void setInuse_roomnumber(Integer inuse_roomnumber) {
        this.inuse_roomnumber = inuse_roomnumber;
    }
}