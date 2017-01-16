package com.lukye.JavaWebLab;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletExample extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute ("servletName", "servletToJsp");
        getServletConfig().getServletContext().getRequestDispatcher(
                "/jsp/jsptoserv/hello.jsp").forward(req, resp);
    }
}
