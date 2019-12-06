package com.example.hotel_project.Util;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//页面中转控制器,重用一部分代码
public class IntermediateModelAndViewDispatcher {
    public ModelAndView goPage(HttpServletRequest request, HttpServletResponse response, ModelAndView mv, String nextURL, String message) {
        request.setAttribute("nextURL", nextURL);
        request.setAttribute("intermediateTimer", 1);
        request.setAttribute("message", message);
        mv.addObject("request", request);
        mv.addObject("response", response);
        mv.setViewName("General/intermediatePage");
        return mv;
    }

    //页面跳转
    static public ModelAndView trunPage(HttpServletRequest request, HttpServletResponse response, String nextURL, String message) {
        ModelAndView mv = new ModelAndView();
        request.setAttribute("nextURL", nextURL);
        request.setAttribute("intermediateTimer", 1);
        request.setAttribute("message", message);
        mv.addObject("request", request);
        mv.addObject("response", response);
        mv.setViewName("General/intermediatePage");
        return mv;
    }

    //参数跳转
    public ModelAndView goPage2(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, String nextURL) {
        mv.addObject("request", request);
        mv.addObject("response", response);
        mv.setViewName(nextURL);
        return mv;

    }
}
