package com.dong.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginFilter extends BaseFilter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpServletRequest request =(HttpServletRequest)servletRequest;
        //用户如果登录了就进行放行,如果没登录跳转到登录页面
        Integer id = (Integer)request.getSession().getAttribute("id");
        String uri = request.getRequestURI();
        //StringBuffer url = request.getRequestURL();
        System.out.println("uri:"+uri);
        //System.out.println("url:"+url.toString());

        //如果想针对某个 action 请求放行而不是整个 Servlet 请求放行
        //获取 action 属性值进行判断
        //String action = request.getParameter("action");

        if(id != null || uri.endsWith("login.jsp") || uri.endsWith("StudentServlet")|| uri.endsWith("register.jsp") || uri.endsWith("CheckServlet")){
            //放行
            chain.doFilter(request,response);
        }else{
            response.sendRedirect("login.jsp");
        }
    }
}
