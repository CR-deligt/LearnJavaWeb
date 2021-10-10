package com.qujia.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8 ");
        String username = req.getParameter("username");//一种取参数的方法 把jsp文件中的数据读取到出来。
        String password = req.getParameter("password");

        if(username.equals("qujia123")&&password.equals("666666")){
            req.getSession().setAttribute("user",username);//登陆成功后存放用户登录信息，方便之后的检查
            resp.getWriter().write("登陆成功");
        }else{
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
