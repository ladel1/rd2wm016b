<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<h1>Accueil</h1>

	
	<h2>Voitures</h2>
	<c:forEach var="voiture" items="${ voitures }" >
		<p>  ${ voiture.marque } - ${ voiture.model } - ${ voiture.vitesseMax } </p>
	</c:forEach>
	
	<hr/>
	<h2>Personnes</h2>
	<c:forEach var="personne" items="${ personnes }" >
		<c:if test="${ personne.age >= 18 }">
			<p> ${ personne.prenom } ${ personne.nom } (${ personne.age }ans)</p>
		</c:if>
	</c:forEach>
	<hr>
		<h2>Personnes</h2>
	<c:forEach var="personne" items="${ personnes }" >
		<c:choose>
			<c:when test="${ personne.age>=18 }">
				<p style="color:blue" > ${ personne.prenom } ${ fn:toUpperCase(personne.nom) } (${ personne.age }ans)</p>
			</c:when>
			<c:otherwise>
				<p style="color:green" > ${ personne.prenom } ${ fn:toUpperCase(personne.nom) } (${ personne.age }ans)</p>
			</c:otherwise>
		</c:choose>
			
	
	</c:forEach>
		


</body>
</html>