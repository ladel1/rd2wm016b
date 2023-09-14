<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% int compteur = (int) request.getAttribute("compteur");  %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<h1>Accueil</h1>
<form method="POST" action="" >
	<select name="couleur" >
		<%
			for( String couleur: application
									.getInitParameter("COULEURS")
									.split(",") ){
		%>		
			<% if( couleur.equals( session.getAttribute("couleur") ) ){ %>
				<option selected="selected"><%=couleur %></option>		
			<% }else{ %>
				<option><%=couleur %></option>	
			<% } %>
		<% } %>
	</select> 
	<input type="submit" value="Valider" > 
</form>

<p>
	Vous êtes venu <%=compteur %> fois
</p>
<a href="<%=request.getContextPath() %>/une-page" >Une page JSP</a>
</body>
</html>