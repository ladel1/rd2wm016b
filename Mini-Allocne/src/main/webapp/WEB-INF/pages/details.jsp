<%@page import="fr.eni.miniallocine.bo.Serie"%>
<%@page import="fr.eni.miniallocine.bo.Film"%>
<%@page import="fr.eni.miniallocine.bo.Titre"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  Titre titre = (Titre) request.getAttribute("titre"); %>
<% String type = (titre instanceof Film)? "Film":"Série"; %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Détais <%=type %></title>
</head>
<body>

	<h1>Détails <%=type %></h1>
	<p><b>Titre: </b>  <%=titre.getNom() %></p>
	<p><b>Genre: </b>  <a href="<%= request.getContextPath() %>/categories/<%=titre.getGenre() %>" > <%=titre.getGenre() %> </a></p>
	<p><b>Réalisateur: </b>  <%=titre.getRealisateur() %></p>
	<p><b>Durée: </b>  <%=titre.getDuree() %></p>
	<p><b>Date de sortie: </b>  <%=titre.getDateSortie() %></p>
	<p><b>Platforme: </b>  <%=titre.getPlatformeStreaming() %></p>
	
	<% if( titre instanceof Serie ){ %>
		<% Serie serie = (Serie) titre; %>
		<p><b>Nombre d'episodes: </b>  <%=serie.getNombreEpisodes() %></p>
		<p><b>Nombre de saisons: </b>  <%=serie.getNombreSaisons() %></p>
	<% }else{ %>
		<% Film film = (Film) titre; %>
		<p><b>Nombre d'oscras: </b>  <%= film.getNombreOscars() %></p>
	<% } %>
</body>
</html>