package com.qujia.servlet;

import com.google.gson.Gson;
import com.qujia.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {
    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax请求过来了");
        //响应
        Person person = new Person(1,"曲佳");
        //先转为json格式字符串
        Gson gson = new Gson();
        String personToString = gson.toJson(person);
        resp.getWriter().write(personToString);
    }
    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryAjax请求过来了");
        //响应
        Person person = new Person(1,"曲佳");
        //先转为json格式字符串
        Gson gson = new Gson();
        String personToString = gson.toJson(person);
        resp.getWriter().write(personToString);
    }
    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryGet请求过来了");
        //响应
        Person person = new Person(1,"曲佳");
        //先转为json格式字符串
        Gson gson = new Gson();
        String personToString = gson.toJson(person);
        resp.getWriter().write(personToString);
    }
    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryPost请求过来了");
        //响应
        Person person = new Person(1,"曲佳");
        //先转为json格式字符串
        Gson gson = new Gson();
        String personToString = gson.toJson(person);
        resp.getWriter().write(personToString);
    }
    protected void jQueryGetJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryGetJson请求过来了");
        //响应
        Person person = new Person(1,"曲佳");
        //先转为json格式字符串
        Gson gson = new Gson();
        String personToString = gson.toJson(person);
        resp.getWriter().write(personToString);
    }
    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerySerialize请求过来了");

        System.out.println("用户名："+req.getParameter("username"));
        System.out.println("密码："+req.getParameter("password"));
        //响应
        Person person = new Person(1,"曲佳");
        //先转为json格式字符串
        Gson gson = new Gson();
        String personToString = gson.toJson(person);
        resp.getWriter().write(personToString);
    }
}
