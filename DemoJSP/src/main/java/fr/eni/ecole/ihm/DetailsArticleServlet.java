package fr.eni.ecole.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.ecole.bo.Article;

public class DetailsArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// traitement
		Article samsungs21 = new Article(1, "Samsung s21", "blablbal", 900);
		// communication entre la servlet et la jsp
		request.setAttribute("article", samsungs21);
		// délégation
		request.getRequestDispatcher("/WEB-INF/details-article.jsp")
		       .forward(request, response);
		
	}

}
