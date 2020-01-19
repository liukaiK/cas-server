package com.unicom.smartcity.servlet;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录servlet
 *
 * @author liukai
 */
public class LoginServlet extends HttpServlet {


    private Log log = LogFactory.getLog(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        log.info("username: " + username);
        String password = request.getParameter("password");
        log.info("password: " + password);
    }


}
