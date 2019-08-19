<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/17
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function btn() {
            var username = document.getElementsByName("username")[0];
            var password = document.getElementsByName("password")[0];
            var rePassword = document.getElementsByName("rePassword")[0];
            var span1 = document.getElementsByTagName("span1")[0];
            var span2 = document.getElementsByTagName("span2")[0];
            var i=0;
            var flag = false;
            while (i < username.value.length) {
                if (username.value.charAt(i) != " ") {
                    flag = true;
                }
                i++;
            }
            if (flag == false) {
                span1.innerHTML = "<font color='red'>用户名不能为空<font/>";
                return false;
            }
            if(password.value != rePassword.value){
                span2.innerHTML="<font color='red'>两次密码不一致</font>";
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
${msg}
<form action="StudentServlet?action=register" method="post" onsubmit="return btn()">
    用户名：<input type="text" name="username"><span1></span1><br/>
    密码：<input type="text" name="password"><span1></span1><br/>
    确认密码：<input type="text" name="rePassword"><br/>
    性别：<input type="radio" name="sex" value="man">男<input type="radio" name="sex" value="woman">女<br/>
    爱好：<input type="checkbox" name="hobbys" value="sing">唱
            <input type="checkbox" name="hobbys" value="dance">跳
            <input type="checkbox" name="hobbys" value="rap">rap<br/>
    地址：<select name="address">
        <option value="guangdong">广东</option>
        <option value="guangxi">广西</option>
        </select><br/>
    <input type="submit"value="注册">
</form>
</body>
</html>
