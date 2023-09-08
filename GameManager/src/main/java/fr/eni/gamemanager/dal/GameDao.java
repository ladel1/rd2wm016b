package fr.eni.gamemanager.dal;

import java.util.List;

import fr.eni.gamemanager.bo.Game;

public interface GameDao {
	// CRUD
	void save(Game game);
	Game findOne(int id);
	List<Game> findAll();
	void modify(Game game);
	void remove(int id);
}
