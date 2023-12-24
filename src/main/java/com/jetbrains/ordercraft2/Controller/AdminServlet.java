package com.jetbrains.ordercraft2.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private static final String adminDashboard = "/WEB-INF/views/admin.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "manageUsers":
                    request.setAttribute("action", action);
                    request.getRequestDispatcher(adminDashboard).forward(request, response);
                    break;
                case "manageProducts":
                    request.setAttribute("action", action);
                    request.getRequestDispatcher(adminDashboard).forward(request, response);
                    break;
                case "manageOrders":
                    request.setAttribute("action", action);
                    request.getRequestDispatcher(adminDashboard).forward(request, response);
                    break;

                default:

            }
        } else {

        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        }


}
