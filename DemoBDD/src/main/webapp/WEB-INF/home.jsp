<%@page import="fr.eni.demo.bo.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Article> articles = (List<Article>) request.getAttribute("articles");  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<h1>Accueil</h1>

	<ul>
		<% for( Article article:articles ){ %>
		
			<li> <%=article.getTitre() %> | <%=article.getAuteur() %> </li>
		
		<% } %>
	</ul>

</body>
</html>