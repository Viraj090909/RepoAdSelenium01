package com.c.TestNG;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.ExcelUtility;
import Generic_Utility.JavaUtility;
import Generic_Utility.WebDriverUtility;

public class DataProviderEg4 {
	

		
		@Test(dataProvider = "getData")
		public void CreateOrganization(String orgName, String phoneNumber, String email) throws Throwable {
			
			 WebDriver driver = new ChromeDriver();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.manage().window().maximize();
			 driver.get("http://localhost:8888/index.php?action=index&module=Home");
			 
			 
			 driver.findElement(By.name("user_name")).sendKeys("admin");
			 driver.findElement(By.name("user_password")).sendKeys("admin");
			 
			 driver.findElement(By.id("submitButton")).click();
			 
		
			 driver.findElement(By.linkText("Organizations")).click();
			 driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();

             JavaUtility jlib = new JavaUtility();
            
			 driver.findElement(By.name("accountname")).sendKeys(orgName+jlib.getRandomNum(1000));

			 driver.findElement(By.id("phone")).sendKeys(phoneNumber);		 

			 driver.findElement(By.id("email1")).sendKeys(email);

			 
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 
			 String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
			 if(actData.contains(orgName))
				{
					System.out.println("Organization Name is Created: " + orgName);
					System.out.println("PhoneNo: " + phoneNumber);
					System.out.println("Email: " + email + "\n");
				}
			 else
				{
					System.out.println("Organization name not created");

				}
			 
//	       logout	    
	 	     driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td")).click();	    
	 	     driver.findElement(By.linkText("Sign Out")).click();
			 
		
			 
	}
			 
			
		
		
		
		@DataProvider
		public Object[][] getData() throws Throwable{
			ExcelUtility elib = new ExcelUtility();
			Object[][] arr = elib.getExcelDataByDataProvider("Sheet1",5,4,7,6);
			return arr;
		}
		
		

		
	}


