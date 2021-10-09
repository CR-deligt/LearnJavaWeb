package com.qujia.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {

    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");//要先获取session才可以往里存数据
        resp.getWriter().write("往session中保存了数据");
    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从session中获取的key1的数据是：" + attribute);
    }

    protected void creatOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取session （第一次创建，之后获取）
        HttpSession session = req.getSession();
        //判断当前session会话是否新创建的
        boolean isNew = session.isNew();
        //获取session会话的唯一标识id
        String id = session.getId();

        resp.getWriter().write("得到的session id:" + id + "<br/>");
        resp.getWriter().write("得到的session是否为新创建的:" + isNew + "<br/>");
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getMaxInactiveInterval()获取session的超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session默认超时时长：" + maxInactiveInterval + "秒");

    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //setMaxInactiveInterval()为单个session设置超时时长
        //正数设定时长
        //负数意为永不超时
        //没有0，但可以用invalidate()立即销毁
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("session超时时长设为3s");
    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.getWriter().write("session设置为已超时（无效）");
    }
}