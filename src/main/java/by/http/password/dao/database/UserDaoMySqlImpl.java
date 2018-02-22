package by.http.password.dao.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.http.password.bean.User;
import by.http.password.compaund.Compaund;
import by.http.password.dao.UserDao;

public class UserDaoMySqlImpl implements UserDao{
	
protected Connection connection;
	
	public UserDaoMySqlImpl(Compaund compaund) throws SQLException {
		this.connection = compaund.getConnection();
	}

	@Override
	public void create(User t) {
String sql = "INSERT INTO userinf(login, password, role) values ( ?, ?, ?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, t.getLogin());
			statement.setInt(2, t.getPass());
			statement.setString(3, "user");
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
	}
		

	@Override
	public User read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> readAll() {
		String sql = "select login, password from userinf";
		List<User> users = new ArrayList<User>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				User user = new User();
				user.setLogin(resultSet.getString("login"));
				user.setPass(resultSet.getInt("password"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User checkUser(User user) {
		String sql = "select id, role, login, password from userinf where login = ? and password = ?";
		User usr = new User();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getLogin());
			statement.setInt(2, user.getPass());
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				
				usr.setId(result.getInt("id"));
				usr.setRole(result.getString("role"));
				usr.setLogin(result.getString("login"));
				usr.setPass(result.getInt("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usr;
	}

		

}
