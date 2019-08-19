<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ScoreServlet">
    <input type="hidden" value="addScore" name="action">
    学科：<input type="text" name="subject"><br/>
    成绩：<input type="text" name="score"><br/>
    s_id：<input type="text" name="s_id"><br/>
    <input type="submit" value="添加">
</form>
</body>
</html>
