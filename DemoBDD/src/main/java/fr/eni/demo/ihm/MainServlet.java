package fr.eni.demo.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.demo.bll.BlogManager;
import fr.eni.demo.bo.Article;
import fr.eni.demo.dal.jdbc.ConnectionProvider;

@WebServlet("")// racine 
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récuperer les articles depuis BlogManager
		List<Article> articleLst = BlogManager.getInstance().tousLesArticles();
		// transmettre la liste à la JSP
		request.setAttribute("articles", articleLst);
		// forward
		request.getRequestDispatcher("/WEB-INF/home.jsp")
		.forward(request, response);
	}

}
