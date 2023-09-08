package fr.eni.gamemanager.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.gamemanager.bll.GameManager;
import fr.eni.gamemanager.bo.Game;

@WebServlet("/jeux/détails")
public class DetailsGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// récupérer le param dans url
			int id = Integer.parseInt( request.getParameter("id")  );
			// récupérer l'objet game
			Game game =  GameManager.getInstance().recupUnJeu(id);
			// transmettre l'objet vers la jsp
			request.setAttribute("game", game);
			// forward
			request.getRequestDispatcher("/WEB-INF/pages/game-details.jsp")
				   .forward(request, response);
		}catch (Exception e) {
			
			response.sendError(404);
		}
		
		
	}
}
