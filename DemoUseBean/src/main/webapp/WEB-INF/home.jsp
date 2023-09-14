<%@page import="bo.Voiture"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<h1>Accueil</h1>
	<jsp:useBean id="voiture" scope="request" class="bo.Voiture" />	
	<p>
		<b>Marque:</b>  
		<jsp:getProperty property="marque" name="voiture"/>
	</p>
	<p>
		<b>Model:</b>  
		<jsp:getProperty property="model" name="voiture"/>	
	</p>
	<p>
		<b>Mat:</b>  
		<jsp:getProperty property="mat" name="voiture"/>	
	</p>
	<p>
		<b>Vitesse Max:</b> 
		<jsp:getProperty property="vitesseMax" name="voiture"/> 
	</p>
</body>
</html>