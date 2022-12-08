package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Irctc {
	public WebDriver driver;
  @Test
  public void Irctcs()throws Exception {
	  WebElement header = driver.findElement(By.xpath("https://www.irctc.co.in/nget/train-search"));
	 List<WebElement> link = header.findElements(By.tagName("a"));
	 System.out.println("Avaliable links:"+link.size());
	 for(int i=0; i<link.size();i++) {
		 link.get(i).click();
		 Thread.sleep(3000);
		 System.out.println(driver.getCurrentUrl());
		 
	 }
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "F://driver//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.get("https://www.irctc.co.in/nget/train-search");
  }

  @AfterTest
  public void afterTest() {
  }

}
