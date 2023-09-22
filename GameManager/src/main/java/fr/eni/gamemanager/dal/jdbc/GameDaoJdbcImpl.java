package fr.eni.gamemanager.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.gamemanager.bo.Game;
import fr.eni.gamemanager.dal.GameDao;

public class GameDaoJdbcImpl implements GameDao {
	
	// Requetes SQL
	private static final String SELECT_ALL = "SELECT * FROM games";
	private static final String SELECT_ONE = "SELECT * FROM games WHERE id = ?";
	private static final String SAVE = "INSERT games (name,company,category,price,releaseDate,age,format,version,img) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String DELETE_ONE = "DELETE games WHERE id = ?";
	private static final String UPDATE = "UPDATE games SET name=?,company=?,category=?,price=?,releaseDate=?,age=?,format=?,version=? WHERE id = ?";
	private static final String FIND_BY_NAME = "SELECT * FROM games WHERE name LIKE ? ";
	
	
	@Override
	public void save(Game game) {
		try(
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SAVE);	
				){
			// valoriser les params de la requete
			pstmt.setString(1, game.getName());
			pstmt.setString(2, game.getCompany());
			pstmt.setString(3, game.getCategory());
			pstmt.setFloat(4, game.getPrice());
			pstmt.setDate(5, Date.valueOf(game.getReleaseDate()) );
			pstmt.setInt(6, game.getAge());
			pstmt.setString(7, game.getFormat());
			pstmt.setString(8, game.getVersion());
			pstmt.setString(9, game.getJaquette());
			// executer la requete
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Game findOne(int id) {
		try(
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ONE);
			){
			pstmt.setInt(1, id);			
			ResultSet rs =  pstmt.executeQuery();
			if(rs.next()) {
					return new Game(rs.getInt("id"), rs.getString("name"), 
								rs.getString("company"), rs.getString("category"), 
								rs.getFloat("price"), rs.getDate("releaseDate").toLocalDate(), 
								rs.getInt("age"), rs.getString("format"), 
								rs.getString("version"),
								rs.getString("img"));				
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public List<Game> findAll() {
		try(
				Connection connection = ConnectionProvider.getConnection();
				Statement stmt = connection.createStatement();
			){
			List<Game> games = new ArrayList<Game>();			
			ResultSet rs =  stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				games.add(
						
						new Game(rs.getInt("id"), rs.getString("name"), 
								rs.getString("company"), rs.getString("category"), 
								rs.getFloat("price"), rs.getDate("releaseDate").toLocalDate(), 
								rs.getInt("age"), rs.getString("format"), 
								rs.getString("version"),
								rs.getString("img"))
						
						);				
			}
			return games;
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public void modify(Game game) {
		try(
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE)
				){
			
			// Update Set
			pstmt.setString(1, game.getName());
			pstmt.setString(2, game.getCompany());
			pstmt.setString(3, game.getCategory());
			pstmt.setFloat(4, game.getPrice());
			pstmt.setDate(5, Date.valueOf(game.getReleaseDate()) );
			pstmt.setInt(6, game.getAge());
			pstmt.setString(7, game.getFormat());
			pstmt.setString(8, game.getVersion());
			// Where id
			pstmt.setInt(9, game.getId());
			// execute
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int id) {		
		try (
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(DELETE_ONE);	
			) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}catch( SQLException e ) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Game> findByName(String query) {
		try(
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(FIND_BY_NAME)
			){
			pstmt.setString(1, "%"+query+"%");
			List<Game> games = new ArrayList<Game>();			
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next()) {
				games.add(
						
						new Game(rs.getInt("id"), rs.getString("name"), 
								rs.getString("company"), rs.getString("category"), 
								rs.getFloat("price"), rs.getDate("releaseDate").toLocalDate(), 
								rs.getInt("age"), rs.getString("format"), 
								rs.getString("version"),
								rs.getString("img"))
						
						);				
			}
			return games;
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

}
