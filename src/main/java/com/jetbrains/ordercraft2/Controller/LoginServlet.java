package com.jetbrains.ordercraft2.Controller;

import com.jetbrains.ordercraft2.Dao.Implimentation.UserDaoImpl;
import com.jetbrains.ordercraft2.Model.Classes.User;
import com.jetbrains.ordercraft2.Dao.Interface.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth/login")


public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    public void init() throws ServletException {
        super.init();
        userDao = new UserDaoImpl();
    }

    private static final String loginForm = "/WEB-INF/views/loginM.jsp";
    private static final String adminDashboard = "/WEB-INF/views/admin.jsp";
    private static final String userDashboard = "/WEB-INF/views/client.jsp";



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(loginForm).forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDao.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            if (user.getRole()) {
                request.getRequestDispatcher(adminDashboard).forward(request, response);
            } else {
                request.getRequestDispatcher(userDashboard).forward(request, response);
            }
        } else {
            request.getRequestDispatcher(loginForm).forward(request, response);
        }
    }



}
