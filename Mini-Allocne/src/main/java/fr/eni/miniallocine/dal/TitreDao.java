package fr.eni.miniallocine.dal;

import java.util.List;

import fr.eni.miniallocine.bo.Titre;

public interface TitreDao {
	List<Titre> findAll();
	Titre findOne(int id);	
	List<String> findAllCategories();
	List<Titre> findByGenre(String genre);
	
}
