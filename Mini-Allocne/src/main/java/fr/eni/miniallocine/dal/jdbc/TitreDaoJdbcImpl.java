package fr.eni.miniallocine.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.miniallocine.bo.Film;
import fr.eni.miniallocine.bo.Serie;
import fr.eni.miniallocine.bo.Titre;
import fr.eni.miniallocine.dal.TitreDao;

public class TitreDaoJdbcImpl implements TitreDao {

	private static final String SELECT_ALL = "SELECT * FROM titres";
	private static final String SELECT_ONE = "SELECT * FROM titres WHERE id = ?";
	private static final String SELECT_All_CATIGORIES = "SELECT genre FROM titres GROUP BY genre";
	private static final String SELECT_TITRE_BY_GENRE = "SELECT * FROM titres WHERE genre = ? ";

	
	@Override
	public List<Titre> findAll() {
		try(
				Connection connection = ConnectionProvider.getConnection();
				Statement stmt = connection.createStatement();
			){
			List<Titre> titres = new ArrayList<Titre>();			
			ResultSet rs =  stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {				
				if(rs.getString("type").equals("F")) { // FILM
					titres.add(							
							new Film(rs.getInt("id"), rs.getString("nom"), 
									rs.getString("genre"), rs.getString("realisateur"), 
									rs.getInt("duree"), rs.getDate("date_sortie").toLocalDate(),
									rs.getString("platforme_streaming"), rs.getInt("nombre_oscars"))							
							);	
				}else { // Série
					titres.add(							
							new Serie(rs.getInt("id"), rs.getString("nom"), 
									rs.getString("genre"), rs.getString("realisateur"), 
									rs.getInt("duree"), rs.getDate("date_sortie").toLocalDate(),
									rs.getString("platforme_streaming"), 
									rs.getInt("nombre_episodes"),rs.getInt("nombre_saisons"))							
							);
				}
			}
			return titres;
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public Titre findOne(int id) {
		try(
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement stmt = connection.prepareStatement(SELECT_ONE);
			){
			stmt.setInt(1, id);
			ResultSet rs =  stmt.executeQuery();
			
			if(rs.next()) {				
				if(rs.getString("type").equals("F")) { // FILM
											
						return new Film(rs.getInt("id"), rs.getString("nom"), 
									rs.getString("genre"), rs.getString("realisateur"), 
									rs.getInt("duree"), rs.getDate("date_sortie").toLocalDate(),
									rs.getString("platforme_streaming"), rs.getInt("nombre_oscars"));							
							
				}
				
				if(rs.getString("type").equals("S")){ // Série
						
						return new Serie(rs.getInt("id"), rs.getString("nom"), 
									rs.getString("genre"), rs.getString("realisateur"), 
									rs.getInt("duree"), rs.getDate("date_sortie").toLocalDate(),
									rs.getString("platforme_streaming"), 
									rs.getInt("nombre_episodes"),rs.getInt("nombre_saisons"));							

				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public List<String> findAllCategories() {
		try(
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(SELECT_All_CATIGORIES);	
				){
			
			List<String> categories = new ArrayList<String>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				categories.add(rs.getString("genre"));
			}
			return categories;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Titre> findByGenre(String genre) {
		try(
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement stmt = connection.prepareStatement(SELECT_TITRE_BY_GENRE);
			){
			stmt.setString(1, genre);
			ResultSet rs =  stmt.executeQuery();
			List<Titre> titres = new ArrayList<Titre>();
			while(rs.next()) {				
				if(rs.getString("type").equals("F")) { // FILM
					titres.add(							
							new Film(rs.getInt("id"), rs.getString("nom"), 
									rs.getString("genre"), rs.getString("realisateur"), 
									rs.getInt("duree"), rs.getDate("date_sortie").toLocalDate(),
									rs.getString("platforme_streaming"), rs.getInt("nombre_oscars"))							
							);	
				}else { // Série
					titres.add(							
							new Serie(rs.getInt("id"), rs.getString("nom"), 
									rs.getString("genre"), rs.getString("realisateur"), 
									rs.getInt("duree"), rs.getDate("date_sortie").toLocalDate(),
									rs.getString("platforme_streaming"), 
									rs.getInt("nombre_episodes"),rs.getInt("nombre_saisons"))							
							);
				}
			}
			return titres;
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	
	
	
}
