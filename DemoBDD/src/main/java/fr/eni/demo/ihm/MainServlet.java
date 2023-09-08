package fr.eni.demo.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@WebServlet("")// racine 
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// start connection
		response.setContentType("text/html;charset=UTF-8");
		try {
			Context context = new InitialContext();
			DataSource datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			Connection connection =  datasource.getConnection();			
			response.getWriter().print("<h1> Connected 😁 </h1>");
		} catch (NamingException | SQLException e) {
			response.getWriter().print("<h1> Not Connected 😒 </h1>");
			e.printStackTrace();
		}
		
		
		
	}

}
