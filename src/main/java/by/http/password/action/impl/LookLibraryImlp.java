package by.http.password.action.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.password.action.BaseAction;
import by.http.password.bean.Book;
import by.http.password.compaund.Compaund;
import by.http.password.dao.database.BookDaoMySqlImpl;

public class LookLibraryImlp implements BaseAction{

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		
		String page = "";
		String name = request.getParameter("name");
		
		if(name.equals("Book")) {
			Compaund connection = new Compaund();
			BookDaoMySqlImpl bookDao = new BookDaoMySqlImpl(connection);
			List<Book> books = bookDao.readAll();
			request.setAttribute("lookBook", books);
			page = "admin.jsp";
		} else if(name.equals("Users")) {
			page = "";
		}
		
		return page;
	}
	
	

}
