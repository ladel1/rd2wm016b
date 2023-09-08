package fr.eni.gamemanager.bll;

import java.util.List;

import fr.eni.gamemanager.bo.Game;
import fr.eni.gamemanager.dal.DaoFactory;
import fr.eni.gamemanager.dal.GameDao;

public class GameManager {
	// début Singleton
	private static GameManager instance;
	private GameManager() {}
	public static GameManager getInstance() {
		if(instance==null) instance = new GameManager();
		return instance;
	}
	// Fin Singleton
	private GameDao gameDao = DaoFactory.getGameDao();
	// début la logique métier
	public Game recupUnJeu(int id) {
		return gameDao.findOne(id);
	}
	
	public List<Game> recupTousLesJeux() {
		return gameDao.findAll();
	}
	
	public void ajouterUnJeu(Game game) {
		
		// datas validation !!
		gameDao.save(game);				  	
	}
	public void modifierUnJeu(Game game) {
		// datas validation !!
		gameDao.modify(game);				  	
	}
	
	public void supprimerUnJeu(int id) {
		gameDao.remove(id);
	}
	public List<Game> rechercheUnJeu(String query) {
		return  gameDao.findByName(query) ;
	}
	
	// finde la logique métier
	
	
}
