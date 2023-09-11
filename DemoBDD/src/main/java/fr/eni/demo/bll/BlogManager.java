package fr.eni.demo.bll;

import java.util.List;

import fr.eni.demo.bo.Article;
import fr.eni.demo.dal.DaoFactory;

public class BlogManager { // Singleton
	
	private static BlogManager instance;
	
	private BlogManager() {}

	public static BlogManager getInstance() {
		if(instance==null) instance = new BlogManager();
		return instance;
	}
	
	// fin singleton
	
	// début logique métier
	
	public List<Article> tousLesArticles() {
		return DaoFactory.getArticleDao().selectAll();
	}
	
	
}
