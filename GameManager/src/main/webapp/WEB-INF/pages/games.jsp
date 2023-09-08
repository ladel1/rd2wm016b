<%@page import="fr.eni.gamemanager.bo.Game"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Game> games = (List<Game>) request.getAttribute("games");  %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/style.css" />
	<title>Liste de jeux</title>
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
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
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
	              <form class="d-flex" method="GET" action="" >
			        <input class="form-control me-2" type="search" name="q" placeholder="Recherche..." aria-label="Search">
			        <button class="btn btn-outline-success" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
			      </form>
			    </div>
			  </div>
			</nav>
		</header>
		<main class="row">
			<div class="col">
				<div class="row text-center mt-4">
					<h1> Liste de jeux </h1>
				</div>
				<div class="row mt-5">
					<div class="col-8 offset-2">
						<table class="table table-dark">
							<thead>
								<tr>
									<th>N°</th>
									<th>Nom</th>
									<th>Editeur</th>
									<th>Catégorie</th>
									<th>Prix</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<% for( Game game: games){ %>
									<tr>
										<td><%=game.getId() %></td>
										<td><%=game.getName() %></td>
										<td><%=game.getCompany() %></td>
										<td><%=game.getCategory() %></td>
										<td><%=game.getPrice() %></td>
										<td>
											<a class="btn btn-dark" href="<%= request.getContextPath() %>/jeux/détails?id=<%=game.getId() %>"><i class="fa-solid fa-eye"></i></a> 
										</td>
									</tr>
								<% } %>
							</tbody>
						</table>
					</div>
				</div>			
			</div>
		</main>
		<footer class="row text-center text-white bg-dark">
			<p class="my-4" >GameManager &copy; <%= LocalDate.now().getYear() %> 😊</p>
		</footer>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>