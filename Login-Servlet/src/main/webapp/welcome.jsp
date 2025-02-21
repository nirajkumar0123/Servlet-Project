<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <%
        HttpSession sessionObj = request.getSession(false);
        if (sessionObj != null && sessionObj.getAttribute("user") != null) {
            String user = (String) sessionObj.getAttribute("user");
    %>
            <h2>Welcome, <%= user %>!</h2>
            <a href="LogoutServlet">Logout</a>
    <%
        } else {
            response.sendRedirect("index.jsp");
        }
    %>
</body>
</html>
