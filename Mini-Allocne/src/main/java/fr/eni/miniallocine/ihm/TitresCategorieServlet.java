package fr.eni.miniallocine.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.miniallocine.bll.TitreManager;

@WebServlet("/categories/*")
public class TitresCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info = request.getPathInfo();
		String categorie = info.substring(1);
		request.setAttribute("titres",
					TitreManager.getInstance().tousLesTitreParCategorie(categorie)
				);
		
		request.getRequestDispatcher("/WEB-INF/pages/titres-par-categorie.jsp")
		.forward(request, response);
	}


}
