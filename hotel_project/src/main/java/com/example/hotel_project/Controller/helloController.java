package com.example.hotel_project.Controller;


import com.example.hotel_project.Model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloController extends BaseController {

    @RequestMapping("/test")
    public ModelAndView TestDemo() {
        System.out.println("hello you");
        //创建的jsp画面，按住ctrl键，鼠标放到hello上就可以看到jsp文件
        mv.setViewName("hello");
        return mv;
    }


    @RequestMapping("/")
    public ModelAndView index(Model model) {
        mv.addObject("name", "defaultPage");
        mv.setViewName("index");
        return mv;
    }

    //for example:insert into database
//    @Autowired
//    CustomerService customerService;

    @GetMapping("/addCustomer")
    public String addUser() {
        Customer customer = new Customer();
        customer.setUsername("123456");
        customer.setReal_name("jack");
        customerService.addCustomer(customer);

        return "hello:" + customer.getReal_name();
    }
}
