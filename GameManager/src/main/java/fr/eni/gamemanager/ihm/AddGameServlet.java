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

@WebServlet("/jeux/ajouter")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// afficher la page d'ajout
		request.getRequestDispatcher("/WEB-INF/pages/game-add.jsp")
			   .forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
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
			Game game = new Game(0, name, company, cat, price, releaseDate, pegi, format, version);
			
			// Add
			GameManager.getInstance().ajouterUnJeu(game);
			// redirect
			response.sendRedirect( request.getContextPath() +"/jeux");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
