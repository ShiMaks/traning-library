package by.http.password.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface BaseAction {
	
	String chooseAction(HttpServletRequest request) throws SQLException;

}
