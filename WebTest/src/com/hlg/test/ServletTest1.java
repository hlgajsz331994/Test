package com.hlg.test;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/12.
 */
public class ServletTest1 implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("----init");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("----getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("----service");
    }

    @Override
    public String getServletInfo() {
        System.out.println("----getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("----destroy");
    }
}
