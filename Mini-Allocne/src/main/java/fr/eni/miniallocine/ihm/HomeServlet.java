package fr.eni.miniallocine.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.miniallocine.bll.TitreManager;

@WebServlet("")// racine
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("titres", 
				TitreManager.getInstance().tousTitres()
				);
		request.getRequestDispatcher("/WEB-INF/pages/home.jsp")
		.forward(request, response);
	}
}
