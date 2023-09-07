<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="false"
    errorPage="/erreur.jsp"
    %>
<% String titre = "Accueil"; %>
<% String [] nav = {"Accueil","Contact","Blog","A propos"};  %>
<% String str = null ;  str.length(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=titre %></title>
</head>
<body>
<ul>
	<% for( String item : nav ){ %>
		<li><%=item %></li>
	<% } %>		
</ul>
<h1><%=titre %></h1>
</body>
</html>