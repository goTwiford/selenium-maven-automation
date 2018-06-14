package com.dice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	public static void main(String[] args) {
		// Set up chrome dirver path
		WebDriverManager.chromedriver().setup();
		// invoke selenim webdriver
		WebDriver driver = new ChromeDriver();
		// fullscreen
		driver.manage().window().fullscreen();

		// set universal wait time in case web is slow

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch browser and navigate to
		// https://dice.com
		//
		// Expected: dice home page should be displayed

		String url = "https://dice.com";
		driver.get(url); // navigation

		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Step PASS.Dice Homepage successfully loaded");
		} else {
			System.out.println("Step Fail. Dice homepage did not load successfully");
			throw new RuntimeException("Step Fail. Dice homepage did not load successfully");
		}
		ArrayList<String> keywordList= new ArrayList<>();
		keywordList.add("SharePoint Requirements Analyst");
		keywordList.add("Java developer");
		keywordList.add("Sr. QA Lead");
		keywordList.add("UI Developer");
		keywordList.add(".NET Developer");
		keywordList.add("Junior Software Development Engineer in Test (SDET)");
		keywordList.add("K2 SharePoint Developer");
		keywordList.add("Project Analyst");
		keywordList.add("Software development (Tableau)");
		keywordList.add("Test Engineer");
		keywordList.add("Sr. Business Analyst/Project Manager");
		keywordList.add("DELTEK ENTERPRISE ANALYST");
		keywordList.add("Secret Cleared Security Analyst (Veteran Friendly)");
		keywordList.add("Telecommunication Admin ");
		keywordList.add("Mid-Level ISSO");
		keywordList.add("Linux NOC Analyst");
		keywordList.add("Secret Cleared Linux Admin/ Engineer");
		keywordList.add("Quantitative Modeler");
		keywordList.add("Incident Manager");
		keywordList.add("IT Security Specialist");
		
		
		
		for (String keyword : keywordList) {
			
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		String location = "22102";
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		driver.findElement(By.id("findTechJobs")).click();

		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		//chacking if count biger than 0
		int countResult= Integer.parseInt(count.replaceAll(",", ""));
	
			if (countResult>0) {
			
			System.out.println("keyword : " + keyword+" search returnd "+countResult +" results in "+location);
		}else {
			System.out.println("Search FAILS keyword: " + keyword+" search returnd "+countResult +" results in "+location);
		}
			driver.navigate().back();
		
		}
		
		driver.close();
		System.out.println("Tist Complited -"+ LocalDateTime.now());
		
//		Step 1. Launch browser and navigate to
//		 https://dice.com
//
//		Expected: dice home page should be displayed
//
//		Steps 2: Insert search keyword and location then click on find tech jobs git
//		Expected: 
//		1.Search results page should be loaded. 
//		2. Page tile should contain count of results along with search keyword.
//		3. Count of results should be displayed on the page.

	}

}
