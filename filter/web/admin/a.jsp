<%--
  Created by IntelliJ IDEA.
  User: 29910
  Date: 2021/10/9
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("a.jsp页面执行");
        Object user = session.getAttribute("user");
        //如果等于null则说明没有登录
        if(user==null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);//请求转发
            return;
        }
    %>
    我是a.jsp
</body>
</html>
