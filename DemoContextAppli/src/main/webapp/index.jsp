<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= application.getInitParameter("WEB_APP_NAME") %></title>
</head>
<body>
<h1> <%= application.getInitParameter("WEB_APP_NAME") %> </h1>
<p><%=application.getInitParameter("ADMIN_EMAIL") %></p>
<% application.setAttribute("CONFIG", "n'importe quoi"); %>
</body>
</html>