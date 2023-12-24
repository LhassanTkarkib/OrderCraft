package com.jetbrains.ordercraft2.Controller;


import com.jetbrains.ordercraft2.Dao.Implimentation.UserDaoImpl;
import com.jetbrains.ordercraft2.Dao.Interface.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String newName = request.getParameter("name");
        String newEmail = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao userDao = new UserDaoImpl();
        userDao.updateUserById(id, newName, newEmail, password);

        // Redirect back to the admin page or wherever you want
        response.sendRedirect(request.getContextPath() + "/admin?action=manageUsers");
    }

}
