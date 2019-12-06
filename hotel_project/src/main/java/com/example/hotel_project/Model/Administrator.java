package com.example.hotel_project.Model;

//经理&管理员
public class Administrator {
    private Integer admin_id;

    private String username;

    private String password;

    private String admin_name;

    private String admin_gender;

    private String admin_type;

    public Administrator(String usernmae, String password) {
        this.username=usernmae;
        this.password=password;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
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

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name == null ? null : admin_name.trim();
    }

    public String getAdmin_gender() {
        return admin_gender;
    }

    public void setAdmin_gender(String admin_gender) {
        this.admin_gender = admin_gender == null ? null : admin_gender.trim();
    }

    public String getAdmin_type() {
        return admin_type;
    }

    public void setAdmin_type(String admin_type) {
        this.admin_type = admin_type == null ? null : admin_type.trim();
    }
}