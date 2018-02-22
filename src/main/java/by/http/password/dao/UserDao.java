package by.http.password.dao;

import java.util.List;

import by.http.password.bean.User;

public interface UserDao extends BaseDao<User> {
	
	List<User> readAll();
	
	User checkUser(User user);

}