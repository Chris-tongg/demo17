<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script>
        function btn1() {
            var chooseAll = document.getElementsByName("chooseAll")[0];
            var choose = document.getElementsByName("choose");
            for (var i = 0;i<choose.length;i++){
                if (chooseAll.checked){
                    choose[i].checked = true;
                }else{
                    choose[i].checked = false;
                }
            }
        }
        function btn2() {
            var chooseAll = document.getElementsByName("chooseAll")[0];
            var choose = document.getElementsByName("choose");
            for (var i = 0; i < choose.length; i++) {
                if (choose[i].checked == false) {
                    chooseAll.checked = false;
                }
            }
        }
    </script>
</head>
<body>
<form action="ScoreServlet?action=deleteChoose" method="post">
    <table border="1" cellspacing="0">
        <thead>
        <tr>
            <th>
                <input type="checkbox" name="chooseAll" onclick="btn1()">全选<br/>
            </th>
            <th>编号</th>
            <th>学科</th>
            <th>成绩</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="score">
            <tr>
                <td><input type="checkbox" name="choose" onclick="btn2()" value="${score.id}"></td>
                <td>${score.id}</td>
                <td>${score.subject}</td>
                <td>${score.score}</td>
                <td>
                    <a href="ScoreServlet?action=getScoreById&id=${score.id}">编辑</a>
                    <a href="ScoreServlet?action=deleteScore&id=${score.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="5" style="text-align: center">
                <input type="submit" value="删除选中项"><a/>
                <a href="addScore.jsp">添加</a>
            </td>
        </tr>
        </tfoot>
    </table>
</form>
</body>
</html>
