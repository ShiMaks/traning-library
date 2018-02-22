package by.http.password.bean;

import by.http.password.bean.Entity;

public class CardLibrary extends Entity{
	
	private Employee visitor;
	private Book book;
	private int countBook;
	
	public CardLibrary(int id) {
		super(id);
	}

	public CardLibrary(Employee visitor, Book book) {
		super();
		this.visitor = visitor;
		this.book = book;
	}
	
	public CardLibrary() {
		
	}

	public Employee getVisitor() {
		return visitor;
	}

	public void setVisitor(Employee visitor) {
		this.visitor = visitor;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	

	public int getCountBook() {
		return countBook;
	}

	public void setCountBook(int countBook) {
		this.countBook = countBook;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((visitor == null) ? 0 : visitor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardLibrary other = (CardLibrary) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (visitor == null) {
			if (other.visitor != null)
				return false;
		} else if (!visitor.equals(other.visitor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " CardLibraryId: " + getId() + ",  visitor: " + visitor.getName() + ",  book: " + book.getTitel();
	}
	
	
	
	

}
