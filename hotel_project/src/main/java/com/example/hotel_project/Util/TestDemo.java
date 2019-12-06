package com.example.hotel_project.Util;


import com.example.hotel_project.Controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestDemo extends BaseController {

    //用于简单功能测试,随便改
    @RequestMapping("testDemo")
    public void scrip1(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(EncodeProcess.getToday());


//        Room room = new Room();
//        room.setRoom_id(1);
//        room.setRoom_number("304");
//        roomService.updateRoomInformation(room);
//        System.out.println("test");
//
//        Employee employee = employeeService.queryById(10000);
//        System.out.println(employee.getEmployee_username());
    }


    //此方法会引起报错;
//    @RequestMapping("/")
//    public String test2(HttpServletRequest request, HttpServletRequest response) {
//        int a = 3 / 0;//不能被0除异常
//        request.setAttribute("message", "早上好，朋友们！");
//        return "home";
//    }
}
