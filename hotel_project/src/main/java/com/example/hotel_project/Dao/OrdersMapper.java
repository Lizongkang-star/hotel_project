package com.example.hotel_project.Dao;

import com.example.hotel_project.Model.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

@Mapper
@Service
public interface OrdersMapper {

    //增
    int insert(Orders record);

    int insertSelective(Orders record);


    //删
    int deleteOrderById(int orderId);

    //改

    int updateDateBeginByOrderID(int orderId, Date startTime);

    //续房
    int updateDateEndByOrderID(int orderId, Date newDate);

    int updateCustomerNameByOrderID(int orderId, String newName);

    //更改订单状态
    int updateStatusByOrderID(int orderId, String status);

    //更新账单花费,未实现
    int updateOrderAccountByID(int orderId);

    //更新订单信息(id放入orders对象中)
    int updateOrderByID(Orders orders);


    //查

    Orders selectByRoomNum(String roomNum);

    Orders selectByOrderId(int orderId);

    ArrayList<Orders> selectByCustomerID(String customerName);

    ArrayList<String> getallordersid();

    //获取账单信息
    ResultSet getBillByRoomNum(String roomNum);

    //单一变动,填入设置的属性名,设置的值,判断条件的属性名,判断条件的属性值
    int singleUpdate(String setAttribute, String setValue, String whereAttribute, String whereValue);

    //更新订单房间号
    int updateRoomNameByOrderID(int orderId, String roomNumber);

    ResultSet getOrderPrice(int orderId);

    int updateOrderAccount(int orderId, double account);


}