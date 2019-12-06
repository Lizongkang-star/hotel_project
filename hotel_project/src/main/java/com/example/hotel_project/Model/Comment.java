package com.example.hotel_project.Model;

import java.util.Date;

//评论
public class Comment {
    private Integer coment_id;

    private String customer_Id;

    private Date comment_time;

    private String comment_content;

    private String room_number;

    private String comment_type;

    public Integer getComent_id() {
        return coment_id;
    }

    public void setComent_id(Integer coment_id) {
        this.coment_id = coment_id;
    }

    public String getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        this.customer_Id = customer_Id == null ? null : customer_Id.trim();
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content == null ? null : comment_content.trim();
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number == null ? null : room_number.trim();
    }

    public String getComment_type() {
        return comment_type;
    }

    public void setComment_type(String comment_type) {
        this.comment_type = comment_type == null ? null : comment_type.trim();
    }
}