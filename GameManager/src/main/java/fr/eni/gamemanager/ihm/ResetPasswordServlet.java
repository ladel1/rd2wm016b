package fr.eni.gamemanager.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.gamemanager.bll.UserManager;
import fr.eni.gamemanager.bll.exception.BLLException;

@WebServlet("/reset-password")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/reset-password.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String email = request.getParameter("email");
			String code = request.getParameter("code");
			String newPassword = request.getParameter("password");
			UserManager.getInstance().resetPassword(email,code,newPassword);
			response.sendRedirect( request.getContextPath()+ "/connexion");
		} catch (BLLException e) {
			doGet(request, response);
			e.printStackTrace();
		}
		
		
		
	}

}
