package packa;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    //1 2第一次访问创建servlet时会调用
    public HelloServlet() {
        System.out.println("1构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2初始化");
        //获取servlet程序对象别名
        System.out.println("程序HelloServlet的别名"+ servletConfig.getServletName());
        //获取初始化参数的init-param
        System.out.println("初始化username的值是"+ servletConfig.getInitParameter("username"));
        System.out.println("初始化url的值是"+ servletConfig.getInitParameter("url"));
        //获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    /*service专门处理访问请求*/
    //3 每次访问都会调用
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3访问了");
        //强制类型转换
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        //System.out.println(method);
        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }
    }
    public void doGet(){
        System.out.println("GET请求");
    }
    public void doPost(){
        System.out.println("POST请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }
    //4在web工程停止时才调用
    @Override
    public void destroy() {
        System.out.println("4销毁");
    }
}
