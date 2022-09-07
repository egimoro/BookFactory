package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.book.database.Database;
import com.book.entities.Book;

public abstract class Dao {
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	protected Connection getConnection() {
		Connection conn;
		conn = Database.getInstance().getConnection();
		return conn;
	}
	
	public boolean insert(Book book) {
		boolean res = false;
		try {
			String query = "insert into book(title,author,genre"
				+ ",pages,price,pubdate) values(?,?,?,?,?,?);";
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getGenre());
			ps.setInt(4, book.getPage());
			ps.setDouble(5, book.getPrice());
			ps.setString(6, book.getPubdate());
			ps.executeUpdate();
			System.out.println("Data added successfully.");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(connection != null)
					connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public List<Map<String, String>>readM(String query){
		List<Map<String, String>>res = new ArrayList<>();
		Map<String, String>row;
		
		try {
			connection = getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			int nColumns = rs.getMetaData().getColumnCount();
			
			while(rs.next()) {
				row = new LinkedHashMap<String, String>();
				for(int i = 1; i <= nColumns; i++) {
					row.put(rs.getMetaData().getColumnLabel(i), rs.getString(i));
				}
				res.add(row);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(connection != null)
					connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return res;

	}
	public final String UPDATE = "update [table] set [column] = '[newValue]' where id = [id];";

	public void update(String newValue, String column, String table, int id ) {
		
		String query = UPDATE.replace("[column]", column).replace("[table]", table).
				replace("[newValue]", newValue).replace("[id]", id + "");
		
		try {
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, newValue);
			ps.setInt(2, id);
		}catch(Exception e) {
			System.err.println("Got an error. "+ e);
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(connection != null)
					connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public final String DELETE = "delete from [table] where id = [id];";

	public void delete(String table, int id) {
		String query = DELETE.replace("[table]", table).replace("[id]", id+"");
		
		try {
			connection = getConnection();
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
			System.err.println("Got an error. "+ e);
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(connection != null)
					connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
	
