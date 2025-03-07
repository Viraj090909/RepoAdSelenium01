package com.b.MYSQL;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDB {

	
	public static void main(String[] args) throws SQLException {
		
//		register driver : driver object passed to registerDriver()
		Driver driver_ref = new Driver();
		DriverManager.registerDriver(driver_ref);
		
//		establish connection to a Database : DriverManager.getConnection("url","userName","Password")
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/virajdb","root","sunbeam");
		
//		create sql statement : createStatement()
		Statement state = conn.createStatement();
		
//		execute query and store in a ResultSet : executeQuery("query")
		ResultSet result = state.executeQuery("select * from emp");
		
//		print result: result.getString/getInt(arg)  : arg is column no
		while(result.next())
		{
			System.out.println( result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3));   
		}
		
//		close connection
		conn.close();
		
	}
}
