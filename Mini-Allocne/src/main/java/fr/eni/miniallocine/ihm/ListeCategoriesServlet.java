package fr.eni.miniallocine.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.miniallocine.bll.TitreManager;

@WebServlet("/categories")
public class ListeCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categories",
				TitreManager.getInstance().tousLesCategories()
				);
		request.getRequestDispatcher("/WEB-INF/pages/categories.jsp")
		.forward(request, response);
	}

}
