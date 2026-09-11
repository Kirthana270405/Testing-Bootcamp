package databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseTest {
	@Test
	public void testDatabaseConnection() throws ClassNotFoundException, SQLException
	{
		String databaseURL="jdbc:mysql://localhost:3306/SeleniumAutomation";
		String user="root";
		String password="SaiK@2023";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connecting to Database");
		Connection con=DriverManager.getConnection(databaseURL,user,password);
		Statement stmt=con.createStatement();
		
		String query="SELECT * FROM SeleniumAutomation.book_detl:";
		ResultSet rs=stmt.executeQuery(query);
		
		while(rs.next()) {
			String auth=rs.getString("author");
			String tit=rs.getString("title");
			System.out.println("author: "+auth+ ", title: " +tit);
		}
		con.close();
		
		

}
}
