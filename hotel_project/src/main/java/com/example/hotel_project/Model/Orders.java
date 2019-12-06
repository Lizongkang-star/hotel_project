package com.example.hotel_project.Model;

import java.util.Date;

public class Orders {
    private Integer orders_id;

    private String room_number;

    private Date record_time;

    private Date start_time;

    private Date end_time;

    private String customer_id;

    private String customer_idcard;

    private String customer_name;

    private String orders_status;

    private String orders_type;

    private Double orders_cost;

    public Orders(Integer orders_id, String room_number, String customer_id, String customer_name, Date start_time, Date end_time, String orders_type, String orders_status) {
        this.orders_id = orders_id;
        this.room_number = room_number;
        this.start_time = start_time;
        this.end_time = end_time;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.orders_status = orders_status;
        this.orders_type = orders_type;
    }

    public Orders() {

    }

    public Orders(String username, String real_name, String id_card, Date dateBegin, Date dateEnd, String status, String type, Double cost) {
        this.customer_id = username;
        this.customer_name = real_name;
        this.start_time = dateBegin;
        this.end_time = dateEnd;
        this.orders_status = status;
        this.orders_type = type;
        this.orders_cost = cost;
        this.customer_idcard = id_card;
    }

    public Integer getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(Integer orders_id) {
        this.orders_id = orders_id;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number == null ? null : room_number.trim();
    }

    public Date getRecord_time() {
        return record_time;
    }

    public void setRecord_time(Date record_time) {
        this.record_time = record_time;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id == null ? null : customer_id.trim();
    }

    public String getCustomer_idcard() {
        return customer_idcard;
    }

    public void setCustomer_idcard(String customer_idcard) {
        this.customer_idcard = customer_idcard == null ? null : customer_idcard.trim();
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name == null ? null : customer_name.trim();
    }

    public String getOrders_status() {
        return orders_status;
    }

    public void setOrders_status(String orders_status) {
        this.orders_status = orders_status == null ? null : orders_status.trim();
    }

    public String getOrders_type() {
        return orders_type;
    }

    public void setOrders_type(String orders_type) {
        this.orders_type = orders_type == null ? null : orders_type.trim();
    }

    public Double getOrders_cost() {
        return orders_cost;
    }

    public void setOrders_cost(Double orders_cost) {
        this.orders_cost = orders_cost;
    }
}