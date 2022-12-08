package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Javascripexecutor {
	public WebDriver driver;
  @Test
  public void java() throws Exception {
	  JavascriptExecutor js =(JavascriptExecutor)driver;
	  js.executeScript("document.getElementById('email').value='sumitawa'");
	  js.executeScript("document.getElementById('pass').value='Didi0000'");
	  js.executeScript("document.getElementsByName('login')[0].click()");
	  Thread.sleep(5000);
	  js.executeScript("scroll(0,1000)");//scroll driver
  }
  @BeforeTest
  public void beforeTest() {
	 System.setProperty("webdriver.chrome.driver","F:/driver/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://facebook.com");	 
}
}
