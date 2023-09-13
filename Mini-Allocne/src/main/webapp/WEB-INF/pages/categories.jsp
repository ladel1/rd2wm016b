<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<String> categories = (List<String>) request.getAttribute("categories");%> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste de categories</title>
</head>
<body>
	<div class="container">
		<main>
			
			<% for(String cat : categories){ %>
				<div class="item">
					<a href="<%= request.getContextPath() %>/categories/<%=cat %>"> <%=cat %> </a>
				</div>
			<% } %>
			
		</main>
	</div>
</body>
</html>