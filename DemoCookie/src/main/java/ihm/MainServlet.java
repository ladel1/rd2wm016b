package ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/accueil")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie [] listeCookies = request.getCookies();

		Cookie visiteur = null;
		
		if(listeCookies != null) {
			for (Cookie cookie : listeCookies) {
				if(cookie.getName().equals("Visiteur")) {
					visiteur = cookie;
				}	
			}
		}
		
		if( listeCookies==null || visiteur == null) {
			Cookie c = new Cookie("Visiteur", "1");
			response.addCookie(c);
			response.getWriter().println("Bonjour");
		}
		
		if(visiteur!=null) {
			 int compteur = Integer.parseInt( visiteur.getValue() );
			 compteur++;
			 visiteur.setValue(compteur+"");
			 response.addCookie(visiteur);
			 response.getWriter().println("Rebonjour: nombre de visites: "+compteur);
		}
		
		
		
		
	}
}
