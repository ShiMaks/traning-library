package by.http.password.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import by.http.password.bean.Book;
import by.http.password.dao.BookDao;
import by.http.password.compaund.Compaund;

public class BookDaoMySqlImpl implements BookDao {
	
	protected Connection connection;
	
	public BookDaoMySqlImpl(Compaund compaund) throws SQLException {
		this.connection = compaund.getConnection();
	}
	
	@Override
	public void create(Book t) {
		String sql = "insert into Book(Name, Publish_Year, Author) values (?, ?, ?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, t.getTitel());
			statement.setInt(2, t.getPublishDate());
			statement.setString(3, t.getAuthor());
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
	public Book read(int id) {
		String sql = "select Name FROM Book WHERE ID = ?";
		Book book = new Book();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				book.setTitel(result.getString("Name"));
				
			}
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
		return book;
	}

	@Override
	public void update(Book t) {
		String sql = "UPDATE Book SET Name = ?, Publish_Year = ?, Author = ? where id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, t.getTitel());
			statement.setInt(2, t.getPublishDate());
			statement.setString(3, t.getAuthor());
			statement.setInt(4, t.getId());
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
	public void delete(int id) {
		String sql = "DELETE FROM Book WHERE ID = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
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
	public List<Book> readAll() {
		List<Book> books = new ArrayList<Book>();
		String sql = "select Id, Name, Publish_Year, Author from Book";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Book book = new Book();
				book.setTitel(resultSet.getString("Name"));
				book.setAuthor(resultSet.getString("Author"));
				book.setId(resultSet.getInt("Id"));
				book.setPublishDate(resultSet.getInt("Publish_Year"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return books;
	}
}
