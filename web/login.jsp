<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<form action="StudentServlet?action=login" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="text" name="password"><br/>
    <img src="CheckServlet"><input type="text" name="code"><br/>
    免登陆 <input type="checkbox" name="remember"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
