<%@page import="fr.eni.ecole.bo.Article"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Article article = (Article) request.getAttribute("article"); %>
<!doctype html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Détails Article</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>    
    <div class="container-fluid">
    	<header class="row" >
			<nav class="navbar navbar-expand-lg bg-primary">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="#">Gestion Articles</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarNav">
			      <ul class="navbar-nav">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="#">Accueil</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="#">Détails article</a>
			        </li>			        
			      </ul>
			    </div>
			  </div>
			</nav>    	
    	</header>
    	
    	<main class="row">
    		<div class="row text-center mt-4">
    			<h1>Détails article</h1>
    		</div>
    		<div class="row mt-4">
    			<div class="col-6 offset-3">
    				<table class="table table-info" >
    					<thead>
    						<tr>
								<th>N°</th>
	    						<th>Nom</th>
	    						<th>Date</th>
	    						<th>Prix</th>    						
    						</tr>
    					</thead>
    					<tbody>
    						<tr>
    							<td><%=article.getId() %></td>
    							<td><%=article.getName() %></td>
    							<td><%=article.getDateCreated()%></td>
    							<td><%=article.getPrice() %></td>
    						</tr>
    					</tbody>
    				</table>
    			</div>
    		</div>
    		
    	
    	</main>
    	
    	<footer class="row text-center text-bg-dark py-2" >
    		<p> Gestion article &copy; <%=LocalDate.now().getYear() %> </p>
    	</footer>
    </div>    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>