package com.durgasoft.selenium_maven_ebay;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class url {
	public WebDriver driver;
  @Test
  public void search() {
	  driver.findElement(By.id("gh-ac")).sendKeys("Cloths");
	  driver.findElement(By.id("gh-btn")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","F:\\driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://ebay.com");
  }

}
