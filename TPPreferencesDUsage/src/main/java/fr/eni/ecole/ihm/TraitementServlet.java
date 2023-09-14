package fr.eni.ecole.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Iterator;

@WebServlet("")// racine
public class TraitementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean flag = true;
		
		Cookie [] cookies = request.getCookies();
		int compteur = 1;
		
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("compteur")) {
					compteur = Integer.parseInt( cookie.getValue() );
					compteur++;
					cookie.setValue(compteur+"");
					response.addCookie(cookie);
					flag = false;
				}
			}
		}
		
		
		if(flag) {	
			Cookie cookie = new Cookie("compteur", "1");
			response.addCookie(cookie);			
		}
		
		request.setAttribute("compteur", compteur);
		request.getRequestDispatcher("/WEB-INF/pages/accueil.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String couleur = request.getParameter("couleur");
		HttpSession session = request.getSession();
		session.setAttribute("couleur", couleur);
		doGet(request, response);
	}

}
