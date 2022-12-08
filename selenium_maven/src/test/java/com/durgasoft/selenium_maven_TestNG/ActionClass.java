package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class ActionClass {
	public WebDriver driver;
  @Test
  public void f()throws Exception {
	  WebElement element = driver.findElement(By.linkText("FAQ’S"));
	  Actions action = new Actions(driver);
	  action.moveToElement(element).build().perform();
	  Thread.sleep(3000);
	  driver.findElement(By.partialLinkText("Selenium")).click();
	  action.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
	  Thread.sleep(3000);
	  action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform(); 
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","F:\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://seleniumbymahesh.com");	  
  }
}
