package revisions.bll;

import java.util.List;

import revisions.bo.Article;

public class ArticleManager {
	
	// lazy singleton
	private static ArticleManager instance = new ArticleManager();
	
	private ArticleManager() {}
	
	public static ArticleManager getInstance() {
		return instance;
	}
	// fin singleton
	
	// la logique metier
	
	public List<Article> getArticles(){
		return List.of(
				new Article(1, "Samsung s21 pro max", "blablabal", 800),
				new Article(2, "Iphone 12 max", "blablabal", 1200),
				new Article(3, "PC DELL", "blablabal", 500),
				new Article(4, "Ecran HP", "blablabal", 200)
				);
	}
	
}
