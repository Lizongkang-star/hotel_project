package com.example.hotel_project.Controller.basicSetting;

import com.example.hotel_project.Controller.BaseController;

import com.example.hotel_project.Model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


@Controller
public class EmployeeManageController extends BaseController {
    @RequestMapping("employeeAccountModify")
    public ModelAndView employeeAccountModify(HttpServletRequest request, HttpServletResponse response) {
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }


    //查看所有员工帐号
    @RequestMapping("showAllEmployee")
    public ModelAndView showAllEmployee(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Employee> arrayList = employeeService.getAllEmployee();
        request.setAttribute("AllEmployeeList", arrayList);
        nextURL = "basicSetting/ReceptionistAccountShow";
        return dispatcher.goPage2(mv, request, response, nextURL);
    }

    //增加员工帐号
    @RequestMapping("adminAddEmployee")
    public ModelAndView employeeAccountAdd(HttpServletRequest request, HttpServletResponse response,
                                           @RequestParam("receptionistUsernameAdd") String username,
                                           @RequestParam("receptionistPasswordAdd") String password,
                                           @RequestParam("receptionistNameAdd") String name,
                                           @RequestParam("receptionistGenderAdd") String gender) {
        Employee employee = new Employee(username, password, name, gender);
        ans = employeeService.addEmployee(employee);
        if (ans == 1) {
            message = "接待员账号添加成功！ 3秒后返回接待员账号管理界面。";
            nextURL = "basicSetting/ReceptionistSetting";
            //获取所有雇员信息
            request.getSession().removeAttribute("AllReceptionistID");
            ArrayList<String> allemployeeid = employeeService.getAllEmployeesId();
            request.getSession().setAttribute("AllReceptionistID", allemployeeid);
        } else {
            message = "接待员账号添加失败！ 请重试！ 3秒后返回接待员账号管理界面。";
            nextURL = "basicSetting/ReceptionistAccountAdd";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //删除员工账号
    @RequestMapping("adminDelEmployee")
    public ModelAndView DelEmployee(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam("receptionistIDDelete") Integer employeeId) {
        ans = employeeService.delEmployeeById(employeeId);
        if (ans == 1) {
            message = "删除成功！ 3秒后返回接待员账号管理界面。";
            nextURL = "basicSetting/ReceptionistSetting";
            request.getSession().removeAttribute("AllReceptionistID");
            ArrayList<String> allemployeeid = employeeService.getAllEmployeesId();
            request.getSession().setAttribute("AllReceptionistID", allemployeeid);
        } else {
            message = "删除失败！ 请重试！ 3秒返回接待员账号删除界面。";
            nextURL = "basicSetting/ReceptionistAccountDelete";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //选择要修改的员工账号
    @RequestMapping("adminAccountUpdateID")
    public ModelAndView updateEmployee(HttpServletRequest request, HttpServletResponse response,
                                       @RequestParam("modifyReceptionistID") Integer id) {
        Employee employee = employeeService.queryById(Integer.valueOf(id));
        if (employee != null) {
            ans = 1;
            request.setAttribute("oriEmployee", employee);
        } else {
            ans = 0;
        }
        if (ans == 1) {
            mv.setViewName("basicSetting/ReceptionistAccountModifydetail");
            return mv;
        } else {
            nextURL = "basicSetting/ReceptionistAccountModify";
            message = "无改ID的客户的相关信息，请重新查询！";
            mv.setViewName("General/intermediatePage");
            return dispatcher.goPage(request, response, mv, nextURL, message);
        }
    }


    //执行修改员工账号
    @RequestMapping("adminUpdateEmployee")
    public ModelAndView adminUpdateEmployee(HttpServletRequest request, HttpServletResponse response,
                                            @RequestParam("EmId") Integer employeeId,
                                            @RequestParam("Username") String username,
                                            @RequestParam("Password") String password,
                                            @RequestParam("RealName") String name,
                                            @RequestParam("Gender") String gender) {
        Employee employee = new Employee(employeeId, username, password, name, gender);
        ans = employeeService.updateEmployee(employee);
        if (ans == 1) {
            message = "修改操作成功!3秒后返回客户账号管理界面。";
            nextURL = "basicSetting/ReceptionistSetting";
            request.getSession().removeAttribute("AllReceptionistID");
            ArrayList<String> allemployeeid = employeeService.getAllEmployeesId();
            request.getSession().setAttribute("AllReceptionistID", allemployeeid);
        } else {
            message = "修改操作失败 ! 请重试!";
            nextURL = "basicSetting/ReceptionistAccountModifydetail";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }
}
