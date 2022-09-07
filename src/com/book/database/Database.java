package com.book.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
	static String driverClass = "com.mysql.cj.jdbc.Driver";
	static String url = null;
	static String name = null;
	static String password = null;
	
	
	
	private static Database database = null;
	
	private Database() {
		try {
			Class.forName(driverClass);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try(InputStream input = new FileInputStream("res/app.properties")) {
			Properties properties = new Properties();
			properties.load(input);
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password"); 
			conn = DriverManager.getConnection(url,name,password);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Database getInstance() {
		if(database == null) {
			database = new Database();
		}
		return database;
	}

}
