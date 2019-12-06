package com.example.hotel_project.Controller.ReceptionManagement;

import com.example.hotel_project.Controller.BaseController;
import com.example.hotel_project.Model.Room;
import com.example.hotel_project.Model.TempModel.Bill;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller("RoomInformationUpdate")
public class RoomInfomationUpdate extends BaseController {

    //房间信息更新
    @RequestMapping("adminRoomInformationUpdate")
    public ModelAndView RoomInfoUpdate(HttpServletRequest request, HttpServletResponse response,
                                       @RequestParam("roomType") String roomType,
                                       @RequestParam("roomFloor") String roomFloor,
                                       @RequestParam("roomDirection") String roomDirection,
                                       @RequestParam("roomDescription") String roomDescription,
                                       @RequestParam("roomStatus") String roomStatus,
                                       @RequestParam("roomSquare") String roomSquare,
                                       @RequestParam("roomNumber") String roomNumber) {
        HttpSession session = request.getSession();
        Room room = (Room) session.getAttribute("resultRoomOfSetting");
        room.setRoom_number(roomNumber);
        room.setRoom_type(roomType);
        room.setRoom_floor(roomFloor);
        room.setRoom_direction(roomDirection);
        room.setRoom_description(roomDescription);
        room.setRoom_status(roomStatus);
        room.setRoom_square(Double.valueOf(roomSquare));
        ans = roomService.updateRoomInformation(room);
        if (ans == 1) {
            message = "房间信息更新成功! 3秒后返回客房信息设置页.";
        } else {
            message = "房间信息更新失败! 请重试! 3秒后返回客房信息设置页.";
        }
        nextURL = "basicSetting/RoomInformationSettingID";
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }


    //退房
    @RequestMapping("EmployeeDoCheckout")
    public ModelAndView CheckOut(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam("checkoutRoomID") String roomNum) {
        HttpSession session = request.getSession();
        System.out.println(roomNum);
        Bill bill = ordersService.getBillByRoomNum(roomNum);
        if (bill != null) {
            System.out.println("bill is not null");
            //可能存在问题
            int orderId = bill.getOrderID();
            ans = (roomService.roomCheckout(roomNum) == 1) && (ordersService.updateOrderInformationByOrderID(orderId) == 1
                    && (ordersService.calculateBillByOrderID(orderId) == 1)) ? 1 : 0;
            session.setAttribute("checkoutBill", bill);
        }else {
            System.out.println("bill is null !");
        }
        if (ans == 1) {
            message = "退房成功！ 3秒后显示账单。";
            nextURL = "receptionManagement/CheckoutShowBill";
        } else {
            message = "退房失败！ 请重试！ 3秒后回到退房界面。";
            nextURL = "receptionManagement/Checkout";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //对用户订单换房
    //ReceptionManagement/RoomChange.do
    @RequestMapping("employeeRoomChange")
    public ModelAndView employeeRoomChange(HttpServletRequest request, HttpServletResponse response,
                                           @RequestParam("orderIDChangeRoom") String orderIDChangeRoom,
                                           @RequestParam("roomChangeOfRoomName") String roomChangeOfRoomName) {
        ans = 0;
        System.out.println("更改房间的订单号：" + orderIDChangeRoom);
        //根据房间号和订单号更新信息
        ans = ordersService.updateRoomIDByOrderID(Integer.valueOf(orderIDChangeRoom), roomChangeOfRoomName);
        if (ans == 1) {
            message = "换房成功！ 3秒后返回换房页面。";
        } else {
            message = "换房失败！ 3秒后返回换房页面。";
        }
        nextURL = "receptionManagement/RoomChange";
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

}
