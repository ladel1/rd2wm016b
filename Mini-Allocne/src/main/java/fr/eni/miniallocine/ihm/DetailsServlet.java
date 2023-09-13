package fr.eni.miniallocine.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.miniallocine.bll.TitreManager;

@WebServlet("/titres/details")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt( request.getParameter("id") );
			// charger le titre
			request.setAttribute("titre", 
					TitreManager.getInstance().unTitre(id)
					);
			// délegation
			request.getRequestDispatcher("/WEB-INF/pages/details.jsp")
			.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}



}
