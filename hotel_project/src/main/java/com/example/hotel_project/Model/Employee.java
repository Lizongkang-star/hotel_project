package com.example.hotel_project.Model;

//接待员
public class Employee {
    private Integer employee_id;

    private String employee_username;

    private String password;

    private String employee_name;

    private String employee_gender;

    public Employee(String username, String password) {
        this.employee_username = username;
        this.password = password;
    }

    public Employee(String username, String password, String name, String gender) {
        this.employee_username = username;
        this.password = password;
        this.employee_name = name;
        this.employee_gender = gender;
    }

    public Employee(Integer employeeId, String username, String password, String name, String gender) {
        this.employee_id = employeeId;
        this.employee_username = username;
        this.employee_name = name;
        this.password = password;
        this.employee_gender = gender;

    }


    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_username() {
        return employee_username;
    }

    public void setEmployee_username(String employee_username) {
        this.employee_username = employee_username == null ? null : employee_username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name == null ? null : employee_name.trim();
    }

    public String getEmployee_gender() {
        return employee_gender;
    }

    public void setEmployee_gender(String employee_gender) {
        this.employee_gender = employee_gender == null ? null : employee_gender.trim();
    }
}