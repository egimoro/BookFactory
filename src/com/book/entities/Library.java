package com.book.entities;

public class Library extends Book {
	private String librarianName;
	private int lent;
	private int users;
	
	public Library(int id, String title, String author, String genre, int page, double price, String pubdate,
			String librarianName, int lent, int users) {
		super(id, title, author, genre, page, price, pubdate);
		this.librarianName = librarianName;
		this.lent = lent;
		this.users = users;
	}

	public Library() {
	}

	public String getLibrarianName() {
		return librarianName;
	}

	public void setLibrarianName(String librarianName) {
		this.librarianName = librarianName;
	}

	public int getLent() {
		return lent;
	}

	public void setLent(int lent) {
		this.lent = lent;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return super.toString()+ "\nLibrary [librarianName=" + 
				librarianName + "\\n lent=" + lent + "\\n users=" + users + "]";
	}
	
	
	

}
