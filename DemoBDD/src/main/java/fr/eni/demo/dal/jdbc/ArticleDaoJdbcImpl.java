package fr.eni.demo.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.demo.bo.Article;
import fr.eni.demo.dal.ArticleDao;

public class ArticleDaoJdbcImpl implements ArticleDao {

	// SQL Query
	private static final String SELECT_ALL = "SELECT * FROM articles";
	
	@Override
	public List<Article> selectAll() {
		try(Connection connection = ConnectionProvider.getConnection()){
			List<Article> articles = new ArrayList<Article>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			
			while(rs.next()) {
				articles.add(						
						new Article(rs.getInt("id"), rs.getString("titre"), 
								rs.getString("contenu"), rs.getString("auteur"), 
								rs.getString("categorie"), rs.getDate("date_creation").toLocalDate())				
						);				
			}
			return articles;
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

}
