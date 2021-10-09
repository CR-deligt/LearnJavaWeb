package com.qujia.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //检查用户名密码是否正确
        if(username.equals("qujia123")&&password.equals("666666")){
            //登陆成功
            Cookie cookie = new Cookie("username","username");
            cookie.setMaxAge(60*60*24);//设置存活时间（有效时间一天）
            resp.addCookie(cookie);//将用户名保存，有效时间内登录用cookie自己填用户名
            System.out.println("登陆成功");
        }else{
            //登陆失败
            System.out.println("登陆失败");
        }
    }
}
