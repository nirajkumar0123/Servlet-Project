package com.tit.myfirstservlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Define the URL mapping for this servlet
@WebServlet("/HelloWorldServlet")
public class HelloWorld extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Print different response
        response.getWriter().println("<h1>Hello from HelloWorldServlet!</h1>");
        response.getWriter().println("<p>This is a different message printed from the servlet.</p>");
    }
}