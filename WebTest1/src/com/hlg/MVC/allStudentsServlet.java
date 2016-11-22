package com.hlg.MVC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/16.
 */
public class allStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", Arrays.asList("AA,BB,CC"));
        String path = "showStudent.jsp";
        RequestDispatcher reDis = req.getRequestDispatcher("/" + path);
        reDis.forward(req, resp);


    }

    @Override
    public void init() throws ServletException {
        System.out.println("12345");
    }
}
