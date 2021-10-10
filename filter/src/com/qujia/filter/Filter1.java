package com.qujia.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter1前置代码");
        System.out.println("Filter1线程:"+Thread.currentThread().getName());
        servletRequest.setAttribute("key","value1");
        filterChain.doFilter(servletRequest,servletResponse);
        //多个Filter过滤器,用filterChain的执行顺序是web.xml中的从上到下配置顺序
        //多个Filter执行和目标资源默认同一个线程，且使用同一个request对象
        System.out.println("Filter1后置代码");
        System.out.println("Filter1线程:"+Thread.currentThread().getName());
    }

    @Override
    public void destroy() {

    }
}
