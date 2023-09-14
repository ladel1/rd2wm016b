<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragments/header.jspf" %>
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
						<c:forEach var="game" items="${ games }" >
							<tr>
								<td>${ game.id }</td>
								<td>${ game.name }</td>
								<td>${ game.company }</td>
								<td>${ game.category }</td>
								<td>${ game.price }</td>
								<td>
									<a class="btn btn-dark" 
										href="${ pageContext.request.contextPath }/jeux/détails?id=${ game.id }">
										<i class="fa-solid fa-eye"></i>
									</a> 
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>			
	</div>
</main>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>