<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Enchere</title>
  </head>
  <body>
  	<div class="container-fluid">
  		<div class="row mt-5 text-center">
  			<h1>Liste des enchères</h1>
  		</div>
  	</div>
  	<div class="row mt-5">
  		<div class="col-6">
  			<div class="container-fluid">
  				<div class="row">
  					<div class="col-6">
  						<div class="form-check">
						  <input class="form-check-input" checked="true" type="radio" value="achats" onchange="change(event)" name="type" id="achats">
						  <label class="form-check-label" for="achats" >
						    Achats
						  </label>
						</div>
						<div class="container ck-achats">
							<div class="form-check">
							  <input class="form-check-input" type="checkbox" value="" id="eo">
							  <label class="form-check-label" for="eo">
							    Enchères ouvertes
							  </label>
							</div>
							<div class="form-check">
							  <input class="form-check-input" type="checkbox" value="" id="meec">
							  <label class="form-check-label" for="meec">
							    Mes enchères en cours
							  </label>
							</div>
							<div class="form-check">
							  <input class="form-check-input" type="checkbox" value="" id="mer">
							  <label class="form-check-label" for="mer">
							    Mes enchères remportées
							  </label>
							</div>							
						</div>						
  					</div>
  					<div class="col-6">
  						<div class="form-check">
						  <input class="form-check-input" type="radio" name="type" value="mes vente" id="mes_ventes" onchange="change(event)">
						  <label class="form-check-label" for="mes_ventes">
						    Mes ventes
						  </label>
						</div> 
						<div class="container ck-ventes">
							<div class="form-check">
							  <input class="form-check-input" disabled type="checkbox" value="" id="mvec">
							  <label class="form-check-label" for="mvec">
							    Mes vente en cours
							  </label>
							</div>
							<div class="form-check">
							  <input class="form-check-input" disabled type="checkbox" value="" id="vnd">
							  <label class="form-check-label" for="vnd">
							    ventes non débutées
							  </label>
							</div>
							<div class="form-check">
							  <input class="form-check-input" disabled type="checkbox" value="" id="vt">
							  <label class="form-check-label" for="vt">
							    ventes terminées
							  </label>
							</div>							
						</div>						 					
  					</div>
  				</div>
  			</div>
  		</div>
  	</div>
  	<script src="${ pageContext.request.contextPath }/assets/js/main.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  </body>
</html>