package fr.eni.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class TraitementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random rd = new Random();

	private int randomNumber;
	private boolean isWin = true;
	
	
	@Override
	public void init() throws ServletException {
		int min = Integer.parseInt( getInitParameter("MIN") );
		int max = Integer.parseInt( getInitParameter("MAX") );
		randomNumber = rd.nextInt(min, max+1);	
		System.out.printf("Le nombre aléatoire: %d ",randomNumber);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {			
			String strNombre = request.getParameter("nombre");
			int nombre = Integer.parseInt(strNombre);
			if(randomNumber == nombre && isWin) {
				// victoire
				isWin = false;
				response.sendRedirect(request.getContextPath()+"/victoire.html");				
			}else {
				// echec
				response.sendRedirect(request.getContextPath()+"/echec.html");
			}
		}catch(NumberFormatException e) {
			response.getWriter().append("Erreur 😒");
		}
	}

}
