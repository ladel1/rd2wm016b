<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
<main class="row">
	<div class="col">
		<div class="row text-center mt-4">
			<h1>Modifier un jeu</h1>
		</div>
		<div class="row mt-5">
			<div class="col-4 offset-4">
				<form action="" method="POST" >	
					<div class="mb-3">
					  <label for="name" class="form-label">Nom:</label>
					  <input type="text" class="form-control"  value="${ game.name }" name="name" id="name" >
					</div>
					<div class="mb-3">
					  <label for="company" class="form-label">éditeur:</label>
					  <input type="text" class="form-control"  value="${ game.company }" name="company" id="company" >
					</div>
					<div class="mb-3">
					  <label for="cat" class="form-label">Catégorie:</label>
					  <input type="text" class="form-control"  value="${ game.category }" name="cat" id="cat" >
					</div>
					<div class="mb-3">
					  <label for="price" class="form-label">Prix:</label>
					  <input type="text" class="form-control"  value="${ game.price }" name="price" id="price" >
					</div>
					<div class="mb-3">
					  <label for="releaseDate" class="form-label">Date de sortie:</label>
					  <input type="text" class="form-control"  value="${ game.releaseDate }" name="releaseDate" id="releaseDate" >
					</div>
					<div class="mb-3">
					  <label for="pegi" class="form-label">PEGI:</label>
					  <input type="text" class="form-control" value="${ game.age }" name="pegi" id="pegi" >
					</div>
					<div class="mb-3">
					  <label for="format" class="form-label">Format:</label>
					  <input type="text" class="form-control"  value="${ game.format }" name="format" id="format" >
					</div>
					<div class="mb-3">
					  <label for="version" class="form-label">Version:</label>
					  <input type="text" class="form-control"  value="${ game.version }" name="version" id="version" >
					</div>
					
					<div class="mb-3 text-center mt-5">
						<button class="btn btn-primary" type="submit" ><i class="fa-regular fa-floppy-disk"></i></button>
						<button class="btn btn-basic"  type="reset" ><i class="fa-solid fa-rotate-right fa-rotate-180"></i></button>
					</div>

				</form>
			</div>
		</div>			
	</div>
</main>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>