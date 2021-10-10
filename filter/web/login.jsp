<%--
  Created by IntelliJ IDEA.
  User: 29910
  Date: 2021/10/9
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    登陆页面<br>
    <form action="http://localhost:8080/filter/loginServlet" method="get">
        用户名：<input type="text" name="username"/><br/>
        密码：<input type="password" name="password"/><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
