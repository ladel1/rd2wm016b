package fr.eni.gamemanager.bll;

import java.util.Random;

import fr.eni.gamemanager.bll.exception.BLLException;
import fr.eni.gamemanager.bo.ForgetPassword;
import fr.eni.gamemanager.bo.User;
import fr.eni.gamemanager.dal.DaoFactory;
import fr.eni.gamemanager.dal.UserDao;
import fr.eni.gamemanager.dal.jdbc.exception.JDBCException;

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
	private Random rd = new Random();
	
	public void inscription(User user) throws JDBCException, BLLException {
		// validation !!!!!!!!
		checkFields(user);
		userDao.save(user);		
	}
	
	
	private void checkFields(User user) throws BLLException {
		if( user == null ) throw new BLLException("User est null");
		
		if( user.getUsername().isBlank() ) throw new BLLException("Le champs Username est obligatoire!");
		if( user.getEmail().isBlank() ) throw new BLLException("Le champs Email est obligatoire!");
		// verifier la syntaxe de l'email
		if( user.getPassword().isBlank() ) throw new BLLException("Le champs Mot de passe est obligatoire!");
		if( user.getPassword().length() < 8 ||  user.getPassword().length() > 35 )throw new BLLException("La taille du mot de passe doit etre entre 8 et 35");
		//if(!user.getPassword().equals(user.getConfirmpassword))
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

	public ForgetPassword checkEmail(String email) throws BLLException {
		
		User user = userDao.findByEmail(email);
		if(user == null) throw new BLLException("Erreur: l'email n'existe pas");			
		// Générer le code
		String code = rd.nextLong(1,9999999999L)+"";
		ForgetPassword fp = new ForgetPassword(code, user);

		// save
		DaoFactory.getForgetPasswordDao()
				  .save(fp);
		// envoi mail
		
		// par sms API 
		System.out.println(code);

		return fp;
	}

	public void resetPassword(String email, String code, String newPassword) throws BLLException {
		
		ForgetPassword fp = DaoFactory.getForgetPasswordDao().resetPassword(email);
		
		if(!fp.getCode().equals(code)) throw new BLLException("Le code est érroné!");
		
		User user = fp.getUser();
		
		user.setPassword(newPassword);
		
		userDao.update(user);
		
	}

}
