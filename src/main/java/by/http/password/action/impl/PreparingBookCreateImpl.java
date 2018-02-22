package by.http.password.action.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.http.password.action.BaseAction;
import by.http.password.bean.Book;
import by.http.password.compaund.Compaund;
import by.http.password.dao.database.BookDaoMySqlImpl;

public class PreparingBookCreateImpl implements BaseAction {

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		Compaund compaund = new Compaund();
		BookDaoMySqlImpl bookDao = new BookDaoMySqlImpl(compaund);
		List<Book> books = bookDao.readAll();
		List<Integer> years = new ArrayList();
		for(int i = 1890; i <= 2018; i++) {
			years.add(i);
		}
		request.setAttribute("updateYear", years);
     	request.setAttribute("updateBook", books);
		String page = "createAdmin.jsp";
		return page;
	}
}
