package com.unicom.smartcity.servlet;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

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

//    private Log logger = LogFactory.getLog(LoginServlet.class);


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
//        logger.info(username);
        String password = request.getParameter("password");
//        logger.info(password);

    }
}
