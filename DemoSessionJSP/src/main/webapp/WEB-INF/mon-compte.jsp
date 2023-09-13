<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Compte</title>
</head>
<body>
<h1>Bonjour <%=session.getAttribute("name") %> </h1>
<a href="<%= response.encodeURL( request.getContextPath()+ "/deconnexion") %>"> Se déconnecter </a>
</body>
</html>