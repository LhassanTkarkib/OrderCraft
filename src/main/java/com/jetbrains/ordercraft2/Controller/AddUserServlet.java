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

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");


        UserDao userDao = new UserDaoImpl();
        if (userDao.getUserByEmail(email) == null) {
            userDao.addUser(new User(name, email, password, false));
            request.setAttribute("Message", "this user already exists.");
        } else {
            request.setAttribute("Message", "this user already exists.");
        }
        response.sendRedirect(request.getContextPath() + "/admin?action=manageUsers");

    }

}
