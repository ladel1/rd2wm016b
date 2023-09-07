package fr.eni.ecole.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/tentative")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random rd = new Random();
	private final static int CHI = 1;
	private final static int FOU = 2;
	private final static int MI = 3;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/tentative.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			// init data
			int userChoice = Integer.parseInt( 
					request.getParameter("user-choice")
					);
			int serverChoice = rd.nextInt(CHI, MI+1);
			// traitement
			int resultat = 0;			
			if(userChoice==serverChoice) {// egalité
				resultat = 0; // Draw
			}else if(
						(userChoice == CHI && serverChoice == MI) ||
						(userChoice == FOU && serverChoice == CHI)||
						(userChoice == MI && serverChoice == FOU)
					) {// victoire pour utilisateur
				resultat = 1;
			}else {
				resultat = -1;
			}
			// affichage
			request.setAttribute("resultat", resultat == 0 ? "égalité" : resultat == 1? "Félicitations" :"vous avez perdu"   );
			request.setAttribute("user-choice", userChoice == CHI ? "CHI" : userChoice == MI? "MI" : "FOU" );
			request.setAttribute("server-choice",serverChoice == CHI ? "CHI" : serverChoice == MI? "MI" : "FOU");
			
			request.getRequestDispatcher("/WEB-INF/pages/resultats.jsp")
			.forward(request, response);		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
