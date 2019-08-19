<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ScoreServlet">
    <input type="hidden" value="updateScore" name="action">
    <input type="hidden" value="${score.id}" name="id">
    编号：${score.id}<br/>
    学科：<input type="text" name="subject" value="${score.subject}"><br/>
    成绩：<input type="text" name="score" value="${score.score}"><br/>
    <input type="submit" value="修改">
</form>
</body>
</html>
