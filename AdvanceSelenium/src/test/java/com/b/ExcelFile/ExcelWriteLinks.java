package com.b.ExcelFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

// RESOURCE : src/test/resources/ExcelDataLinks.xlsx

public class ExcelWriteLinks {

	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		
		
		System.out.println(links.size());
		
		
//		Establish connection 
		String path = "src/test/resources/ExcelDataLinks.xlsx";
		FileInputStream fis = new FileInputStream(path);
		
//		excel file
		Workbook book = WorkbookFactory.create(fis);		
		Sheet s0 = book.getSheetAt(0);
		
		for (int i=0; i<links.size(); i++)
		{
			s0.createRow(i).createCell(1);
			s0.getRow(i).getCell(1).setCellValue(links.get(i).getAttribute("href"));
		
		}
		
		FileOutputStream fos = new FileOutputStream(path);
		book.write(fos);
		book.close();
		fos.close();
		

		
		
		
		
	}
}
