package com.c.TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEg1 {

//  soft assert is used for non mandatory fields	
	
//	all methods are non static : ie an object of class must be made to use its method

//  if the assert fails , execution does not stop , it continues and an exception will be thrown at the end
	
//	exception name : AssertionError
	
//	AssertAll() method is mandatory : AssertAll() is the method that throws the exception 
//	                                : it tracks all the soft asserts and if one of the asserts fail -> assertAll() throws AssertionError
	

	
	@Test
	public void demo() {
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals("actualValue","expectedValue"); // checks whether actualData is equal to expectedData. if data doest match, assert is fails
		System.out.println("after first soft assert");
		
		sa.assertEquals("abc","abc");
		System.out.println("after second soft assert");
		
		sa.assertAll();
	}
	
	
}
