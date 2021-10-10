package com.qujia.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    //先要写一个类来实现接口
    // 注意还要 在web.xml  filter标签用于配置一个filter过滤器
    //1.2.Filter的构造和初始化在web工程启动时执行
    //3.每次拦截到请求就会执行doFilter
    //4.web工程停止时会销毁Filter
    public AdminFilter(){
        System.out.println("1.Filter构造器方法AdminFilter()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter的初始化init(FilterConfig filterConfig)");
        /*FilterConfig类：
        *   获取filter的配置信息
        * */
        System.out.println("filter-name:"+filterConfig.getFilterName());
        //获取在web.xml配置的init-param信息
        System.out.println("初始化参数username的值："+filterConfig.getInitParameter("username"));//获取在web.xml配置的init-param信息
        System.out.println("初始化参数url的值："+filterConfig.getInitParameter("url"));
        //获取ServletContext()对象
        System.out.println(filterConfig.getServletContext());
    }

    /**
     * doFilter（过滤方法） 用于拦截请求，可以做权限检查
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.Filter的doFilter()");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        //如果等于null则说明没有登录
        if(user==null){
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);//请求转发
            return;
        }else{
            //权限检查通过继续访问
            //十分重要！！！否则检查完以后不会继续访问用户资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4.Filter的销毁方法");
    }
}
