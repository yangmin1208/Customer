package com.ym.customer.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtil {
	private static Properties properties = null;
	
	static{
	
		try {
			InputStream inputStream = JdbcUtil.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			properties = new Properties();
			properties.load(inputStream);
			Class.forName(properties.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection connection = null;
		try {
			/*connection = DriverManager.getConnection(properties.getProperty("url"),
					properties.getProperty("username"),
					properties.getProperty("password"));*/
			connection = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:XE", "summer", "summer");
			//System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
		
	}
}
