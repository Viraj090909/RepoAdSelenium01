package com.a.seleniumRevision;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


// display names of all the products that appear when you search a product name in flipkart
public class FlipkartSearchProductList {
	
	public static void main(String[] args) throws InterruptedException {
		EdgeOptions opt = new EdgeOptions();
        opt.addArguments("start-maximized");
		
		WebDriver driver = new EdgeDriver(opt);
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("iphone",Keys.ENTER);
		List<WebElement> phoneList = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));

//		Thread.sleep(1000);
//		
//		for(int i=0; i<phoneList.size(); i++)
//		{
//			System.out.println(phoneList.get(i).getText());
//			
//		}
		
		phoneList.forEach(element -> {System.out.println(element.getText());});
		
	}
	
//	o/p:
//		Apple iPhone 16 Plus (Black, 256 GB)
//		Apple iPhone 13 (Blue, 128 GB)
//		Apple iPhone 16 (Black, 256 GB)
//		Apple iPhone 16 (Black, 512 GB)
//		Apple iPhone 16 Plus (Black, 512 GB)
//		Apple iPhone 16 (White, 512 GB)
//		Apple iPhone 16 (Black, 128 GB)
//		Apple iPhone 16 Plus (Black, 128 GB)
//		Apple iPhone 16 (White, 256 GB)
//		Apple iPhone 16 (White, 128 GB)
//		Apple iPhone 16 (Ultramarine, 256 GB)
//		Apple iPhone 16 (Ultramarine, 128 GB)
//		Apple iPhone 16 Plus (Ultramarine, 512 GB)
//		Apple iPhone 16 (Ultramarine, 512 GB)
//		Apple iPhone 16 Plus (Ultramarine, 256 GB)
//		Apple iPhone 16 Plus (Teal, 512 GB)
//		Apple iPhone 16 Plus (Ultramarine, 128 GB)
//		Apple iPhone 16 Plus (Teal, 256 GB)
//		Apple iPhone 16 (Pink, 256 GB)
//		Apple iPhone 16 Plus (Pink, 128 GB)
//		Apple iPhone 16 (Teal, 256 GB)
//		Apple iPhone 16 Plus (Teal, 128 GB)
//		Apple iPhone 16 (Pink, 128 GB)
//		Apple iPhone 16 Plus (Pink, 512 GB)
	


}
