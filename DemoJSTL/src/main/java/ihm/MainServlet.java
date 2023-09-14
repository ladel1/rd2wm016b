package ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bo.Personne;
import bo.Voiture;

@WebServlet("")// accueil
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Voiture> voitures = List.of(			
				new  Voiture("Bugatti", "Veyron", "XX-554-DR", 420),
				new  Voiture("Bugatti", "Chiron", "XX-554-DR", 450)
				);
		List<Personne> personnes = List.of(
				new Personne("Hugo", "Maisel", 10),
				new Personne("Pierre", "Dupont", 20),
				new Personne("Gaelle", "De lor", 25),
				new Personne("Lucas", "Duval", 15)
				);
		request.setAttribute("voitures", voitures);
		request.setAttribute("personnes", personnes);
		request.getRequestDispatcher("/WEB-INF/home.jsp")
		.forward(request, response);
	}

}
