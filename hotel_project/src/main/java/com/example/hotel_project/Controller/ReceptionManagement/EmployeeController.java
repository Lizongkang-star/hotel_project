package com.example.hotel_project.Controller.ReceptionManagement;

import com.example.hotel_project.Controller.BaseController;
import com.example.hotel_project.Model.Employee;
import com.example.hotel_project.Model.Room;
import com.example.hotel_project.ServerImpl.Helper;
import com.example.hotel_project.Util.DateTransform;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@Controller
public class EmployeeController extends BaseController {

    //员工登录验证
    @RequestMapping("employeelogin")
    public ModelAndView employeelogin(HttpServletRequest request, HttpServletResponse response,
                                      @RequestParam("receptionistName") String username,
                                      @RequestParam("receptionistPassword") String password) {
        System.out.println("雇员正在登录");
        Employee employee = new Employee(username, password);
        ans = employeeService.employeeconfirm(employee);
        if (ans == 1) {
            System.out.println("接待员登录成功");
            Helper helper = new Helper(customerService, ordersService, roomService, employeeService, roomcategoryService,hotelService);
            helper.loginInitializatjion(request);
            employee = employeeService.getEmployeeByUsername(username);
            request.getSession().setAttribute("LoginedEmployee",employee);
            message = "AHa 欢迎您! 接待员账号登录成功(●'◡'●)! 即将为您跳转至接待员管理界面.";
            nextURL = "receptionManagement/Index";
        } else {
            System.out.println("接待员登录失败");
            message = "Oops 接待员账号或密码错误(T_T)!  3秒后跳转至接待员登录界面!";
            nextURL = "/ReceptionistLogin";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //员工退出帐号
    @RequestMapping("EmployeeLogout")
    public ModelAndView AdminLogout(HttpServletRequest request) {
        request.getSession().removeAttribute("LoginedEmployee");
        System.out.println("员工成功退出");
        mv.setViewName("index");
        return mv;
    }

    //员工修改密码
    @RequestMapping("employeeUpPw")
    public ModelAndView emUpPw(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam("Password") String Password){
        Employee employee = (Employee) request.getSession().getAttribute("LoginedEmployee");
        employee.setPassword(Password);
        ans = employeeService.updateEmployee(employee);
        if (ans == 1) {
            message = "密码修改成功！返回主页";
            nextURL = "receptionManagement/Index";
            request.getSession().removeAttribute("LoginedEmployee");
            request.getSession().setAttribute("LoginedEmployee", employee);
        } else {
            message = "密码修改失败，返回修改页面";
            nextURL = "receptionManagement/ChangePassword";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }


    //房间维修成功
    @RequestMapping("employeeRoomRepairDone")
    public ModelAndView employeeRoomRepairDone(HttpServletRequest request, HttpServletResponse response,
                                               @RequestParam("roomRepairDoneOfRoomID") String roomId) {
        ans = roomService.fixDoneByRoomID(Integer.valueOf(roomId));
        if (ans == 1) {
            message = "房间状态设置成功！ 所选房间已可用！ 3秒后返回维修管理界面！";
        } else {
            message = "房间状态设置失败！ 请重试！3秒后返回维修管理界面！";
        }
        nextURL = "receptionManagement/RepairManagement";
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //房间设置维修状态
    @RequestMapping("employeeRoomRepair")
    public ModelAndView employeeRoomRepair(HttpServletRequest request, HttpServletResponse response,
                                           @RequestParam("roomRepairOfRoomID") String roomId) {
        ans = roomService.fixingRoomByRoomID(Integer.valueOf(roomId));
        if (ans == 1) {
            message = "维修设置成功！3秒后返回维修管理界面！";
        } else {
            message = "维修设置失败！ 请重试！3秒后返回维修管理界面！";
        }
        nextURL = "receptionManagement/RepairManagement";
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //员工办理房间续住
    @RequestMapping("employeeRoomExtend")
    public ModelAndView employeeRoomExtend(HttpServletRequest request, HttpServletResponse response,
                                           @RequestParam("orderIDExtend") String orderIDExtend,
                                           @RequestParam("DateEndExtend") String DateEndExtend) {
        if (DateEndExtend != null) {
            ans = ordersService.extendCheckoutTimeByOrderID(Integer.valueOf(orderIDExtend), DateTransform.String2Date(DateEndExtend));
            if (ans == 1) {
                message = "续住成功! 3秒后跳转至续住管理界面";
            } else {
                message = "续住失败! 请重试! 3秒后跳转至续住管理界面";
            }
        } else {
            message = "请选择";
        }
        nextURL = "receptionManagement/RoomExtend";
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }


    //预定入住的房间查询
    @RequestMapping("employeePreservationCheckinRoomQuery")
    public ModelAndView employeePreservationCheckinRoomQuery(HttpServletRequest request, HttpServletResponse response,
                                                             @RequestParam("orderIDCheckin") Integer orderId) {
        HttpSession session = request.getSession();
        ans = 0;
        ArrayList<Room> availableRoomQueryResult = employeeService.preservationCheckinRoomQuery(orderId);
        if (availableRoomQueryResult != null) {
            ans = 1;
            request.setAttribute("AvailableQueryResult", availableRoomQueryResult);
            session.setAttribute("orderIDCheckin", orderId);
        }
        if (ans == 1) {
            return dispatcher.goPage2(mv, request, response, "receptionManagement/PreservationCheckinRoomQueryResult");
        } else {
            message = "查询失败，请重试。3秒后返回预定入住界面。";
            nextURL = "receptionManagement/PreservationCheckin";
            return dispatcher.goPage(request, response, mv, nextURL, message);
        }
    }

    //预定订单办理入住
    @RequestMapping("employeePreservationCheckin")
    public ModelAndView employeeDoPreservationCheckin(HttpServletRequest request, HttpServletResponse response,
                                                      @RequestParam("bookedRoomNumber") String bookedRoomNum) {
        HttpSession session = request.getSession();
        int orderIDCheckin = (int) session.getAttribute("orderIDCheckin");
        if (bookedRoomNum != null) {
            ans = employeeService.preservationCheckin(orderIDCheckin, bookedRoomNum);
            if (ans == 1) {
                message = "入住成功！3秒后返回预定入住界面。";
            } else {
                message = "入住失败！请重试！3秒后返回预定入住界面";
            }
        } else {
            message = "请选择入住的房间！3秒后返回预定入住界面。";
        }
        nextURL = "receptionManagement/PreservationCheckin";
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

}
