package com.example.hotel_project.Controller.bookOnline;

import com.example.hotel_project.Controller.BaseController;
import com.example.hotel_project.Model.Customer;
import com.example.hotel_project.Model.Orders;
import com.example.hotel_project.Util.DateTransform;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserRoomOperation extends BaseController {

    //用户查询房间
    @RequestMapping("customerRoomQuery")
    public ModelAndView fun1(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("dateBegin") String s1,
                             @RequestParam("dateEnd") String s2) {
        HttpSession session = request.getSession();
        //日期格式："yyyy-mm-dd"
        //检查日期合法性

        Date startTime = DateTransform.String2Date(s1);
        Date endTime = DateTransform.String2Date(s2);

        if (s1.compareTo(s2) > 0) {
            nextURL = "bookOnline/RoomQuery";
            message = "输入日期范围非法！ 请重新输入！ 3秒后跳转回可用房查询界面";
            return dispatcher.goPage(request, response, mv, nextURL, message);
        } else {
            session.setAttribute("startTime", s1);
            session.setAttribute("endTime", s2);
        }
        //从房间表获得原有的各类型的房间数量
        HashMap<String, Integer> originalNumberOfType = roomService.getAllroomType();

        //因为顾客与在住房间一一对应,故通过客户表获得在住的不可用的各类型的房间数量
        HashMap<String, Integer> unavailableNumberofType = customerService.getUnavailableRoom(startTime, endTime);
        System.out.println("房间结果集大小：" + unavailableNumberofType.size());
        System.out.println("Unuseable：");
        for (Map.Entry<String, Integer> entry : unavailableNumberofType.entrySet()) {
            String type = entry.getKey();
            System.out.println(type);
            Number number = entry.getValue();
            Integer num = number.intValue();
            System.out.println("type:" + type + "  num:" + num);
        }

        //用各类型的总房间数减去该时间段各类型不可用的房间数,即可求出该时间段各类型可用的房间数
        String type;
        Number number;
        Integer num;
        for (Map.Entry<String, Integer> entry : unavailableNumberofType.entrySet()) {
            type = entry.getKey();
            number = entry.getValue();
            num = number.intValue();
            if (originalNumberOfType.containsKey(type)) {
                number = originalNumberOfType.get(type);
                Integer num2 = number.intValue();
                originalNumberOfType.put(type, num2 - num);
            }
        }

        session.setAttribute("AvailableQueryResult", originalNumberOfType);
        mv.addObject("request", request);
        mv.addObject("response", response);
        mv.setViewName("bookOnline/RoomQueryResult");
        return mv;
    }

    //提交订单确认预定
    @RequestMapping("UserSubmitOrder")
    public ModelAndView adminSubmitOrder(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ans = 0;
        Customer customer = (Customer) session.getAttribute("LoginedCustomer");
        Orders orders = new Orders(customer.getUsername(), customer.getReal_name(),customer.getId_card(),
                DateTransform.String2Date((String) session.getAttribute("startTime")),
                DateTransform.String2Date((String) session.getAttribute("endTime")),
                "预定", (String) session.getAttribute("type"),(Double)session.getAttribute("price"));
        ans = ordersService.addOrder(orders);
        if (ans == 1) {
            message = "预定成功！ 3秒后返回查询界面。";
        } else {
            message = "预定失败！ 请重试！ 3秒后返回查询界面。";
        }
        nextURL = "bookOnline/RoomQuery";
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }


}
