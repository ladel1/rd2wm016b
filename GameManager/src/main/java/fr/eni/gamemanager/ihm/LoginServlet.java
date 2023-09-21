package fr.eni.gamemanager.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.gamemanager.bll.UserManager;
import fr.eni.gamemanager.bo.User;

@WebServlet("/connexion")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = (String) request.getSession().getAttribute("success");
		request.getSession().removeAttribute("success");
		request.setAttribute("success", message);
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean rememberMe = request.getParameter("remember_me")!=null;
		
			
		User user = UserManager.getInstance().login(username, password);
		
		if(user == null) {
			request.setAttribute("error", "Username ou le mot de passe est éronné");
			doGet(request, response);
		}else {
			HttpSession session = request.getSession();
			user.setPassword("");
			session.setAttribute("user", user);
			if(rememberMe) { // rememberMe qui n'est pas sécurisé
				Cookie cookieSession = new Cookie("JSESSIONID", session.getId());
				cookieSession.setMaxAge(60*60*24*30);
				response.addCookie(cookieSession);
			}
			response.sendRedirect(request.getContextPath()+"/jeux/ajouter");
		}
		
	}

}
