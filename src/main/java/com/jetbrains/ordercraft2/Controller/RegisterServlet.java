package com.jetbrains.ordercraft2.Controller;

import com.jetbrains.ordercraft2.Dao.Implimentation.UserDaoImpl;
import com.jetbrains.ordercraft2.Dao.Interface.UserDao;
import com.jetbrains.ordercraft2.Model.Classes.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")


public class RegisterServlet extends HttpServlet {
    private UserDao userDao;

    public void init() throws ServletException {
        super.init();
        userDao = new UserDaoImpl(); // Instantiate using the interface type
    }

    private static final String loginForm = "/WEB-INF/views/loginM.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(loginForm).forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User newUser = new User(name, email, password, false);
        userDao.addUser(newUser);
        response.sendRedirect(request.getContextPath() + "/auth/login");

    }


}
