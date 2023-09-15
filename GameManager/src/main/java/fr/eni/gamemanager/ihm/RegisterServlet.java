package fr.eni.gamemanager.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.gamemanager.bll.UserManager;
import fr.eni.gamemanager.bll.exception.BLLException;
import fr.eni.gamemanager.bo.User;
import fr.eni.gamemanager.dal.jdbc.exception.JDBCException;

@WebServlet("/inscription")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/register.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			User user = new User(request.getParameter("username"), 
					request.getParameter("password"), 
					request.getParameter("email"));		
			//user.setConfirmPassword()
			UserManager.getInstance().inscription(user);
			// Flash
			request.getSession().setAttribute("success", "Le compte a bien été créer!");
			response.sendRedirect( request.getContextPath()+ "/connexion");
		} catch (JDBCException | BLLException e) {
			
			request.setAttribute("error", e.getMessage());
			doGet(request, response);
			e.printStackTrace();
		}
		
	}

}
