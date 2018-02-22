package by.http.password.bean;

import java.util.Date;

import by.http.password.bean.Entity;

public class Book extends Entity {
	
	private String titel;
	private String author;
	private int publishDate;
	
	public Book(int id) {
		super(id);
	}
	
	public Book(String titel, String author, int publishDate) {
		super();
		this.titel = titel;
		this.author = author;
		this.publishDate = publishDate;
	}

	public Book() {
		
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(int publishDate) {
		this.publishDate = publishDate;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + publishDate;
		result = prime * result + ((titel == null) ? 0 : titel.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (publishDate != other.publishDate)
			return false;
		if (titel == null) {
			if (other.titel != null)
				return false;
		} else if (!titel.equals(other.titel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " BookID:  " + getId() + ",  Book titel:  " + titel + " ,  Author: " + author + ",  publishDate: " + publishDate;
	}

}
