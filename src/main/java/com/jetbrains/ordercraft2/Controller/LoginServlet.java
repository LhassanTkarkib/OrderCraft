package com.jetbrains.ordercraft2.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth/login")


public class LoginServlet extends HttpServlet {

    private static final String loginForm = "/WEB-INF/views/login.jsp";
    private static final String vue = "/WEB-INF/views/welcome.jsp";



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Show the login page
        System.out.println("LoginServlet.doGet()");
        getServletContext().getRequestDispatcher(loginForm).forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Handle form submission and redirect to welcome.jsp
        System.out.println("LoginServlet.doPost()");
        getServletContext().getRequestDispatcher(vue).forward(request, response);
    }


}
