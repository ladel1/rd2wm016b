package fr.eni.gamemanager.bll;

import java.util.List;

import fr.eni.gamemanager.bo.Game;
import fr.eni.gamemanager.dal.DaoFactory;

public class GameManager {
	// début Singleton
	private static GameManager instance;
	private GameManager() {}
	public static GameManager getInstance() {
		if(instance==null) instance = new GameManager();
		return instance;
	}
	// Fin Singleton
	
	// début la logique métier
	public Game recupUnJeu(int id) {
		return DaoFactory.getGameDao()
						 .findOne(id);
	}
	
	public List<Game> recupTousLesJeux() {
		return DaoFactory.getGameDao()
						 .findAll();
	}
	
	public void ajouterUnJeu(Game game) {
		// datas validation !!
		DaoFactory.getGameDao()
				  .save(game);				  	
	}
	public void modifierUnJeu(Game game) {
		// datas validation !!
		DaoFactory.getGameDao()
		.modify(game);				  	
	}
	
	public void supprimerUnJeu(int id) {
		DaoFactory.getGameDao()
				  .remove(id);
	}
	
	// finde la logique métier
	
	
}
