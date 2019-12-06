package com.example.hotel_project.ServerImpl;

import com.example.hotel_project.Model.Administrator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("AdministratorService")
@Transactional
@SuppressWarnings("all")
public class AdministratorService extends BaseService {
    int ans = 0;

    //增

    //删

    //查

    //管理员登录
    public Administrator adminlogin(Administrator administrator) {
        Administrator administrator1 = null;
        try {
            administrator1 = administratorMapper.adminconfirm(administrator);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("管理员验证数据库出现错误...from AdminisService");
        }
        if (administrator1 != null) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }
        return administrator1;
    }


    //改

    public int updateAdmin(Administrator administrator) {
        try {
            ans = administratorMapper.updateAdmin(administrator);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ans == 1) {
            System.out.println("管理员密码修改成功 from AdminService");
        }else {
            System.out.println("管理员密码修改失败 from AdminService");
        }
        return ans;
    }

}
