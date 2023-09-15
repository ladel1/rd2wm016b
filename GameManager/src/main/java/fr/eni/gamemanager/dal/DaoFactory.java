package fr.eni.gamemanager.dal;
import fr.eni.gamemanager.dal.jdbc.ForgetPasswordDaoJdbcImpl;
import fr.eni.gamemanager.dal.jdbc.GameDaoJdbcImpl;
import fr.eni.gamemanager.dal.jdbc.UserDaoJdbcImpl;


public class DaoFactory {

	private DaoFactory() {}
	
	public static GameDao getGameDao() {
		//return new GameMockDaoImpl();
		return new GameDaoJdbcImpl();
	} 
	
	public static UserDao getUserDao() {
		return new UserDaoJdbcImpl();
	}
	
	public static ForgetPasswordDao getForgetPasswordDao() {
		return new ForgetPasswordDaoJdbcImpl();
	}
	
}
