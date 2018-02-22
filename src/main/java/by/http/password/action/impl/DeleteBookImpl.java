package by.http.password.action.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import by.http.password.action.BaseAction;
import by.http.password.compaund.Compaund;
import by.http.password.dao.database.BookDaoMySqlImpl;

public class DeleteBookImpl implements BaseAction {

	@Override
	public String chooseAction(HttpServletRequest request) throws SQLException {
		String page = "";
		Compaund connection = new Compaund();
		BookDaoMySqlImpl bookDao = new BookDaoMySqlImpl(connection);
		bookDao.delete(Integer.parseInt(request.getParameter("book_id")));
		page = "updateAdmin.jsp";
		return page;
	}
}
