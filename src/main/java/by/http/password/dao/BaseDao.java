package by.http.password.dao;

import by.http.password.bean.Entity;

public interface BaseDao<T extends Entity> {
	
	void create(T t);
	
	T read(int id);
	
	void update(T t);
	
	void delete(int id);

}
