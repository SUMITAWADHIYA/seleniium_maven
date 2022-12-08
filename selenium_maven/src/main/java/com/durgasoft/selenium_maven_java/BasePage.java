package com.durgasoft.selenium_maven_java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BasePage {
	public WebDriver driver;
	
	public void browserLunch(String browser,String url) {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "F:\\driver\\msedgedriver.exe");
			driver= new EdgeDriver();
			driver.manage().window().maximize();
		}
		driver.get(url);
	}
	

}
