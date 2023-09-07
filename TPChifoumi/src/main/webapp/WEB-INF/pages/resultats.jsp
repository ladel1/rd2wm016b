<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<% 
	String userChoice = (String) request.getAttribute("user-choice");
	String serverChoice = (String) request.getAttribute("server-choice");
	String resultat = (String) request.getAttribute("resultat");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Résultats</title>
</head>
<body>
<h1>Résultats: <%=resultat %></h1>
<h3>Le choix de l'utilsiateur: <%=userChoice %></h3>
<h3>Le choix du serveur: <%=serverChoice %></h3>


<a href="/TPChifoumi/tentative" >Rejouer</a>
</body>
</html>