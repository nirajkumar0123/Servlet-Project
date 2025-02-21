package com.tit.loginservlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Hardcoded list of users (username -> password)
    private static final Map<String, String> users = new HashMap<>();

    // Initialize user credentials (static block runs once when the class loads)
    static {
        users.put("admin", "password123");
        users.put("user1", "pass123");
        users.put("user2", "welcome456");
        users.put("guest", "guestpass");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get username and password from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate user credentials
        if (users.containsKey(username) && users.get(username).equals(password)) {
            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            // Redirect to welcome page
            response.sendRedirect("welcome.jsp");
        } else {
            // Redirect to error page
            response.sendRedirect("error.jsp");
        }
    }
}