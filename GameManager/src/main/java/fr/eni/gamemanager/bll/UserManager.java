package fr.eni.gamemanager.bll;

import fr.eni.gamemanager.bo.User;
import fr.eni.gamemanager.dal.DaoFactory;
import fr.eni.gamemanager.dal.UserDao;

public class UserManager {
	// singleton
	private static UserManager instance;
	
	private UserManager() {}
	
	public static UserManager getInstance() {
		if(instance==null) instance = new UserManager();
		return instance;
	}
	// fin singleton
	
	// début logique métier
	
	private UserDao userDao = DaoFactory.getUserDao();
	
	public void inscription(User user) {
		// validation !!!!!!!!
		userDao.save(user);		
	}
	
	
	public User login(String username,String password) {
		User user = userDao.findByUsername(username);		
		if(user!=null 
				&& user.getUsername().equals(username)
				&& user.getPassword().equals(password) ) {
			return user;
		}		
		return null;
	}

}
