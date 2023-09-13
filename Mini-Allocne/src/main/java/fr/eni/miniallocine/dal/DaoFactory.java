package fr.eni.miniallocine.dal;

import fr.eni.miniallocine.dal.jdbc.TitreDaoJdbcImpl;

public class DaoFactory {

	public static TitreDao getTitreDao() {
		return new TitreDaoJdbcImpl();
	}
	
}
