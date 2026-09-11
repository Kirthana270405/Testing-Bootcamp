package databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class DatabaseTesting {
	private Connection connection;
	@Test
	public void establishDatabaseConnection() throws ClassNotFoundException, SQLException
	{
		String databaseURL="jdbc:mysql://localhost:3306/SeleniumAutomation";
		String user="root";
		String password="SaiK@2023";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connecting to Database");
		connection=DriverManager.getConnection(databaseURL,user,password);
		
		if (connection==null) {
			System.out.println("Database Connection Failed");
		}else {
			System.out.println("Database Connection Successful");
		}
	}

}
