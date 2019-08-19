package com.dong.controller;

import com.dong.Dao.IScoreDao;
import com.dong.Dao.Impl.ScoreDaoImpl;
import com.dong.entity.Score;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ScoreServlet",urlPatterns = "/ScoreServlet")
public class ScoreServlet extends HttpServlet{
    IScoreDao scoreDao = new ScoreDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String action = req.getParameter("action");
        switch (action){
            case "getListBySid":
                getListBySid(req,resp);
                break;
            case "addScore":
                addScoreById(req,resp);
                break;
            case "updateScore":
                updateScore(req,resp);
                break;
            case "getScoreById":
                getScoreById(req,resp);
                break;
            case "deleteScore":
                deleteScore(req,resp);
                break;
            case "deleteChoose":
                deleteChoose(req,resp);
                break;
            default:
                break;
        }
    }

    private void deleteChoose(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] choose = req.getParameterValues("choose");
        Integer count = 0;
        for (String string:choose){
            count = scoreDao.deleteScore(Integer.parseInt(string));
        }
        if (count>0){
            resp.sendRedirect("ScoreServlet?action=getListBySid");
        }else {
            resp.getWriter().write("<script>alter('删除失败');location.href=ScoreServlet?action=getListBySid</script>");
        }
    }

    private void deleteScore(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        Integer count = scoreDao.deleteScore(Integer.parseInt(id));
        if (count>0){
            resp.sendRedirect("ScoreServlet?action=getListBySid");
        }else {
            resp.getWriter().write("<script>alter('删除失败');location.href=ScoreServlet?action=getListBySid</script>");
        }
    }

    private void getScoreById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Score score = scoreDao.getScoreById(Integer.parseInt(id));

        req.setAttribute("score",score);
        req.getRequestDispatcher("updateScore.jsp").forward(req,resp);
    }

    private void updateScore(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String subject = req.getParameter("subject");
        String score = req.getParameter("score");
        Score score1 = new Score(Integer.parseInt(id),subject,Double.parseDouble(score));

        Integer count = scoreDao.updateScoreById(score1);

        if (count>0){
            resp.sendRedirect("ScoreServlet?action=getListBySid");
        }else {
            resp.getWriter().write("<script>alter('修改失败');location.href=ScoreServlet?action=getListBySid</script>");
        }
    }

    private void addScoreById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String subject = req.getParameter("subject");
        String score = req.getParameter("score");
        String s_id = req.getParameter("s_id");
        Score score1 = new Score(subject, Double.parseDouble(score), Integer.parseInt(s_id));
        Integer count = scoreDao.addScore(score1);
        if (count>0){
            resp.sendRedirect("ScoreServlet?action=getListBySid");
        }else {
            resp.getWriter().write("<script>alert('添加失败');location.href='ScoreServlet?action=getListBySid'</script>");
        }
    }

    private void getListBySid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取存放在session中的id
        Integer id = (Integer) req.getSession().getAttribute("id");
        //业务处理
        List<Score> list = scoreDao.getListBySid(id);
        for (Score score:list){
            System.out.println(score);
        }
        //响应前端
        req.setAttribute("list",list);
        req.getRequestDispatcher("scoreList.jsp").forward(req,resp);
    }


}
