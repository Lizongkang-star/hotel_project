package com.example.hotel_project.Dao;


import com.example.hotel_project.Model.Customer;
import com.example.hotel_project.Model.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Mapper
@Service
public interface CustomerMapper {

    /*
    增加
     */
    //增加用户
    int insert(Customer record);

    int insertSelective(Customer record);


    /*
    删除
     */
    int deleteByUserId(int userId);



    /*
    修改
     */

    //更新用户名
    int updateUsername(int customerid, String username);

    //更新密码
    int updatePassword(int customerid, String password);

    //更新身份证号
    int updateIdcard(int customerid, String idcard);

    int updateUser(Customer customer);




    /*
    查找
     */

    ArrayList<Customer> queryByUsername(String username); //返回List类型

    //获取所有客户对象
    ArrayList<Customer> getAllCustomers();

    Customer queryByUsernamePassword(String username, String password);

    Customer queryByUserId(int userId);

    Customer customerconfirm(Customer customer);

    ArrayList<Orders> selectAllOrders(int userId);

    //获取所有客户id
    ArrayList<String> getAllCustomersId();

    //查询所有在住客户信息
    List<HashMap<String, Object>> queryCustomersLiving();

    List<HashMap<String, Object>> queryCustomersPreservation();

    List<HashMap<String, Object>> queryCustomersLived();

    //显示客户订单
    List<Orders> showOrders();

    //显示不可用房间类型号
    List<HashMap<String, Integer>> getUnavailableRoomTypeWithNumber(Date starttime, Date endtime);


}