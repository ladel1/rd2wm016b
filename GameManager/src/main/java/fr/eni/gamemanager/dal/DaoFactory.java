package fr.eni.gamemanager.dal;
import fr.eni.gamemanager.dal.mock.GameMockDaoImpl;

public class DaoFactory {

	private DaoFactory() {}
	
	public static GameDao getGameDao() {
		return new GameMockDaoImpl();
	} 
	
}
