package fr.eni.gamemanager.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

import fr.eni.gamemanager.bo.Passport;
import fr.eni.gamemanager.bo.User;
import fr.eni.gamemanager.helper.HttpServer;

@WebServlet("/deconnexion")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cookie cookie = HttpServer.getCookie(request, "rememberMe");
		// invalider la session de l'utilisateur connecté
		session.setAttribute("passport", null);
		session.invalidate();
		
		if(cookie==null) {
			response.sendRedirect(request.getContextPath()+ "/jeux");
			return;
		}
		
		// supprimer le token de la mémoire
		String token = cookie.getValue();		
		HttpServer.removeRememberMe(request, token);
		response.sendRedirect(request.getContextPath()+ "/jeux");
	}
}
