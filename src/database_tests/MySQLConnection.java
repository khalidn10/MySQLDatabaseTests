package database_tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		// Set the host name
		String host = "localhost";
		
		// Set the port no.
		String port = "3306";
		
		// Set MySQL database you want to connect to
		String database = "mydatabase";
		
		// Set the URL of the MySQL database you want to connect to
		String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
		
		// Set the user to access the MySQL server (normally 'root')
		String user = "root";
		
		// Set the password to access the MySQL server (password selected when installing MySQL server)
		String password = "password";
		
		// Create a connection to the database
		Connection conn = DriverManager.getConnection(url, user, password);
		
		// Create an object to send a statement to the database via the connection
		Statement stmnt = conn.createStatement();
		
		// Create a query
		String query1 = "select * from table where column = 'columnvalue'";
		
		// Execute the query and store the results
		ResultSet results = stmnt.executeQuery(query1);
		
		// Retrieve the number of columns in the results
		int noOfCols = results.getMetaData().getColumnCount();
		
		// Print out the column names
		// This will need a method to pad out the names so they can be aligned with the column values
		for (int i = 1; i < noOfCols+1; i++)
		{
			System.out.print(results.getMetaData().getColumnName(i));
		}
		System.out.println("");
		
		// Use a while loop to process (in this case print out) the records returned within the results
		// This will need a method to pad out the values so that each column is aligned
		// Within a Selenium test, the values can potentially be used to insert data into something like a webform (for example)
		while (results.next())
		{
			for (int i = 1; i < noOfCols+1; i++)
			{
				System.out.print(results.getRowId(i).toString());
			}
			System.out.println("");
		}
	}
	
}
