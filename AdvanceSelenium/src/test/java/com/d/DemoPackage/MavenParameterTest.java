package com.d.DemoPackage;

import org.testng.annotations.Test;

import Generic_Utility.BaseClassForMaven;

/*
 *  To allow passing the browser type as a parameter in the Maven command (mvn test -Dbrowser=chrome), you need to modify your BaseClass to fetch the browser name from System properties instead of FileUtility.

Modify BaseClass : 
Replace          :   String BROWSER = flib.getCommonData("browser");

With             :   String BROWSER = System.getProperty("browser", "browserName"); 
 
 * 
 */





public class MavenParameterTest extends BaseClassForMaven {
	
	@Test
	public void Test1() {
		System.out.println("on homepage");
	}

}
