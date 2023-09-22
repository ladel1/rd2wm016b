package fr.eni.gamemanager.dal.mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.eni.gamemanager.bo.Game;
import fr.eni.gamemanager.dal.GameDao;

public class GameMockDaoImpl implements GameDao {

	private List<Game> gameLst = new ArrayList<Game>();
	
	public GameMockDaoImpl() {
		gameLst.add( new Game(1, "FIFA 2023", "EA", "Sport", 30, LocalDate.of(2022, 9, 1), 9, "DVD", "1.0.0","") );
		gameLst.add( new Game(2, "Call of Duty: Modern Warfare II", "Activision", "Action", 40, LocalDate.of(2022, 9, 1), 9, "DVD", "1.0.0","") );
		gameLst.add( new Game(3, "The Last of Us Remastered", "EA", "Aventure", 25, LocalDate.of(2022, 9, 1), 9, "DVD", "1.0.0","") );
		gameLst.add( new Game(4, "NBA 2K24", "EA", "Sport", 30, LocalDate.of(2022, 9, 1), 9, "DVD", "1.0.0","") );
	}
	
	@Override
	public void save(Game game) {
		game.setId(gameLst.size()+1);
		gameLst.add(game);
	}

	@Override
	public Game findOne(int id) {
		for (Game game : gameLst) {
			if(game.getId()==id) return game;			
		}
		return null;
	}

	@Override
	public List<Game> findAll() {
		return gameLst;
	}

	@Override
	public void modify(Game game) {
		for (int i = 0; i < gameLst.size(); i++) {
			if( gameLst.get(i).getId() == game.getId() ) {
				gameLst.set(i, game);
			}
		}
	}

	@Override
	public void remove(int id) {
		Game game = findOne(id);
		gameLst.remove(game);
	}

	@Override
	public List<Game> findByName(String query) {
		List<Game> newListGames = new ArrayList<Game>();
		for (Game game : gameLst) {
			if(game.getName().toLowerCase().contains(query.toLowerCase()) ) {
				newListGames.add(game);
			}
		}
		return newListGames;
	}

}
