package fr.eni.gamemanager.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import fr.eni.gamemanager.bll.GameManager;
import fr.eni.gamemanager.bo.Game;

@WebServlet("/jeux/modifier")
public class EditGameServlet extends HttpServlet {
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
			request.getRequestDispatcher("/WEB-INF/pages/game-modifier.jsp")
				   .forward(request, response);
		}catch (Exception e) {
			
			response.sendError(404);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// récupérer le param dans url
			int id = Integer.parseInt( request.getParameter("id")  );
			// get data from param
			String name =   request.getParameter("name");
			String company =   request.getParameter("company");
			String cat =   request.getParameter("cat");
			float price =  Float.parseFloat(request.getParameter("price")) ;
			LocalDate releaseDate =  LocalDate.parse(request.getParameter("releaseDate")) ;
			int pegi =  Integer.parseInt(request.getParameter("pegi")) ;
			String format =   request.getParameter("format");
			String version =   request.getParameter("version");			
			// create Game instance
			Game game = new Game(id, name, company, cat, price, releaseDate, pegi, format, version);
			
			// modifier
			GameManager.getInstance().modifierUnJeu(game);
			// redirect
			response.sendRedirect( request.getContextPath() +"/jeux");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
