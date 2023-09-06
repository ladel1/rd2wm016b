<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%!
		// déclarations
		// attr
		private int cpt = 0;
		// méthode (getter/setter)
		public int getCpt(){
			return cpt;
		}
		public void setCpt(int cpt){
			this.cpt = cpt;
		}
	%>
	<%
		// scriptlets
		setCpt( getCpt()+1 );
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Démo JSP</title>
</head>
<body>
	<h1>Démo JSP</h1>
	<p>Lorem ipsum</p>
	<p> <b>User Agent:</b> <%= request.getHeader("User-Agent") %> </p>
	<p><% out.print("balbalablabblal"); %>  </p>
	<% response.addHeader("Prenom", "Adel"); %>
	<!-- expression pour afficher -->
	<input type="number" readonly="readonly" value="<%=getCpt() %>" />
</body>
</html>