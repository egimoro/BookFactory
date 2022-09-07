package com.book.entities;

import com.book.utils.Validator;

public abstract class Book extends Entity {
	private String title;
	private String author;
	private String genre;
	private int page;
	private double price;
	private String pubdate;
	public Book() {
		super();
	}
	public Book(int id, String title, String author, String genre, int page, double price, String pubdate) {
		super(id);
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.page = page;
		this.price = price;
		this.pubdate = pubdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		if(Validator.isDate(pubdate))
			this.pubdate = pubdate;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + 
				"\\n author=" + author + "\\n genre=" + genre + "\\n page=" + page
				+ "\\n price=" + price + "\\n pubdate=" + pubdate + "]";
	}
	
	
	

}
