package fr.eni.gamemanager.dal;

import java.util.List;

public interface DAO<T> {

	default void save(T t) {}
	default T findOne(int id){ return null;}
	default List<T> findAll(){return null;}
	default void delete(int id){}
	default void update(T t){}
}
