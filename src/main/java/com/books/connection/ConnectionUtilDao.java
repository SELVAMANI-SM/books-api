package com.books.connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtilDao {
	public static Connection sqlConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://database-1.c6gq5snketde.ap-south-1.rds.amazonaws.com/groce_db","sunayana","sunnu123");
		return connection;
				
	}
}
