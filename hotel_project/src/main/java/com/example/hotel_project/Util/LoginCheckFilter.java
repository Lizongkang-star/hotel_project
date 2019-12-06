package com.example.hotel_project.Util;


import com.example.hotel_project.Model.Customer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {"/*"})
@Order(FilterRegistrationBean.LOWEST_PRECEDENCE - 2)
public class LoginCheckFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String url = request.getParameter("url") == null ? "" : request.getParameter("url");
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Customer loginedCustomer = (Customer) session.getAttribute("LoginedCustomer");
        String requestPath = request.getServletPath();
        chain.doFilter(req, resp);
        /*
        System.out.println(url);
        System.out.println(requestPath);
        if (loginedCustomer != null
                || requestPath.endsWith("Login")
                || requestPath.endsWith("login")
                || requestPath.endsWith("Register") || url.endsWith("Login")
                || url.endsWith("Register") || url.endsWith("index")
                || url.endsWith("login")) {
            chain.doFilter(req, resp);
        } else {
            response.setHeader("Refresh", "1; URL=go?url=index");
        }
        */
    }


}
