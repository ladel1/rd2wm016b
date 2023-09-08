package fr.eni.gamemanager.ihm;

import java.io.IOException;
import java.util.List;

import fr.eni.gamemanager.bll.GameManager;
import fr.eni.gamemanager.bo.Game;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jeux")
public class ListGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Game> games = GameManager.getInstance().recupTousLesJeux();
		request.setAttribute("games", games);
		request.getRequestDispatcher("/WEB-INF/pages/games.jsp")
		       .forward(request, response);
	}
}
