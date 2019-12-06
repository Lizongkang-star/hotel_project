package com.example.hotel_project.ServerImpl;

import com.example.hotel_project.Model.Employee;
import com.example.hotel_project.Model.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service("EmployeeService")
@Transactional
@SuppressWarnings("all")
public class EmployeeService extends BaseService {
    int ans = 0;

    //包含前台管理

    //增
    public int addEmployee(Employee employee) {
        try {
            ans = employeeMapper.insert(employee);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库错误...from EmployeeService");
        }
        if (ans == 1) {
            System.out.println("员工帐号添加成功...from EmployeeService");
        }
        return ans;
    }

    //删

    public int delEmployeeById(int employeeId) {
        try {
            ans = employeeMapper.deleteEmployeeeById(employeeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ans == 1) {
            System.out.println("员工账号删除成功...from EmployeeService");
        }
        return ans;
    }

    //查

    public ArrayList<String> getAllEmployeesId() {
        ArrayList<String> allemployeeid = null;
        try {
            if (null != employeeMapper.getallemployeeid())
                allemployeeid = employeeMapper.getallemployeeid();
            if (allemployeeid == null) {
                System.out.println("查询失败...from EmployeeService");
            } else {
                System.out.println("查询成功...from EmployeeService");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库错误...from EmployeeService");
        }
        return allemployeeid;
    }

    //登录验证
    public int employeeconfirm(Employee employee) {
        Employee em = null;
        try {
            em = employeeMapper.employeeconfirm(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (em != null) {
            ans = 1;
        } else {
            ans = 0;
        }
        return ans;
    }

    //根据Id查找员工
    public Employee queryById(int i) {
        Employee employee = null;
        try {
            employee = employeeMapper.selectById(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public ArrayList<Employee> getAllEmployee() {
        ArrayList<Employee> arrayList = null;
        try {
            arrayList = employeeMapper.getAllEmployee();
        } catch (Exception e) {
            System.out.println("something went wrong...from Service");
            e.printStackTrace();
        }
        return arrayList;
    }

    public Employee getEmployeeByUsername(String username) {
        Employee employee = null;
        try {
            employee = employeeMapper.getEmployeeByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    //预定签入查询
    public ArrayList<Room> preservationCheckinRoomQuery(int orderId) {
        ArrayList<Room> arrayList = null;
        try {
            arrayList = roomMapper.getAvailableRoomByOrdersId(orderId);
        } catch (Exception e) {
            System.out.println("something went wrong...from Service");
            e.printStackTrace();
        }
        return arrayList;
    }

    //改

    //房间入住
    public int preservationCheckin(int orderId, String roomId) {
        try {
            ans = (ordersMapper.updateStatusByOrderID(orderId, "在住") == 1 && ordersMapper.updateRoomNameByOrderID(orderId, roomId) == 1) ? 1 : 0;
        } catch (Exception e) {
            System.out.println("something went wrong...from Service");
            e.printStackTrace();
        }
        return ans;
    }

    public int updateEmployee(Employee employee) {
        try {
            ans = employeeMapper.updateEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ans == 1) {
            System.out.println("员工信息更新成功");
        }
        return ans;
    }


}
