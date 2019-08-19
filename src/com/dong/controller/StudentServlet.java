package com.dong.controller;

import com.dong.Dao.IStudentDao;
import com.dong.Dao.Impl.StudentDaoImpl;
import com.dong.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.Arrays;

@WebServlet(name = "StudentServlet",urlPatterns = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    IStudentDao studentDao = new StudentDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if("zs".equals(username) && "123".equals(password)){
            //登录凭证的设置
            req.getSession().setAttribute("id",1);
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String action = req.getParameter("action");
        switch (action){
            case "register":
                register(req,resp);
                break;
            case "login":
                login(req,resp);
                break;
            default:
                break;
        }
    }
    //登录
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        //业务处理:判断验证码是否正确，判断用户名密码是否存在，
        String codes = (String) req.getSession().getAttribute("codes");
        if (!codes.equals(code)){
            req.setAttribute("msg","验证码不能为空");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

        Integer id = studentDao.checkStudent(username,password);
        //登录成功：记录cookie，存储id到session中
        if (id>0){
            //设置cookie
            String remember = req.getParameter("remember");
            if (remember!=null){
                Cookie cookie = new Cookie("username", URLEncoder.encode(username, "utf-8"));
                cookie.setMaxAge(60*60);
                resp.addCookie(cookie);
            }
            //存储id到session中
            req.getSession().setAttribute("id",id);
            //响应前端
            resp.sendRedirect("index.jsp");
        }else {
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
    //注册
    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String[] hobbys = req.getParameterValues("hobbys");
        String address = req.getParameter("address");

        //业务处理
        //判断用户名是否已存在
        Integer count1 = studentDao.checkUsername(username);
        if (count1>0){
            req.setAttribute("msg","用户名已存在");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }

        String hobby = Arrays.toString(hobbys);
        hobby = hobby.substring(1,hobby.length()-1);
        Student stu = new Student(username,password,sex,hobby,address);
        Integer count2 = studentDao.addStudent(stu);
        //响应前端：注册成功后跳转到login.jsp
        if (count2>0){
            resp.sendRedirect("login.jsp");
        }
    }
}
