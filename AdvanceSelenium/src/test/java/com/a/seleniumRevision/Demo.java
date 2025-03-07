package com.a.seleniumRevision;

import java.time.Duration;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Demo {
	
	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("start-maximized");      
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://www.bigbasket.com/");
	
        driver.findElement(By.xpath("(//input[@placeholder=\"Search for Products...\"])[2]")).sendKeys("apple");
             
		
		List<WebElement> autoList = driver.findElements(By.xpath("//span[@class='Label-sc-15v1nk5-0 QuickSearch___StyledLabel2-sc-rtz2vl-7 gJxZPQ gFDEBU']"));
		
		System.out.println(autoList.size());
		
		WebElement requiredProduct = null;
		
		for(int i=0; i<autoList.size(); i++)
		{
		    if(autoList.get(i).getText().contains("Baby Apple Shimla")) {
		    	requiredProduct = autoList.get(i);
		    	break;
		    }		    
			
		}
		
		requiredProduct.click();
		
		
	}

}
