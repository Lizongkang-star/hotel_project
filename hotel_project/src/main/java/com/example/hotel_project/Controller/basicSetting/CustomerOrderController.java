package com.example.hotel_project.Controller.basicSetting;
import com.example.hotel_project.Controller.BaseController;
import com.example.hotel_project.Model.Customer;
import com.example.hotel_project.Model.Orders;
import com.example.hotel_project.Model.TempModel.CustomerReport;
import com.example.hotel_project.Util.DateTransform;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerOrderController extends BaseController {


    //用户订单修改
    @RequestMapping("adminCustomerOrdersModify")
    public ModelAndView adminCustomerOrdersModify(HttpServletRequest request, HttpServletResponse response,
                                                  @RequestParam("orderID") Integer orderId,
                                                  @RequestParam("roomID") String roomNum,
                                                  @RequestParam("customerID") String customerID,
                                                  @RequestParam("customerName") String customerName,
                                                  @RequestParam("dateBegin") String dateBegin,
                                                  @RequestParam("dateEnd") String dateEnd,
                                                  @RequestParam("roomType") String roomType,
                                                  @RequestParam("orderStatus") String orderStatus) {
        ans = 0;
        System.out.println("orderId:" + orderId);
        Orders orders = new Orders(orderId, roomNum, customerID
                , customerName, DateTransform.String2Date(dateBegin), DateTransform.String2Date(dateEnd), roomType, orderStatus);
        ans = ordersService.updateOrderById(orders);
        if (ans == 1) {

            message = "订单信息修改成功！ 3秒后重新返回订单管理界面。";
            nextURL = "basicSetting/BookManagement";
        } else {
            message = "订单信息修改失败！ 请重试！ 3秒后重新返回订单修改界面。";
            nextURL = "basicSetting/CustomerOrdersModify";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //查询目标订单信息
    @RequestMapping("adminCustomerOrdersModifyID")
    public ModelAndView adminCustomerOrdersModifyID(HttpServletRequest request, HttpServletResponse response,
                                                    @RequestParam("IDOfOrderRoomModify") Integer id) {
        Orders queryOrder = ordersService.queryByOrderId(id);
        request.setAttribute("queryOrder", queryOrder);
        return dispatcher.goPage2(mv, request, response, "basicSetting/CustomerOrdersModifyResult");
    }

    //根据用户Id查询用户订单
    @RequestMapping("AdminCustomerOrdersQuery")
    public ModelAndView adminCustomerOrdersQuery(HttpServletRequest request, HttpServletResponse response,
                                                 @RequestParam(value = "IDOfCustomerRoomQuery",required = false) Integer id) {
        HttpSession session = request.getSession();
        ans = 0;
        Customer customer = customerService.queryByUserID(id);
        String username = customer.getUsername();
        ArrayList<Orders> ordersArrayList = ordersService.queryByCustomerName(username);
        if (ordersArrayList != null) {
            System.out.println("orderArryList is not null");
            ans=1;
            request.setAttribute("CustomerOrdersQueryResult", ordersArrayList);

        }

        if (ans == 1) {
            return dispatcher.goPage2(mv, request, response, "basicSetting/CustomerOrdersQueryResult");
        } else {
            message = "没有该客户订单的相关信息。3秒后返回订单查询界面。";
            nextURL = "basicSetting/CustomerOrdersQuery";
            return dispatcher.goPage(request, response, mv, nextURL, message);
        }
    }


    //在住客人报表
    @RequestMapping("adminReportOfLivingCustomer")
    public ModelAndView ReportOfLivingCustomer(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<CustomerReport> customerReportArrayList = customerService.getCustomerReport(1);
        request.setAttribute("customerReportArrayList", customerReportArrayList);
        return dispatcher.goPage2(mv, request, response, "basicSetting/ReportOfLivingCustomer");
    }

    //预定客人列表
    @RequestMapping("adminReportOfPreservationCustomer")
    public ModelAndView ReportOfPreservationCustomer(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<CustomerReport> customerReportArrayList = customerService.getCustomerReport(2);
        request.setAttribute("customerReportArrayList", customerReportArrayList);
        return dispatcher.goPage2(mv, request, response, "basicSetting/ReportOfPreservationCustomer");
    }

    //历史客人列表
    @RequestMapping("adminReportOfLivedCustomer")
    public ModelAndView ReportOfLivedCustomer(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<CustomerReport> customerReportArrayList = customerService.getCustomerReport(3);
        request.setAttribute("customerReportArrayList", customerReportArrayList);
        return dispatcher.goPage2(mv, request, response, "basicSetting/ReportOfLivedCustomer");
    }

    //预定处理
    @RequestMapping("RoomQueryResultChosen")
    public ModelAndView RoomQueryResultChosen(HttpServletRequest request, HttpServletResponse response,
                                              @RequestParam("booked") String chosedRoomType) {
        HttpSession session = request.getSession();

        //获取可用房间信息
        HashMap<String, Integer> AvailableQueryResult = (HashMap<String, Integer>) session.getAttribute("AvailableQueryResult");
        ans = AvailableQueryResult.get(chosedRoomType);
        if (ans == 0) {
            message = "该房间类型已售空，请选择其他类型的房间，3秒后返回可用房间查询界面。";
            nextURL = "bookOnline/RoomQuery";
            return dispatcher.goPage(request, response, mv, nextURL, message);
        } else {
            HashMap<String, Double> typeAndPrice = roomcategoryService.getTypeAndPrice();
            for (Map.Entry<String, Double> entry : typeAndPrice.entrySet()) {
                if (entry.getKey().equals(chosedRoomType)) {
                    session.setAttribute("type", entry.getKey());
                    session.setAttribute("price", entry.getValue());
                }
            }
            return dispatcher.goPage2(mv, request, response, "bookOnline/BookRoom");
        }
    }
}
