package com.a.seleniumRevision;

import java.lang.reflect.Array;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


// display colour names that appears when you search iphone 16 on amazon.in
public class PhoneColours {
	
	public static void main(String[] args) {
		
		
		EdgeOptions opt = new EdgeOptions();
        opt.addArguments("start-maximized");
		
		WebDriver driver = new EdgeDriver(opt);
		
		driver.get("https://www.amazon.in/");

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone16",Keys.ENTER);
		
		List<WebElement> colour_list = driver.findElements(By.xpath("//span[text()='iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Black']/ancestor::div[@class='a-section']//a[@class='a-link-normal']"));
		
		colour_list.forEach(element -> {System.out.println(element.getAttribute("aria-label"));});
		
		
	}
	
//	o/p:
//		White
//		Black
//		Pink
//		Teal
//		Ultramarine

}
