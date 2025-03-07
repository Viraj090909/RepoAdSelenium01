package com.b.MYSQL;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

// do not run this program it will add the same emp again

public class InsertDataToDB {
	
	public static void main(String[] args) throws SQLException {
		
//		register driver : driver object passed to registerDriver()
		Driver driver_ref = new Driver();
		DriverManager.registerDriver(driver_ref);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/virajdb","root","sunbeam");
		
		Statement state  = conn.createStatement();
		int result = state.executeUpdate("insert into emp(emp_id,name,designation,salary)values(11,'Akash Metkar','Sales',53000);");
		
		if(result == 1) {
			System.out.println("emp no 11 added");
		}
		else {
			System.out.println("error");
		}
			
	}

}
