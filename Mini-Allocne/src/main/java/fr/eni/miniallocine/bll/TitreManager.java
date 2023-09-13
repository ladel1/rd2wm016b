package fr.eni.miniallocine.bll;

import java.util.List;

import fr.eni.miniallocine.bo.Titre;
import fr.eni.miniallocine.dal.DaoFactory;
import fr.eni.miniallocine.dal.TitreDao;

public class TitreManager { // Singleton
	
	private static TitreManager instance;
	
	private TitreManager() {}
	
	public static TitreManager getInstance() {
		if(instance == null) instance = new TitreManager();
		return instance;
	}
	
	// fin de singleton
	
	// la logique metier
	
	private TitreDao titreDao = DaoFactory.getTitreDao();
	
	public List<Titre>  tousTitres(){
		return titreDao.findAll();
	}
	
	public Titre unTitre(int id) {
		return titreDao.findOne(id);
	}
	
	public List<String> tousLesCategories(){
		return titreDao.findAllCategories();
	}
	
	public List<Titre> tousLesTitreParCategorie(String categorie){
		return titreDao.findByGenre(categorie);
	}

}
