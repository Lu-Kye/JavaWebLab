package com.lukye.javaweblab;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Stack:
 * ServletHandler
 * HttpConnection
 * Thread
 */
public class ServletExample extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        req.setAttribute("servletName", "servletExample");
//        resp.sendRedirect("jsp/servletExample.jsp");
        resp.getWriter().print(req.getServletPath());
    }
}
