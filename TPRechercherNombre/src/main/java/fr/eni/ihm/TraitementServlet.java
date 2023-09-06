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
	private final int MIN = 1;
	private final int MAX = 10;
	private int randomNumber = rd.nextInt(MIN, MAX+1);
	private boolean isWin = true;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(randomNumber);
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
