package com.example.hotel_project.Model;

//顾客
public class Customer {

    public Customer(String username, String password, String real_name, String customer_phone, String id_card, String gender) {
        this.username = username;
        this.password = password;
        this.real_name = real_name;
        this.customer_phone = customer_phone;
        this.id_card = id_card;
        this.customer_gender = gender;
    }

    public Customer(String username, String password, String realname, String phone, String idcard) {
        this.username = username;
        this.password = password;
        this.real_name = realname;
        this.customer_phone = phone;
        this.id_card = idcard;
    }

    public Customer(int customerid, String username, String password, String phone, String idcard, String realname) {
        this.customer_id = customerid;
        this.username = username;
        this.password = password;
        this.real_name = realname;
        this.customer_phone = phone;
        this.id_card = idcard;
    }

    public Customer(String username){
        this.username=username;
    }

    public Customer() {
    }

    public Customer(String usernmae, String password) {
        this.username=usernmae;
        this.password=password;
    }

    private Integer customer_id;

    private String username;

    private String password;

    private String real_name;

    private String customer_phone;

    private String id_card;

    private String customer_gender;




    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name == null ? null : real_name.trim();
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone == null ? null : customer_phone.trim();
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card == null ? null : id_card.trim();
    }

    public String getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(String customer_gender) {
        this.customer_gender = customer_gender == null ? null : customer_gender.trim();
    }
}