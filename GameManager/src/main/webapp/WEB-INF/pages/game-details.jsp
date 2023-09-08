<%@page import="fr.eni.gamemanager.bo.Game"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Game game = (Game) request.getAttribute("game"); %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/style.css" />
	<title>Détails Game</title>
</head>
<body>
	<div class="container">		
		<header class="row" >
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="#">GameManager <i class="fa-brands fa-playstation"></i></a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarNav">
			      <ul class="navbar-nav">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="#">Accueil</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="<%= request.getContextPath() %>/jeux/ajouter">Ajouter un jeu</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="<%= request.getContextPath() %>/jeux">Liste de jeux</a>
			        </li>
			      </ul>
			      
			    </div>
			  </div>
			</nav>
		</header>
		<main class="row">
			<div class="col">
				<div class="row text-center mt-4">
					<h1> Détails game </h1>
				</div>
				<div class="row mt-5">
					<div class="col-4 offset-4">
						<div class="mb-3">
						  <label for="name" class="form-label">Nom:</label>
						  <input type="text" class="form-control" readonly="readonly" value="<%=game.getName() %>" id="name" >
						</div>
						<div class="mb-3">
						  <label for="company" class="form-label">éditeur:</label>
						  <input type="text" class="form-control" readonly="readonly" value="<%=game.getCompany() %>" id="company" >
						</div>
						<div class="mb-3">
						  <label for="cat" class="form-label">Catégorie:</label>
						  <input type="text" class="form-control" readonly="readonly" value="<%=game.getCategory() %>" id="cat" >
						</div>
						<div class="mb-3">
						  <label for="price" class="form-label">Prix:</label>
						  <input type="text" class="form-control" readonly="readonly" value="<%=game.getPrice() %>" id="price" >
						</div>
						<div class="mb-3">
						  <label for="releaseDate" class="form-label">Date de sortie:</label>
						  <input type="text" class="form-control" readonly="readonly" value="<%=game.getReleaseDate() %>" id="releaseDate" >
						</div>
						<div class="mb-3">
						  <label for="pegi" class="form-label">PEGI:</label>
						  <input type="text" class="form-control" readonly="readonly" value="<%=game.getAge() %>" id="pegi" >
						</div>
						<div class="mb-3">
						  <label for="format" class="form-label">Format:</label>
						  <input type="text" class="form-control" readonly="readonly" value="<%=game.getFormat() %>" id="format" >
						</div>
						<div class="mb-3">
						  <label for="version" class="form-label">Version:</label>
						  <input type="text" class="form-control" readonly="readonly" value="<%=game.getVersion() %>" id="version" >
						</div>
						<div class="mb-3 text-center mt-5">
							<a class="btn btn-info"  ><i class="fa-solid fa-pen"></i></a>
							<a class="btn btn-primary" href="<%= request.getContextPath() %>/jeux/ajouter" ><i class="fa-solid fa-plus"></i></a>
							<a class="btn btn-danger" ><i class="fa-solid fa-trash"></i></a>
						</div>
					</div>
				</div>			
			</div>
		</main>
		<footer class="row text-center text-white bg-dark mt-5">
			<p class="my-4" >GameManager &copy; <%= LocalDate.now().getYear() %> 😊</p>
		</footer>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>