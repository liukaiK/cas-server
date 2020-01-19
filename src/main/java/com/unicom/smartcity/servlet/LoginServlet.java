package com.unicom.smartcity.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * 登录servlet
 *
 * @author liukai
 */
public class LoginServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().toString());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        logger.info("username: " + username);
        String password = request.getParameter("password");
        logger.info("password: " + password);
    }


}
