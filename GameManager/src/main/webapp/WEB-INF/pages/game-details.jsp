<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<main class="row">
	<div class="col">
		<div class="row text-center mt-4">
			<h1> Détails game </h1>
		</div>
		<div class="row mt-5">
			<div class="col-4 offset-4">
				<div class="mb-3">
				  <label for="name" class="form-label">Nom:</label>
				  <input type="text" class="form-control" readonly="readonly" value="${ game.name }" id="name" >
				</div>
				<div class="mb-3">
				  <label for="company" class="form-label">éditeur:</label>
				  <input type="text" class="form-control" readonly="readonly" value="${ game.company }" id="company" >
				</div>
				<div class="mb-3">
				  <label for="cat" class="form-label">Catégorie:</label>
				  <input type="text" class="form-control" readonly="readonly" value="${ game.category }" id="cat" >
				</div>
				<div class="mb-3">
				  <label for="price" class="form-label">Prix:</label>
				  <input type="text" class="form-control" readonly="readonly" value="${ game.price }" id="price" >
				</div>
				<div class="mb-3">
				  <label for="releaseDate" class="form-label">Date de sortie:</label>
				  <input type="text" class="form-control" readonly="readonly" value="${ game.releaseDate }" id="releaseDate" >
				</div>
				<div class="mb-3">
				  <label for="pegi" class="form-label">PEGI:</label>
				  <input type="text" class="form-control" readonly="readonly" value="${ game.age }" id="pegi" >
				</div>
				<div class="mb-3">
				  <label for="format" class="form-label">Format:</label>
				  <input type="text" class="form-control" readonly="readonly" value="${ game.format }" id="format" >
				</div>
				<div class="mb-3">
				  <label for="version" class="form-label">Version:</label>
				  <input type="text" class="form-control" readonly="readonly" value="${ game.version }" id="version" >
				</div>
				<form method="POST" action="${ pageContext.request.contextPath }/jeux/supprimer" onsubmit="return confirm('Voulez-vous vraiment supprimer ce jeu ?')" >											
					<div class="mb-3 text-center mt-5">
						<a class="btn btn-info" href="${ pageContext.request.contextPath }/jeux/modifier?id=${ game.id }" ><i class="fa-solid fa-pen"></i></a>
						<a class="btn btn-primary" href="${ pageContext.request.contextPath }/jeux/ajouter" ><i class="fa-solid fa-plus"></i></a>
						<button type="submit" name="id" value="${ game.id }" 
						class="btn btn-danger" ><i class="fa-solid fa-trash"></i></button>
					</div>
				</form>
			</div>
		</div>			
	</div>
</main>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>