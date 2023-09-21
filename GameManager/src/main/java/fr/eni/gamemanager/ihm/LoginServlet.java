package fr.eni.gamemanager.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import fr.eni.gamemanager.bll.UserManager;
import fr.eni.gamemanager.bo.Passport;
import fr.eni.gamemanager.bo.User;

@WebServlet("/connexion")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// créer un hashtable pour stocker les sessions en mémoire
		// faut faire attention car des que redémarre le serveur 
		// toutes les session stockées en mémoire seront perdus
		Map<String,Passport> sessions = new HashMap<String, Passport>();
		this.getServletContext().setAttribute("sessions", sessions);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = (String) request.getSession().getAttribute("success");
		request.getSession().removeAttribute("success");
		request.setAttribute("success", message);
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// récupérer le param remember me
		boolean rememberMe = request.getParameter("remember_me")!=null;
		
			
		User user = UserManager.getInstance().login(username, password);
		
		if(user == null) {
			request.setAttribute("error", "Username ou le mot de passe est éronné");
			doGet(request, response);
		}else {
			HttpSession session = request.getSession();
			user.setPassword("");
			Passport passport = new Passport(
					request.getRemoteAddr(), 
					request.getHeader("User-Agent"), 
					user);
			session.setAttribute("passport", passport);
			// si se souvenir de moi est coché alors
			if(rememberMe) { 
				// je génère un id aléatoire
				String token = UUID.randomUUID().toString();
				// je l'ajoute dans le cookie de l'utilisateur
				Cookie cookieSession = new Cookie("rememberMe", token);
				// 30 jours 
				cookieSession.setMaxAge(60*60*24*30);
				// pour empecher les attaques xss
				// https://zestedesavoir.com/articles/pdf/232/les-failles-xss.pdf
				cookieSession.setHttpOnly(true);
				// j'ajoute l'utilisateur dans hashtable avec comme clé id aléatoire que j'ai généré
				Map<String, Passport> sessions = (Map<String, Passport>) this.getServletContext().getAttribute("sessions");
				sessions.put(token, passport);
				response.addCookie(cookieSession);
			}
			response.sendRedirect(request.getContextPath()+"/jeux/ajouter");
		}
		
	}

}
