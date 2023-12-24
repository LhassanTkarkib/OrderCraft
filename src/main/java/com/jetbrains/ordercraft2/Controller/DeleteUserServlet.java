package com.jetbrains.ordercraft2.Controller;


import com.jetbrains.ordercraft2.Dao.Implimentation.UserDaoImpl;
import com.jetbrains.ordercraft2.Dao.Interface.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        UserDao userDao = new UserDaoImpl();

        if (userDao.getUserByEmail(email) != null) {
            userDao.deleteUserByEmail(email);
            response.sendRedirect(request.getContextPath() + "/admin?action=manageUsers");
        } else {
            System.out.println("user not found");
        }
    }

}

