package fr.eni.demo.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String adminEmail;
	
	@Override
	public void init() throws ServletException {
		adminEmail = this.getInitParameter("ADMIN_EMAIL");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter()
		        .append("<h1>L'email de l'admin est: %s 😊</h1>"
		        		.formatted(adminEmail));
	}


}
