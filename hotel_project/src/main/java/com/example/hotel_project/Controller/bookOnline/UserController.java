package com.example.hotel_project.Controller.bookOnline;


import com.example.hotel_project.Controller.BaseController;
import com.example.hotel_project.Model.Customer;
import com.example.hotel_project.Model.Hotel;
import com.example.hotel_project.ServerImpl.Helper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class UserController extends BaseController {

    @RequestMapping("nameCustomerLogin")
    public ModelAndView userlogin(HttpServletRequest request, HttpServletResponse response,
                                  @RequestParam("nameCustomerLogin") String usernmae,
                                  @RequestParam("passwordCustomerLogin") String password) {
        System.out.println("用户正在登录");
        HttpSession session = request.getSession();
        Customer customer = new Customer(usernmae, password);
        ans = customerService.customerconfirm(customer);
        if (ans == 1) {
            System.out.println("用户登录成功");
            nextURL = "bookOnline/Index";
            message = "Aha O(∩_∩)O 登录成功!  欢迎您!   即将为你跳转至主页";
            Hotel hotel = hotelService.getHotel();
            //用户计入会话域
            Helper helper = new Helper(customerService, ordersService, roomService, employeeService, roomcategoryService,hotelService);
            helper.loginedCustomer(request, customerService.getCustomerByUsernamePassword(usernmae,password).getCustomer_id());

            //添加信息至会话作用域
            if (hotel != null) {
                session.setAttribute("locationinfo", hotel.getLocation_info());
                session.setAttribute("trafficinfo", hotel.getTraffic_Info());
                session.setAttribute("hotelname", hotel.getHotel_name());
                session.setAttribute("introdution", hotel.getIntroduction());
            }

        } else {
            System.out.println("用户登录失败");
            nextURL = "/CustomerLogin";
            message = "Oops (T_T) 登录失败!   账号或密码错误!   3秒后跳转回登录界面";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //用户退出账号
    @RequestMapping("Userlogout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("LoginedCustomer");
        System.out.println("用户已经退出");
        mv.setViewName("index");
        return mv;
    }

    //用户修改密码
    @RequestMapping("UserChangePassword")
    public ModelAndView changePw(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam("Password") String pw){
        Customer customer = (Customer) request.getSession().getAttribute("LoginedCustomer");
        customer.setPassword(pw);
        ans = customerService.updateUser(customer);
        if(ans==1){
            message="密码修改成功！返回主页";
            nextURL="bookOnline/Index";
            //会话修改内容
            request.getSession().removeAttribute("LoginedCustomer");
            request.getSession().setAttribute("LoginedCustomer",customer);
        }else {
            message="密码修改失败，返回修改页面";
            nextURL="bookOnline/ChangePassword";
        }
        return dispatcher.goPage(request,response,mv,nextURL,message);
    }


    //用户注册
    @RequestMapping("userRegister")
    public ModelAndView newuser(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam("username") String username, @RequestParam("password") String password,
                                @RequestParam("idcard") String idcard, @RequestParam("realname") String realname, @RequestParam("phone") String phone, @RequestParam("gender") String gender) {
        Customer customer = new Customer(username, password, realname, phone, idcard, gender);
        ans = customerService.addCustomer(customer);

        if (ans == 1) {
            message = "帐号创建成功O(∩_∩)O！3秒后跳转到登录页面";
            nextURL = "CustomerLogin";
        } else {
            message = "Oops~账号创建失败(T_T)！3秒后返回到账号添加界面";
            nextURL = "basicSetting/CustomerAccountAdd";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }
}
