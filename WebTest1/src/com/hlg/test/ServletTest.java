package com.hlg.test;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/12.
 */
public class ServletTest extends MyGenericServlet {

    @Override
    public void destroy() {
        System.out.println("----destroy");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void init() throws ServletException {
        System.out.println("ServletTest ----init");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("----service");
    }
}
