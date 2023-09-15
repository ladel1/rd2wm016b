package fr.eni.gamemanager.dal;

import fr.eni.gamemanager.bo.User;
import fr.eni.gamemanager.dal.jdbc.exception.JDBCException;

public interface UserDao {

	User findByUsername(String username);
	void save(User user) throws JDBCException;
	void update(User user);
	User findByEmail(String email);
	
}
