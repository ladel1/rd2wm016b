<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<h1>Accueil</h1>

	<c:forEach var="voiture" items="${ voitures }" >
		<p>  ${ voiture.marque } - ${ voiture.model } - ${ voiture.vitesseMax } </p>
	</c:forEach>

</body>
</html>