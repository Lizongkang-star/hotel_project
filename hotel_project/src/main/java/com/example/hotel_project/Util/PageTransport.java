package com.example.hotel_project.Util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageTransport {
    ModelAndView mv = new ModelAndView();

    @RequestMapping("go")
    public ModelAndView toPage(HttpServletRequest request, @RequestParam("url") String url) {
        //System.out.println("页面即将跳转...form PageTransport.java");
        mv.setViewName(url);
        return mv;
    }

}
