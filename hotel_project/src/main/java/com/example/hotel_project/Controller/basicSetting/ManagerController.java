package com.example.hotel_project.Controller.basicSetting;

import com.example.hotel_project.Controller.BaseController;
import com.example.hotel_project.Model.Administrator;
import com.example.hotel_project.Model.Customer;
import com.example.hotel_project.Model.Hotel;
import com.example.hotel_project.ServerImpl.Helper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class ManagerController extends BaseController {
    //认证登录
    @RequestMapping("adminlogin")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password) {
        Administrator administrator = new Administrator(username, password);
        System.out.println("经理登录验证中");
        administrator = administratorService.adminlogin(administrator);
        if (administrator != null) {
            message = "Aha O(∩_∩)O  经理账号登录成功！ 即将为您跳转至经理管理界面！";
            nextURL = "basicSetting/Index";
            //对一些会话期间的参数进行初始化
            Helper helper = new Helper(customerService, ordersService, roomService, employeeService, roomcategoryService,hotelService);
            helper.loginInitializatjion(request);
            request.getSession().setAttribute("LoginedAdmin", administrator);
        } else {
            message = "Oops (T_T)  经理账号登录失败！ 即将为您跳转回登录界面！";
            nextURL = "/ManagerLogin";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //管理员退出系统
    @RequestMapping("AdminLogout")
    public ModelAndView AdminLogout(HttpServletRequest request) {
        request.getSession().removeAttribute("LoginedAdmin");
        System.out.println("管理员成功退出");
        mv.setViewName("index");
        return mv;
    }

    //管理员修改密码
    @RequestMapping("AdminUpPw")
    public ModelAndView AdminUpPw(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam("Password") String pw) {
        Administrator administrator = (Administrator) request.getSession().getAttribute("LoginedAdmin");
        administrator.setPassword(pw);
        ans = administratorService.updateAdmin(administrator);
        if (ans == 1) {
            message = "密码修改成功！返回主页";
            nextURL = "basicSetting/Index";
            request.getSession().removeAttribute("LoginedAdmin");
            request.getSession().setAttribute("LoginedAdmin", administrator);
        } else {
            message = "密码修改失败，返回修改页面";
            nextURL = "basicSetting/ChangePassword";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //酒店信息更新
    @RequestMapping("hotelUpdate")
    public ModelAndView hotelUpdate(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam("name") String HotelName,
                                    @RequestParam("introduction") String Introduction,
                                    @RequestParam("location") String LocationInfo,
                                    @RequestParam("traffic") String TrafficInfo) {
        Hotel hotel = (Hotel) request.getSession().getAttribute("Hotel");
        hotel.setHotel_name(HotelName);
        hotel.setIntroduction(Introduction);
        hotel.setLocation_info(LocationInfo);
        hotel.setTraffic_Info(TrafficInfo);
        ans = hotelService.updateHotel(hotel);
        if(ans==1){
            message = "酒店信息修改成功！返回主页";
            nextURL = "basicSetting/Index";
            request.getSession().removeAttribute("Hotel");
            request.getSession().setAttribute("Hotel", hotel);
        }else {
            message = "酒店信息修改失败，返回修改页面";
            nextURL = "basicSetting/HotelUpdate";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //客户管理

    //查看所有用户
    @RequestMapping("showAllUser")
    public ModelAndView showAllUser(HttpServletRequest request, HttpServletResponse response){
        ArrayList<Customer> arrayList = customerService.getAllCustomers();
        request.setAttribute("AllUserList", arrayList);

        nextURL = "basicSetting/CustomerAccountShow";
        return dispatcher.goPage2(mv, request, response, nextURL);
    }

    //增加客户
    @RequestMapping("adminAddUser")
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam("customerUsernameAdd") String username,
                                @RequestParam("customerPasswordAdd") String password,
                                @RequestParam("customerIDNumberAdd") String idcard,
                                @RequestParam("customerNameAdd") String realname,
                                @RequestParam("customerPhoneAdd") String phone) {
        Customer customer = new Customer(username, password, realname, phone, idcard);
        ans = customerService.addCustomer(customer);
        if (ans == 1) {
            message = "操作成功！3秒后跳转到客户账号管理界面。";
            nextURL = "basicSetting/CustomerSetting";

            request.getSession().removeAttribute("AllCustomerID");
            ArrayList<String> arrayListAllCustomerID = customerService.getAllCustomersID();
            request.getSession().setAttribute("AllCustomerID", arrayListAllCustomerID);
        } else {
            message = "操作失败！3秒后返回到客户账号添加界面。";
            nextURL = "basicSetting/CustomerAccountAdd";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //删除客户
    @RequestMapping("adminDelUser")
    public ModelAndView deleUser(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam("deleteCusotmerID") String customerId) {
        System.out.println(customerId);
        //执行删除操作
        ans = customerService.delUserById(Integer.parseInt(customerId));
        if (ans == 1) {
            message = "删除操作成功!3秒后返回客户账号管理界面。";
            nextURL = "basicSetting/CustomerSetting";
            request.getSession().removeAttribute("AllCustomerID");
            ArrayList<String> arrayListAllCustomerID = customerService.getAllCustomersID();
            request.getSession().setAttribute("AllCustomerID", arrayListAllCustomerID);
        } else {
            message = "删除操作失败! 无对应的客户账号ID! 请重试!";
            nextURL = "basicSetting/CustomerAccountDelete";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //账户修改1
    @RequestMapping("CustomerAccountModifyID")
    public ModelAndView adminUpdateCustomer(HttpServletRequest request, HttpServletResponse response,
                                            @RequestParam("userIDModify") int customer_id) {
        Customer customer = customerService.queryByUserID(customer_id);
        if (customer != null) {
            ans = 1;
            request.setAttribute("oriCustomer", customer);
        } else {
            ans = 0;
        }
        if (ans == 1) {
            mv.setViewName("basicSetting/CustomerAccountModify");
            return mv;
        } else {
            nextURL = "basicSetting/CustomerAccountModifyID";
            message = "无改ID的客户的相关信息，请重新查询！";
            mv.setViewName("General/intermediatePage");
            return dispatcher.goPage(request, response, mv, nextURL, message);
        }
    }


    //账户修改2
    @PostMapping("adminUpdateUser")
    public ModelAndView UpdateUser(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam("userId") Integer customerId,
                                   @RequestParam("Username") String username,
                                   @RequestParam("Password") String password,
                                   @RequestParam("Idcard") String idcard,
                                   @RequestParam("RealName") String realname,
                                   @RequestParam("UserPhone") String phone) {
        Customer customer = new Customer(customerId, username, password, phone, idcard, realname);
        ans = customerService.updateUser(customer);
        if (ans == 1) {
            message = "修改操作成功!3秒后返回客户账号管理界面。";
            nextURL = "basicSetting/CustomerSetting";
            request.getSession().removeAttribute("AllCustomerID");
            ArrayList<String> arrayListAllCustomerID = customerService.getAllCustomersID();
            request.getSession().setAttribute("AllCustomerID", arrayListAllCustomerID);
        } else {
            message = "修改操作失败 ! 请重试!";
            nextURL = "basicSetting/CustomerAccountModify";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

}
