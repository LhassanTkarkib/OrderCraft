package com.jetbrains.ordercraft2;
import jakarta.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SimpleLifecycleServlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void init() throws ServletException {
        // Initialization code goes here
        System.out.println("Servlet is being initialized.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the response content type
        response.setContentType("text/html");

        // Get a PrintWriter object to send HTML response
        PrintWriter out = response.getWriter();

        // Write the HTML response for GET request
        out.println("<html><body>");
        out.println("<h2>Hello, this is a simple servlet!</h2>");
        out.println("<p>GET request processed.</p>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the response content type
        response.setContentType("text/html");

        // Get a PrintWriter object to send HTML response
        PrintWriter out = response.getWriter();

        // Write the HTML response for POST request
        out.println("<html><body>");
        out.println("<h2>Hello, this is a simple servlet!</h2>");
        out.println("<p>POST request processed.</p>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        // Cleanup code goes here
        System.out.println("Servlet is being destroyed.");
    }
}
