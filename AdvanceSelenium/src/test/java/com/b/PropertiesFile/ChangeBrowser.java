package com.b.PropertiesFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


// fis : ChangeBrowser.properties
// fos : ChangeBrowserModified.properties

public class ChangeBrowser {
	
	
	public static void main(String[] args) throws IOException {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.addArguments("--disable-notifications--");
				
		
		
//		establish connection to file using file path
		FileInputStream fis = new FileInputStream("src/test/resources/ChangeBrowser.properties");
	
//		to read Properties file : use Properties object
		Properties pro = new Properties();
	
//		to read Properties file : use load(arg) method : arg is FileInputStream object 
	    pro.load(fis);
	    

//	    logic to switch browsers    
	    String BROWSER = pro.getProperty("browser");
	    
		WebDriver driver;
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(opt);
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		
//		get url from properties file
		String URL = pro.getProperty("url");
		driver.get(URL);
	
//		get username
		String UN = pro.getProperty("un");
		driver.findElement(By.id("user-name")).sendKeys(UN);

//		get password
		String PASS = pro.getProperty("pass");
		driver.findElement(By.id("password")).sendKeys(PASS, Keys.ENTER);
		
//		write data in Properties file 
//		setProperty(): Adds key-value pairs to the Properties object.
//		FileOutputStream: Creates a file (if it doesn’t exist) or opens an existing file for writing.
//		store(): Writes the key-value pairs into the specified Properties file. You can include a comment describing the file's purpose.
//		close(): Closes the stream to release resources.
		
		
//		step 1:
//		pro.setProperty("key","value")  : if the key exists value will be modified(overridden to existing key)
//		                                : if the key doesnt exist, a new key = value will be created in Properties file
//		step 2:
//		pro.stroe(FileOutputStream object, Comment) : commnet will appear as a heading in Properties file
		
		pro.setProperty("un", "problem_user");
		
		FileOutputStream fos = new FileOutputStream("src/test/resources/ChangeBrowserModified.properties");	
		
		pro.store(fos, "updated un to problem_user");	
		fos.close();
		
	    
		
		
		
	}

}
