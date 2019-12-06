package com.example.hotel_project.Model;

public class Hotel {
    private String location_info;

    private String traffic_Info;

    private String hotel_name;

    private String introduction;

    public String getLocation_info() {
        return location_info;
    }

    public void setLocation_info(String location_info) {
        this.location_info = location_info == null ? null : location_info.trim();
    }

    public String getTraffic_Info() {
        return traffic_Info;
    }

    public void setTraffic_Info(String traffic_Info) {
        this.traffic_Info = traffic_Info == null ? null : traffic_Info.trim();
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name == null ? null : hotel_name.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}