package fr.eni.gamemanager.dal;
import fr.eni.gamemanager.dal.jdbc.GameDaoJdbcImpl;
import fr.eni.gamemanager.dal.mock.GameMockDaoImpl;

public class DaoFactory {

	private DaoFactory() {}
	
	public static GameDao getGameDao() {
		//return new GameMockDaoImpl();
		return new GameDaoJdbcImpl();
	} 
	
}
