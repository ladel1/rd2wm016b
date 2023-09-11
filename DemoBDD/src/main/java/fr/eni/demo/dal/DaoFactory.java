package fr.eni.demo.dal;

import fr.eni.demo.dal.jdbc.ArticleDaoJdbcImpl;

public class DaoFactory {

	public static ArticleDao getArticleDao() {
		return new ArticleDaoJdbcImpl();
	}
	
	
}
