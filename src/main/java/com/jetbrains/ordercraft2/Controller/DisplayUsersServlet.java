package com.jetbrains.ordercraft2.Controller;


import com.jetbrains.ordercraft2.Dao.Implimentation.UserDaoImpl;
import com.jetbrains.ordercraft2.Dao.Interface.UserDao;
import com.jetbrains.ordercraft2.Model.Classes.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/DisplayUsersServlet")
public class DisplayUsersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserDao userDao = new UserDaoImpl();

        List<User> users = userDao.getAllUsers();

        request.setAttribute("userList", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin?action=manageUsers");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

}
