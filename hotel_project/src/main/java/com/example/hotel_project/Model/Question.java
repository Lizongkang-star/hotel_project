package com.example.hotel_project.Model;

import java.util.Date;

public class Question {
    private Integer question_id;

    private String question_content;

    private String sender;

    private Date send_time;

    private String question_response;

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content == null ? null : question_content.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public Date getSend_time() {
        return send_time;
    }

    public void setSend_time(Date send_time) {
        this.send_time = send_time;
    }

    public String getQuestion_response() {
        return question_response;
    }

    public void setQuestion_response(String question_response) {
        this.question_response = question_response == null ? null : question_response.trim();
    }
}