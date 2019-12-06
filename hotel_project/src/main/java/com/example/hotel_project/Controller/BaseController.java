package com.example.hotel_project.Controller;


import com.example.hotel_project.ServerImpl.*;
import com.example.hotel_project.Util.IntermediateModelAndViewDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;


public class BaseController {
    //标记状态
    protected int ans = 0;
    //跳转使用
    protected String message = "", nextURL = "";
    protected ModelAndView mv = new ModelAndView();
    @Autowired
    protected AdministratorService administratorService;
    @Autowired
    protected CommentService commentService;
    @Autowired
    protected CustomerService customerService;
    @Autowired
    protected EmployeeService employeeService;
    @Autowired
    protected HotelService hotelService;
    @Autowired
    protected OrdersService ordersService;
    @Autowired
    protected QuestionService questionService;
    @Autowired
    protected RoomcategoryService roomcategoryService;
    @Autowired
    protected RoomService roomService;
    protected IntermediateModelAndViewDispatcher dispatcher = new IntermediateModelAndViewDispatcher();
}