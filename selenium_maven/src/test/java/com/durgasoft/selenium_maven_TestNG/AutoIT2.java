package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class AutoIT2 {
	public WebDriver driver;
  @Test
  public void Upload() {
	   //driver.findElement(By.id("imagesrc")).click();
	   WebElement element = driver.findElement(By.id("imagesrc"));
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("Choose File[0].click();", element);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
  }

}
