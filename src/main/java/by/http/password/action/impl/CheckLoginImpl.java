package by.http.password.action.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.password.action.BaseAction;
import by.http.password.bean.Book;
import by.http.password.bean.User;
import by.http.password.compaund.Compaund;
import by.http.password.dao.database.BookDaoMySqlImpl;
import by.http.password.dao.database.UserDaoMySqlImpl;


public class CheckLoginImpl implements BaseAction {
	
 

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		Compaund connection = new Compaund();
		UserDaoMySqlImpl userDao = new UserDaoMySqlImpl(connection);
		String page = "";
		
		User reqUser = new User();
		reqUser.setLogin(request.getParameter("login"));
		reqUser.setPass(Integer.parseInt(request.getParameter("password")));
		
		User baseUser = userDao.checkUser(reqUser);
		
		if(baseUser!=null) {
			if(baseUser.getRole().equals("admin")) {
				Compaund compaund = new Compaund();
				BookDaoMySqlImpl bookDao = new BookDaoMySqlImpl(compaund);
				List<Book> books = bookDao.readAll();
				request.setAttribute("lookBook", getListBook());
				page = "admin.jsp";
			} else if(baseUser.getRole().equals("user")) {
				page = "user.jsp";
			}
		} else {
			page = "error.jsp";
		}
		
		return page;
	}
	
	private List<Book> getListBook() throws SQLException{
		Compaund compaund = new Compaund();
		BookDaoMySqlImpl bookDao = new BookDaoMySqlImpl(compaund);
		List<Book> books = bookDao.readAll();
//		for(Book book: books) {
//			System.out.println(book);
//		}
		return books;
	}
	
	
}
