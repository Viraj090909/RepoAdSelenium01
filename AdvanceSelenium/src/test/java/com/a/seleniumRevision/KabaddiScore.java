package com.a.seleniumRevision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


// display kabaddi team name, total mathces, wins and points
public class KabaddiScore {
	
	public static void main(String[] args) {
		
		
		EdgeOptions opt = new EdgeOptions();
        opt.addArguments("start-maximized");
        
        
		
		WebDriver driver = new EdgeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://www.prokabaddi.com/standings");
		
		WebElement teamName = driver.findElement(By.xpath("//p[text()='Haryana Steelers']"));		
		WebElement totalMatches = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-play']"));		
		WebElement totalWins = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-won']"));		
		WebElement totalPoints = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data points']"));
		
		
		System.out.println("Team          : "+teamName.getText());
		System.out.println("Matches Played: " +totalMatches.getText());
		System.out.println("Wins          : "+totalWins.getText());
		System.out.println("Points        : "+totalPoints.getText());
	}

}
