package com.hlg.test;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/10.
 */
public class ServletTestNew implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServletNew ---- init()");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
