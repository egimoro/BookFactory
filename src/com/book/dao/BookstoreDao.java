package com.book.dao;

import java.sql.SQLException;
import java.util.*;

import com.book.entities.Book;
import com.book.entities.Bookstore;

public class BookstoreDao extends Dao implements IDao {
	
	@Override
	public boolean insert(Book book) {
		boolean check = false;
		String query = "";
		
		for(Map<String,String>m : readM("select id from book")) {
			if(book.getId() == Integer.parseInt(m.get("id"))) {
				check = true;
				query = "insert into store values("+book.getId()+
						",?,?,?);";
			}
		}
		if(!check) {
			check = super.insert(book);
			query = "insert into store values ((select max (id) from book),?,?,?);";
		}
		
		if(check) {
			try {
				connection = getConnection();

				ps = connection.prepareStatement(query);
				Bookstore store = (Bookstore)book;
				ps.setString(1, store.getStoreType());
				ps.setInt(2, store.getUnitsSold());
				ps.setBoolean(3, store.getHasDiscount());
				ps.executeUpdate();
				System.out.println("Data added successfully.");

			}catch(SQLException e) {
				e.printStackTrace();
				check = false;
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
		return check;
	}


	@Override
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
				for(Map.Entry<String, String>entry : row.entrySet()) {
					System.out.println("Key: " + entry.getKey()+" & "+"Value: "+entry.getValue());
				}
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
	
	@Override
	public void update(String newValue, String column, String table, int id) {
		
			
		String query = UPDATE.replace("[column]", column).replace("[table]", table).
			replace("[newValue]", newValue).replace("[id]", id + "");
		
		try {
			connection = getConnection();

			ps = connection.prepareStatement(query);
			
			ps.executeUpdate();
			System.out.println("Store updated");
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
	}
	
	
	@Override
	public void delete(String table, int id) {
		String query = DELETE.replace("[table]", table).replace("[id]", id+"");
		try {
			connection = getConnection();

			ps = connection.prepareStatement(query);
			ps.executeUpdate();
			System.out.println("Deleted.");
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
		
	}


	




	}
