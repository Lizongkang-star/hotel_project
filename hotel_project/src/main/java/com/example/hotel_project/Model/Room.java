package com.example.hotel_project.Model;

//房间
public class Room {
    private Integer room_id;

    private String room_number;

    private String room_type;

    private String room_floor;

    private String room_direction;

    private Double room_square;

    private String can_addbed;

    private Integer bed_num;

    private String room_description;

    private String room_status;

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number == null ? null : room_number.trim();
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type == null ? null : room_type.trim();
    }

    public String getRoom_floor() {
        return room_floor;
    }

    public void setRoom_floor(String room_floor) {
        this.room_floor = room_floor == null ? null : room_floor.trim();
    }

    public String getRoom_direction() {
        return room_direction;
    }

    public void setRoom_direction(String room_direction) {
        this.room_direction = room_direction == null ? null : room_direction.trim();
    }

    public Double getRoom_square() {
        return room_square;
    }

    public void setRoom_square(Double room_square) {
        this.room_square = room_square;
    }

    public String getCan_addbed() {
        return can_addbed;
    }

    public void setCan_addbed(String can_addbed) {
        this.can_addbed = can_addbed == null ? null : can_addbed.trim();
    }

    public Integer getBed_num() {
        return bed_num;
    }

    public void setBed_num(Integer bed_num) {
        this.bed_num = bed_num;
    }

    public String getRoom_description() {
        return room_description;
    }

    public void setRoom_description(String room_description) {
        this.room_description = room_description == null ? null : room_description.trim();
    }

    public String getRoom_status() {
        return room_status;
    }

    public void setRoom_status(String room_status) {
        this.room_status = room_status == null ? null : room_status.trim();
    }
}