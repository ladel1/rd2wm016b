<%@page import="fr.eni.miniallocine.bo.Titre"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Titre> titres = (List<Titre>) request.getAttribute("titres");  %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste titres</title>
</head>
<body>
	<div class="container">
		<main>
			<table class="table table-dark">
				<thead>
					<tr>
						<td>N°</td>
						<td>Titre</td>
						<td>Genre</td>
						<td>Réalisateur</td>
						<td>Action</td>
					</tr>					
				</thead>
				<tbody>
					<% for( Titre titre: titres ){ %>
						<tr>
							<td><%=titre.getId() %></td>
							<td><%=titre.getNom() %></td>
							<td><%=titre.getGenre() %></td>
							<td><%=titre.getRealisateur() %></td>
							<td><a href="<%= request.getContextPath() %>/titres/details?id=<%=titre.getId() %>" >Détatils</a></td>
						</tr>
					<% } %>
				</tbody>
			</table>
		</main>
	</div>
</body>
</html>