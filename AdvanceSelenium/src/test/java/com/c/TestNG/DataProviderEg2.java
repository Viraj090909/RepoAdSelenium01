package com.c.TestNG;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.ExcelUtility;
import Generic_Utility.FileUtility;
import Generic_Utility.JavaUtility;
import Generic_Utility.WebDriverUtility;
import POM_REPO.CreateOrganizationPage;
import POM_REPO.HomePage;
import POM_REPO.LoginPage;
import POM_REPO.OrganizationInfoPage;
import POM_REPO.OrganizationsPage;

public class DataProviderEg2 {
	
	@Test(dataProvider = "getData")
	public void Organization(String OrgName, String PhoneNumber, String Email) throws Throwable {
		
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 driver.get("http://localhost:8888/index.php?action=index&module=Home");
		 
		 
		 driver.findElement(By.name("user_name")).sendKeys("admin");
		 driver.findElement(By.name("user_password")).sendKeys("admin");
		 
		 driver.findElement(By.id("submitButton")).click();
		 
	
		 driver.findElement(By.linkText("Organizations")).click();
		 driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();

		 
		 driver.findElement(By.name("accountname")).sendKeys(OrgName);

		 driver.findElement(By.id("phone")).sendKeys(PhoneNumber);		 

		 driver.findElement(By.id("email1")).sendKeys(Email);

		 
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		 if(actData.contains(OrgName))
			{
				System.out.println("Organization Name is Created: " + OrgName);
				System.out.println("PhoneNo: " + PhoneNumber);
				System.out.println("Email: " + Email + "\n");
			}
		 else
			{
				System.out.println("Organization name not created");

			}
		 
//       logout	    
 	     driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td")).click();	    
 	     driver.findElement(By.linkText("Sign Out")).click();
		 
	
		 }
		 
		
	
	
	
	@DataProvider
	public Object[][] getData(){
		
		
		Object arr[][] = new Object[3][3];
		
		Random ranNo = new Random();
		
	    DataFormatter df = new DataFormatter();
	    
		
		arr[0][0] = "org" + ranNo.nextInt(1000) ;
		arr[0][1] = "9000000"+ranNo.nextInt(1000);
		arr[0][2] = "abc" + ranNo.nextInt(1000) + "@gmail.com";
		
		arr[1][0] = "org" + ranNo.nextInt(1000) ;
		arr[1][1] = "9000000"+ranNo.nextInt(1000);
		arr[1][2] = "abc" + ranNo.nextInt(1000) + "@gmail.com";
		
		arr[2][0] = "org" + ranNo.nextInt(1000) ;
		arr[2][1] = "9000000"+ranNo.nextInt(1000);
		arr[2][2] = "abc" + ranNo.nextInt(1000) + "@gmail.com";

		
		return arr;
	}

}



