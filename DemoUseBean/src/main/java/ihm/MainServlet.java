package ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bo.Voiture;

@WebServlet("")// accueil
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Voiture v = new Voiture("Bugatti", "Chiron", "XX-554-DR", 420);
		request.setAttribute("voiture", v);
		request.getRequestDispatcher("/WEB-INF/home.jsp")
		.forward(request, response);
	}

}
