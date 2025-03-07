package com.c.TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/*
 * 
 * 
 *  DataProvider : 
 *  
 *  Size of the 2d Object Array : Object[][] arr = new Object[m][n];
 *  
 *  m = No. of Rows    :  No of parameters
 *  
 *  n = No. of columns :  No. of tests to be conducted
 *  
 *  For createOrganization() method  : parameters are OrgName and PhoneNo and Email --> No of columns = 3 (n=3)
 *                                   : m = no of times the test is to be conducted lets say 3 times --> you will have to pass 3 parameters 2 times
 * 
 * 
 */
public class DataProviderEg3 {
	
	
	@Test(dataProvider = "getData")
	public void CreateOrganization(String OrgName, String PhoneNumber, String Email) throws Throwable {
		
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
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		
		
		Object arr[][] = new Object[2][3];
		
		Random ranNo = new Random();
		
		DataFormatter df = new DataFormatter();
		
		
	    FileInputStream fis = new FileInputStream("./src/test/resources/vtiger_excel.xlsx");
	    Workbook book = WorkbookFactory.create(fis);
	    

//		for test invocation 1 : 
//      public void CreateOrganization(String OrgName = arr[0][0], String PhoneNumber = arr[0][1], String Email = arr[0][2])
		arr[0][0] = book.getSheetAt(0).getRow(11).getCell(2).getStringCellValue() +  ranNo.nextInt(1000) ;
		arr[0][1] = df.formatCellValue(book.getSheetAt(0).getRow(12).getCell(2)) + ranNo.nextInt(1000);
		arr[0][2] = book.getSheetAt(0).getRow(13).getCell(2).getStringCellValue();
		
		arr[1][0] = book.getSheetAt(0).getRow(11).getCell(2).getStringCellValue() +  ranNo.nextInt(1000);
		arr[1][1] = df.formatCellValue(book.getSheetAt(0).getRow(12).getCell(2)) + ranNo.nextInt(1000);
		arr[1][2] = book.getSheetAt(0).getRow(13).getCell(2).getStringCellValue();
		


		return arr;
	}


}
 