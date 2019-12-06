package com.example.hotel_project.ServerImpl;


import com.example.hotel_project.Model.Orders;
import com.example.hotel_project.Model.Room;
import com.example.hotel_project.Model.TempModel.Bill;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Service("OrdersService")
@Transactional
@SuppressWarnings("all")
public class OrdersService extends BaseService {
    int ans = 0;


    //增

    //增加预定订单
    public int addOrder(Orders orders) {
        try {
            ans = ordersMapper.insert(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ans==1){
            System.out.println("预定成功！");
        }else {
            System.out.println("预定失败");
        }
        return ans;
    }

    //删

    //查
    public ArrayList<String> getAllOrdersID() {
        ArrayList<String> allordersid = null;
        try {
            if (null != ordersMapper.getallordersid()) //注意这里处理不当会报错，空指针Exception
            {allordersid = ordersMapper.getallordersid();}
            if (allordersid == null) {
                System.out.println("查询失败...from OrdersService");
            } else {
                System.out.println("查询成功...from OrdersService");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库错误...from OrdersService");
        }
        return allordersid;
    }


    //计算收入
    public int calculateBillByOrderID(int ordreId) {
        try {
            //ans = ordersMapper.updateOrderAccountByID(ordreId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ans = 1;
        return ans;
    }

    //获取Orders对象
    public Orders queryByOrderId(int id) {
        Orders orders = null;
        try {
            orders = ordersMapper.selectByOrderId(id);
        } catch (Exception e) {
            System.out.println("something went wrong...from Service");
            e.printStackTrace();
        }
        return orders;
    }

    //获取账单信息
    public Bill getBillByRoomNum(String roomNum) {
        Bill bill = new Bill();
        try {
            Room room = roomMapper.selectRoomByNum(roomNum);
            Orders orders = ordersMapper.selectByRoomNum(roomNum);
            if (room != null && orders != null) {
                bill.setOrderID(orders.getOrders_id());
                bill.setCustomerID(orders.getCustomer_id());
                bill.setEndTime(orders.getEnd_time());
                bill.setFloor(room.getRoom_floor());
                bill.setRoomNumber(roomNum);
                bill.setStartTime(orders.getStart_time());
                bill.setType(room.getRoom_type());
                bill.setCustomerName(orders.getCustomer_name());
                bill.setRoomID(room.getRoom_id());
            }
//            ResultSet r = null;
//            r = ordersMapper.getBillByRoomNum(roomNum);
//            if(r!=null){
//                while (r.next()){
//                    bill.setOrderID(r.getInt("orders_id"));
//                    bill.setCustomerID(r.getString("customer_id"));
//                    bill.setEndTime(r.getDate("end_time"));
//                    bill.setFloor(r.getString("room_floor"));
//                    bill.setRoomNumber(r.getString("room_number"));
//                    bill.setStartTime(r.getDate("start_time"));
//                    bill.setType(r.getString("room_type"));
//                    bill.setCustomerName(r.getString("customer_name"));
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bill;
    }

    //改

    //更新订单信息
    public int updateOrderInformationByOrderID(int orderId) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        //String nowDate = dateFormat.format(date);
        try {
            ans = (ordersMapper.updateDateEndByOrderID(orderId, date) == 1
                    && ordersMapper.updateStatusByOrderID(orderId, "已退房") == 1) ? 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //更新订单房间信息
    public int updateRoomIDByOrderID(int orderId, String roomName) {
        try {
            ans = ordersMapper.updateRoomNameByOrderID(orderId, roomName);
        } catch (Exception e) {
            System.out.println("something went wrong...from Service");
            e.printStackTrace();
        }
        return ans;
    }

    public int updateOrderAccountByID(int orderId) {
        try {
            ResultSet r = ordersMapper.getOrderPrice(orderId);
            while (r.next()) {
                int day = 1;
                double price = r.getDouble("roomcategory_price");
                double account = day * price;
                System.out.println(account);
                ans = ordersMapper.updateOrderAccount(orderId, account);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //换房
    public int changeRoomByOrderID(int orderId, int newRoomId) {
        try {
            ans = ordersMapper.singleUpdate("roomId", String.valueOf(newRoomId), "orderId", String.valueOf(orderId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //续房
    public int extendCheckoutTimeByOrderID(int orderId, Date newDate) {
        try {
            ans = ordersMapper.updateDateEndByOrderID(orderId, newDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }


    //直接根据订单对象更新信息
    public int updateOrderById(Orders orders) {
        try {
            ans = ordersMapper.updateOrderByID(orders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ans == 1) {
            System.out.println("订单信息修改成功！");
        }
        return ans;
    }


    public ArrayList<Orders> queryByCustomerName(String name) {
        ArrayList<Orders> arrayList = null;
        try {
            arrayList = ordersMapper.selectByCustomerID(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }


}
