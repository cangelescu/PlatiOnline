package Interfaces;

import java.util.List;

public interface DAO <T>{
	
	void add(T obj);
	public boolean update(T obj);
	void delete(T obj);
	public T findById(int id);
	public List<T> getAll();
	
}


