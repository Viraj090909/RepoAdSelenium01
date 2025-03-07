package com.b.JSON;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

// dependency : jackson-databind
// resource   : jsonFile.json

// login to swaglabs using key and value from json file (src/test/resources/jsonFile.json)

public class ReadJsonFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("src/test/resources/jsonFile.json");
		
		ObjectMapper obj = new ObjectMapper();   
		JsonNode jsn = obj.readTree(fis);         // read json file using ObjectMaper method : readTree(fis)
		
		String BROWSER = jsn.get("browser").asText();
		
//	    logic to switch browsers    
    
		WebDriver driver;
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		
//		get url,un,pass from json file
		
		String URL = jsn.get("url").asText();
		String UN  = jsn.get("un").asText();
		String PASS = jsn.get("pass").asText();
		
//		go to url
		driver.get(URL);		
//		enter un
		driver.findElement(By.id("user-name")).sendKeys(UN);
//		enter pass and enter
		driver.findElement(By.id("password")).sendKeys(PASS, Keys.ENTER);
				
		
	}
	
}
