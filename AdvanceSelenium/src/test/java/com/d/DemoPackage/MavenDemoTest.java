package com.d.DemoPackage;

import org.testng.annotations.Test;



//mvn test runs @Test methods from classes in src/test/java. (className must have 'Test' as suffix. eg MavenDemoTest.java) 

//mvn test                             : runs all the methods with @Test annotation : src/test/java/ --> className.java --> @Test

//mvn test -Dtest=MavenDemoTest        : runs a particular test class in src/test/java

//mvn test -Dtest=MavenDemoTest#test1  : rusn a particular test method in a particular class in src/test/java ( here method name is test1)

//mvn test -Dtest=MavenDemoTest#test2  : rusn a particular test method in a particular class in src/test/java ( here method name is test2)


public class MavenDemoTest {
	
	@Test
	public void test1() {
		System.out.println("inside test1");
	}
	
	@Test
	public void test2() {
		System.out.println("inside test2");
	}

}
