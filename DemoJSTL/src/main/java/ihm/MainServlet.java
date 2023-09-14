package ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bo.Voiture;

@WebServlet("")// accueil
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Voiture> voitures = List.of(			
				new  Voiture("Bugatti", "Veyron", "XX-554-DR", 420),
				new  Voiture("Bugatti", "Chiron", "XX-554-DR", 450)
				);
		request.setAttribute("voitures", voitures);
		request.getRequestDispatcher("/WEB-INF/home.jsp")
		.forward(request, response);
	}

}
