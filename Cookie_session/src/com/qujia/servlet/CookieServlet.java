package com.qujia.servlet;

import com.qujia.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先创建对象
        //Cookie cookie = new Cookie("key1","value1");
        Cookie cookie1 = new Cookie("key2", "value2");
        Cookie cookie2 = new Cookie("key3", "value3");
        Cookie cookie3 = new Cookie("key4", "value4");
        //通知客户端保存Cookie
        //resp.addCookie(cookie);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);

        resp.getWriter().write("Cookie创建成功");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //getName方法返回Cookie的key(名)
            //getValue方法返回Cookie的value值
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");
        }
        Cookie iWantCookie = CookieUtils.findCookie("key2", cookies);
// for(Cookie cookie:cookies){//找单独的cookie只能遍历查找
//     if("key2".equals(cookie.getName())){
//         iWantCookie=cookie;
//         break;
//     }
// }
        if (iWantCookie != null) {
            resp.getWriter().write("需要的Cookie[" + iWantCookie.getName() + "=" + iWantCookie.getValue() + "]<br/>");
        }

    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方法一
        //创建同名cookie覆盖
        Cookie cookie = new Cookie("key2", "newValue2");
        resp.addCookie(cookie);//通知客户端保存修改
        resp.getWriter().write("修改了key2的cookie<br/>");
        //方法二
        //查找对象，用setValue()方法赋新值
        Cookie cookie2 = CookieUtils.findCookie("key3", req.getCookies());
        if(cookie2!=null){//找到时再修改
            cookie2.setValue("newValue3");
            resp.addCookie(cookie2);//通知客户端保存修改
            resp.getWriter().write("修改了key3的cookie");
        }
    }
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);//设置存活时间（默认-1），负数表示关闭浏览器时销毁
        resp.addCookie(cookie);

    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("key4", req.getCookies());
        if(cookie !=null) {
            cookie.setMaxAge(0);//设置存活时间为0，表示立即删除
            resp.addCookie(cookie);
            resp.getWriter().write("key4已经被删除<br/>");
        }
    }
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600","life3600");
        cookie.setMaxAge(60*60);//存活时间，正数表示存活秒数（时间全部按照格林时间）
        resp.addCookie(cookie);
        resp.getWriter().write("创建存活一小时的cookie");
    }
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //path不是指Cookie在客户端存放的路径！！！
        //Path能帮助浏览器过滤cookie，只有出现知道哪个路径才可以将cookie发送给服务器，决定服务器的请求是否会从浏览器中加载某些cookie。
        //默认的path是工程路径  这里是/Cookie_session
        Cookie cookie = new Cookie("path1","path1");
        //getContextPath()得到工程路径
        cookie.setPath(req.getContextPath()+"/abc");//----------->得到 /工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有path路径的cookie");
    }
}
