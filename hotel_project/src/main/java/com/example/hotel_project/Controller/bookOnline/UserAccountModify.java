package com.example.hotel_project.Controller.bookOnline;

import com.example.hotel_project.Controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("CustomerAccountModifyID")
public class UserAccountModify extends BaseController {


    @RequestMapping("basicSetting/CustomerAccountModifyID")
    public ModelAndView CustomerAccountmodifyid() {
        //方法体

        return mv;
    }
}
