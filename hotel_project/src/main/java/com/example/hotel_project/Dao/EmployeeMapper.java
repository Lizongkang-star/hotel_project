package com.example.hotel_project.Dao;


import com.example.hotel_project.Model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Mapper
@Service
public interface EmployeeMapper {

    //增
    int insert(Employee record);

    int insertSelective(Employee record);


    //删
    int deleteEmployeeeById(int id);

    //改

    int updateEmployee(Employee employee);

    //查

    Employee employeeconfirm(Employee employee);

    ArrayList<String> getallemployeeid();

    Employee selectById(int i);


    Employee getEmployeeByUsername(String username);

    ArrayList<Employee> getAllEmployee();
}