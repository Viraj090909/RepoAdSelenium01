package com.a.seleniumRevision;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//go to big basket, search apple, select baby apple shimla from suggestion, display name of the product, price ,add to basket, increase count to 2kgs
public class BigBasket {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("start-maximized");      
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://www.bigbasket.com/");

//		search apple in searchbox:
//	    below xpath points to 2 elements and when you dont use index its using first which is hidden and thats why no auto suggestions appear and you have to use js to click on the product
//      driver.findElement(By.xpath("//input[@placeholder='Search for Products...']")).sendKeys("apple");

//		hence use the xpath that points to second element: ("//input[@placeholder='Search for Products...']")[2]
        
	
        
//      search apple in searchbox:		
        driver.findElement(By.xpath("(//input[@placeholder='Search for Products...'])[2]")).sendKeys("apple");
        
//      select from auto suggestion:      
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

        
		
		//mouse is hovering on product image which intercepts the target elements like productName, price, etc : ElementClickInterceptedException
        //hence, using Action class to set cursor position to top left corner
		Actions a = new Actions(driver);
		a.moveToLocation(0, 0)
		 .perform();	
		

		
		//product name
		String productName = driver.findElement(By.xpath("//h1[@class='Description___StyledH-sc-82a36a-2 bofYPK']")).getText();	
		System.out.println("Product Name     : "+productName);
		
		//prodcut price
		String productPrice = driver.findElement(By.xpath("//h1/ancestor::section[contains(@class,'Description')]//td[contains(text(),'Price')]")).getText();
		System.out.println("Produt Price     : "+productPrice.substring(8));

		
		//add to basket
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
		
		//print quantity
		WebElement quantity = driver.findElement(By.xpath("//div[@class=\"PdCartCTA___StyledDiv2-sc-mq73zq-2 cdHBKF\"]"));	
		System.out.println("Initial quantity : "+ quantity.getText());
		
		//increase count to 2kg
        driver.findElement(By.xpath("//div[@class=\"PdCartCTA___StyledDiv2-sc-mq73zq-2 cdHBKF\"]/following-sibling::button")).click();
        
        //print updated quantity of product
        //selenium will print quantity before its updated hence, using wait condition until the quantity is not equal to previous one : ExpectedConditions.not
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//div[@class=\"PdCartCTA___StyledDiv2-sc-mq73zq-2 cdHBKF\"]"), quantity.getText()))); 
        
        System.out.println("Updated quantity : "+quantity.getText());
        
      
       

		
		
		
	}
}
