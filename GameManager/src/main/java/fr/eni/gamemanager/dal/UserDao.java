package fr.eni.gamemanager.dal;

import fr.eni.gamemanager.bo.User;

public interface UserDao {

	User findByUsername(String username);
	void save(User user);
	
}
