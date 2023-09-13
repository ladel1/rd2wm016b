package ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/connexion.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("name").equals("Admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("name", "Admin");
			// URL rewirting
			String redirect = response.encodeRedirectURL( request.getContextPath()+"/mon-compte");
			System.out.println(redirect);
			response.sendRedirect(redirect);
		}else {
			doGet(request, response);
		}
	}

}
