package com.qujia.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter2前置代码");
        System.out.println("Filter2线程:"+Thread.currentThread().getName());
        System.out.println("filter2取filter1保存的key："+servletRequest.getAttribute("key"));
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter2后置代码");
        System.out.println("Filter2线程:"+Thread.currentThread().getName());
    }

    @Override
    public void destroy() {

    }
}
