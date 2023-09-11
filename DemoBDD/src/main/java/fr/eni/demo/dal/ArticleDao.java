package fr.eni.demo.dal;

import java.util.List;

import fr.eni.demo.bo.Article;

public interface ArticleDao {
	// CRUD
	List<Article> selectAll(); 
}
