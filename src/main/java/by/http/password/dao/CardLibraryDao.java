package by.http.password.dao;

import java.util.List;

import by.http.password.bean.CardLibrary;

public interface CardLibraryDao extends BaseDao<CardLibrary> {
	
	List<CardLibrary> getVisitorReadingMoreThan1Book();
	
	List<CardLibrary> getVisitorReading2orLessBooks();

}
