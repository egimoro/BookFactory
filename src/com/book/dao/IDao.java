package com.book.dao;

import java.util.*;

import com.book.entities.Book;

public interface IDao {
	public boolean insert(Book book);
	
	public List<Map<String, String>>readM(String query);
	
	public void update(String newValue,String table, String column, int id);
	public void delete(String table,int id);
	
	

}
