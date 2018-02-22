package by.http.password.dao;

import java.util.List;


import by.http.password.bean.Book;

public interface BookDao extends BaseDao<Book> {

	List<Book> readAll();
	
}
