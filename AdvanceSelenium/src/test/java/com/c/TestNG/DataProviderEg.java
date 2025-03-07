package com.c.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.*;



// *  DataProvider : 
// *  
// *                           
// *   
// *  
// *  
// *  
// *  Test Method   : bookTicket(String fromStation, String toStation)
// *  Data provider : getDataFromProvider()
// *  
// *  What does Data Provider do : Data provider passes the array values to test method parameters every time the test is executed.
// *                
// *                for first time execution:
// *                array Row1 :  1st column value is passed to 1st parameter(fromStation) and 2nd column value passed to 2nd parameter(toStation)
// *                
// *                for second time execution:
// *                array Row2 :  1st column value is passed to 1st parameter(fromStation) and 2nd column value passed to 2nd parameter(toStation
// *                 
// *                for third time execution:
// *                array Row3 :  1st column value is passed to 1st parameter(fromStation) and 2nd column value passed to 2nd parameter(toStation)
// *                
// *                
// *  Size of the 2d Object Array : Object[][] arr = new Object[m][n];
// *  
// *  m = No. of Rows    :  No of parameters
// *  
// *  n = No. of columns :  No. of tests to be conducted
// *  
// *  For bookTicket() method  : parameters are fromStation and toStation --> No of columns = 2 (n=2)
// *                           : m = no of times the test is to be conducted lets say 3 times --> you will have to pass 2 parameters 3 times
// *  
// *  
// *  
//    @DataProvider 
//	public Object[][] getDataFromProvider(){
//		Object arr[][] = new Object[3][2];
//		
//		//for 1st invocation of test
//		arr[0][0] = "AMRAVATI";  // passed to bookTicket parameter : fromStation
//		arr[0][1] = "PUNE";      // passed to bookTicket parameter : toStation
//		
//		//for 2nd invocation of test
//		arr[1][0] = "AMRAVATI";
//		arr[1][1] = "MURTIZAPUR";
//		
//		//for 3rd invocation of test 
//		arr[2][0] = "AMRAVATI";
//		arr[2][1] = "NAGPUR";
//		
//		
//		return arr;
//	}
//	
//	public void bookTicket(String fromStation, String toStation)
//	
//	
//
// 














public class DataProviderEg {
	
	// this method prints source and destination from DataProvider
	
	@Test(dataProvider = "getDataFromProvider")
	public void bookTicket(String fromStation, String toStation) {
	
		System.out.println("From station: " + fromStation + "\t\t" + "To station: " +  toStation + "\n");
		
	}
	
	
	
	@DataProvider
	public Object[][] getDataFromProvider() {
		
		Object arr[][] = new Object[3][2];

		// for 1st invocation of test
		arr[0][0] = "AMRAVATI"; // passed to bookTicket parameter : fromStation
		arr[0][1] = "PUNE";     // passed to bookTicket parameter : toStation

		// for 2nd invocation of test
		arr[1][0] = "AMRAVATI";
		arr[1][1] = "MURTIZAPUR";

		// for 3rd invocation of test
		arr[2][0] = "AMRAVATI";
		arr[2][1] = "NAGPUR";

		return arr;
	}
}
