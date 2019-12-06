package com.example.hotel_project.ServerImpl;


import com.example.hotel_project.Model.Customer;
import com.example.hotel_project.Model.TempModel.CustomerReport;
import com.example.hotel_project.Util.DateTransform;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("CustomerService")
@Transactional
@SuppressWarnings("all")
public class CustomerService extends BaseService {
    int ans = 0;

    //增

    //增加客户
    public int addCustomer(Customer customer) {
        try {
            ans = customerMapper.insert(customer);
            if (ans == 1) {
                System.out.println("用户新建成功");
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("用户新建失败");
        }
        return ans;
    }

    //删

    public int delUserById(int customerId) {
        try {
            ans = customerMapper.deleteByUserId(customerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //查

    //用户验证
    public int customerconfirm(Customer customer) {
        Customer customer1 = null;
        try {
            customer1 = customerMapper.customerconfirm(customer);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sql错误...from CustomerService");
        }
        if (customer1 != null) {
            ans = 1;
        } else {
            ans = 0;
        }
        return ans;
    }

    //根据用户名查找用户
    public Customer getCustomerByUsernamePassword(String username, String password) {
        Customer customer = null;
        try {
            customer = customerMapper.queryByUsernamePassword(username, password);
            if (customer != null)
            {System.out.println("用户获取成功");}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    //根据用户ID查找
    public Customer queryByUserID(int customerid) {
        Customer customer = null;
        try {
            customer = customerMapper.queryByUserId(customerid);
            if (customer != null) {
                System.out.println("查询成功...from CustomerService");
            } else {
                System.out.println("查询失败...from CustomerService");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查找失败...from CustomerService");
        }
        return customer;
    }

    //获取所有用户的idlist，string类型
    public ArrayList<String> getAllCustomersID() {
        ArrayList<String> allcustomerid = null;
        try {
            //此处报错；
            if (customerMapper.getAllCustomersId() != null)
            {allcustomerid = customerMapper.getAllCustomersId();}
            if (allcustomerid == null) {
                System.out.println("查询失败...from CustomerService");
            } else {
                System.out.println("查询成功...from CustomerService");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库错误...from CustomerService");
        }
        return allcustomerid;

    }

    //获取在住客人情况报告
    public ArrayList<CustomerReport> getCustomerReport(int choice) {
        ArrayList<CustomerReport> arrayList = new ArrayList<>();
        try {
            List<HashMap<String, Object>> r = null;
            switch (choice) {
                case 1: {
                    r = customerMapper.queryCustomersLiving();
                    break;
                }
                case 2: {
                    r = customerMapper.queryCustomersPreservation();
                    break;
                }
                case 3: {
                    r = customerMapper.queryCustomersLived();
                    break;
                }
                default: {
                    r = customerMapper.queryCustomersLiving();
                    break;
                }
            }
            for (HashMap<String, Object> hashMap : r) {
                String userID = String.valueOf(hashMap.get("customer_id"));
                String IDNumber = String.valueOf(hashMap.get("id_card"));
                String customerName = String.valueOf(hashMap.get("realname"));
                String roomID = String.valueOf(hashMap.get("room_number"));
                String dateBegin = DateTransform.Date2String((Date) hashMap.get("start_time"));
                String dateEnd = DateTransform.Date2String((Date) hashMap.get("end_time"));


                CustomerReport customerReport1 = new CustomerReport.Builder(Integer.valueOf(userID)).IDNumber(IDNumber)
                        .customerName(customerName).roomID(Integer.valueOf(roomID)).startTime(dateBegin).endTime(dateEnd)
                        .build();
                arrayList.add(customerReport1);
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        if (arrayList != null && arrayList.size() != 0) {
            System.out.println("查询客户情况报表成功");
        } else {
            System.out.println("查询客户情况报表失败！");
        }
        return arrayList;
    }

    public HashMap<String, Integer> getUnavailableRoom(Date startTime, Date endTime) {
        HashMap<String, Integer> hashMap = new HashMap<>(); //注意这个不能设置为null初始值，否则无法放入内容
        try {
            List<HashMap<String, Integer>> hashMaps = null;
            hashMaps = customerMapper.getUnavailableRoomTypeWithNumber(startTime, endTime);
            if (hashMaps != null)
            {for (HashMap<String, Integer> hashMap1 : hashMaps) {
                    //数据库的int型获取的是Long型，需要转换
                    hashMap.put(String.valueOf(hashMap1.get("room_type")), ((Number) hashMap1.get("number")).intValue());
                }}
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (hashMap != null)
        {System.out.println("查询成功...from CustomerService");}
        else
        {System.out.println("查询失败...from CustomerService");}
        return hashMap;
    }

    //获取所有用户
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> arrayList = null;
        try {
            arrayList = customerMapper.getAllCustomers();
        } catch (Exception e) {
            System.out.println("something went wrong...from Service");
            e.printStackTrace();
        }
        return arrayList;
    }


    //改

    public int updateUser(Customer customer) {
        try {
            ans = customerMapper.updateUser(customer);
            System.out.println("修改用户信息成功...from CustomerService");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改用户信息失败...from CustomerService");
        }
        return ans;
    }


}
