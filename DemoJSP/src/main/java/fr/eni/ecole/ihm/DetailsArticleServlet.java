package fr.eni.ecole.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fr.eni.ecole.bo.Article;

public class DetailsArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// traitement
		
		List<Article> articles = List.of(
				new Article(1, "Samsung s21", "blablbal", 900),
				new Article(2, "Iphone", "blablbal", 1200),
				new Article(3, "Ecran HP", "blablbal", 300),
				new Article(4, "PC Dell", "blablbal", 500)
				);
		// communication entre la servlet et la jsp
		request.setAttribute("articles", articles);
		// délégation
		request.getRequestDispatcher("/WEB-INF/details-article.jsp")
		       .forward(request, response);
		
	}

}
