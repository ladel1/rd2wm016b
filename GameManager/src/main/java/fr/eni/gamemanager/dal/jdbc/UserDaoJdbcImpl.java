package fr.eni.gamemanager.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.gamemanager.bo.User;
import fr.eni.gamemanager.dal.UserDao;
import fr.eni.gamemanager.dal.jdbc.exception.JDBCException;

public class UserDaoJdbcImpl implements UserDao {

	private static final String INSERT_USER = "INSERT INTO users (username,password,email)"
			+ " VALUES (?,?,?)";
	private static final String SELECT_BY_USERNAME = "SELECT * FROM users WHERE username = ?";

	private static final String UNIQUE_USERNAME_CONSTRAINT = "UQ_USERNAME_USERS";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
	private static final String UPDATE_PASSWORD_USER = "UPDATE users SET password = ? WHERE id = ?";
	
	@Override
	public User findByUsername(String username) {
		try(
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_USERNAME);
					){

				pstmt.setString(1, username);				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					return new User(rs.getInt("id"),
							rs.getString("username"), 
							rs.getString("password"), 
							rs.getString("email"),
							rs.getDate("date_created").toLocalDate());
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public void save(User user) throws JDBCException {
		try(
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(INSERT_USER);
				){
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			if(e.getMessage().contains(UNIQUE_USERNAME_CONSTRAINT)) {
				throw new JDBCException("Le nom de l'utilisateur existe déja!");
			}
			e.printStackTrace();
		}
	}

	@Override
	public User findByEmail(String email) {
		try(
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_EMAIL);
					){

				pstmt.setString(1, email);				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					return new User(rs.getInt("id"),
							rs.getString("username"), 
							rs.getString("password"), 
							rs.getString("email"),
							rs.getDate("date_created").toLocalDate());
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public void update(User user) {
		try(
				Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_PASSWORD_USER);
					){
				pstmt.setString(1, user.getPassword());
				pstmt.setInt(2, user.getId());

				pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}

	
	
}
