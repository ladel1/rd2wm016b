<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String name = "Accueil"; %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>	
	<jsp:include page="/WEB-INF/fragments/header.jsp" >
		<jsp:param value="Accueil" name="title"/>
	</jsp:include>		
	<main>
		<h1>Accueil</h1>
		<p>
			blablalababla
		</p>
	</main>		
	<%@ include file="/WEB-INF/fragments/footer.jspf" %>	
</body>
</html>