package com.example.hotel_project.ServerImpl;


import com.example.hotel_project.Model.Customer;
import com.example.hotel_project.Model.Hotel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Random;

//辅助类
public class Helper {

    private final
    CustomerService customerService;
    private final
    OrdersService ordersService;
    private final
    RoomService roomService;
    private final
    EmployeeService employeeService;
    private final
    RoomcategoryService roomcategoryService;
    private final
    HotelService hotelService;

    public Helper(CustomerService customerService, OrdersService ordersService, RoomService roomService, EmployeeService employeeService, RoomcategoryService roomcategoryService,HotelService hotelService) {
        this.customerService = customerService;
        this.ordersService = ordersService;
        this.roomService = roomService;
        this.employeeService = employeeService;
        this.roomcategoryService = roomcategoryService;
        this.hotelService = hotelService;
    }


    //添加登录用户到会话域
    public void loginedCustomer(HttpServletRequest request, int customer_id) {
        Customer LoginedCustomer;
        LoginedCustomer = customerService.queryByUserID(customer_id);
        HttpSession session = request.getSession();
        session.setAttribute("LoginedCustomer", LoginedCustomer);
    }


    //用户会话初始化内容
    public void loginInitializatjion(HttpServletRequest request) {
        HttpSession session = request.getSession();
        //对会话信息进行初始化
        try {

            //获取所有用户id
            ArrayList<String> arrayListAllCustomerID;
            arrayListAllCustomerID = customerService.getAllCustomersID();
            session.setAttribute("AllCustomerID", arrayListAllCustomerID);

            ArrayList<String> arrayListAllOrdersID = ordersService.getAllOrdersID(); //获取所有订单信息
            session.setAttribute("AllOrdersID", arrayListAllOrdersID);

            //获取所有房间Id
            ArrayList<String> arrayListAllRoomID = roomService.getAllRoomID();
            session.setAttribute("AllRoomID", arrayListAllRoomID);

            //获取所有房间号
            ArrayList<String> arrayListAllRoomName = roomService.getAllRoomName();
            session.setAttribute("AllRoomName", arrayListAllRoomName);

            //获取所有房间类型信息
            ArrayList<String> arrayListAllRoomType = roomcategoryService.getAllCategory();
            session.setAttribute("AllRoomType", arrayListAllRoomType);

            //获取所有雇员Id
            ArrayList<String> allemployeeid = employeeService.getAllEmployeesId();
            session.setAttribute("AllReceptionistID", allemployeeid);

            //获取酒店信息
            Hotel hotel = hotelService.getHotel();
            session.setAttribute("Hotel",hotel);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("初始化错误...from Helper.java");
        }

    }

    //TODO  需要检测生成的ID是否已经在表中
    public static String getRandomUserID() {
        Random randomGenerator = new Random();
        long n;
        do{ n = randomGenerator.nextLong();}
        while (n < 0);
        return String.valueOf(n);
    }
}
