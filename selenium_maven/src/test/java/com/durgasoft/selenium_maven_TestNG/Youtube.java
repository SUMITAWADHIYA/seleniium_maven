package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Youtube {
	public WebDriver driver;
  @Test
  public void serach() throws Exception {
	  
	  driver.findElement(By.name("search_query")).sendKeys("avatar 2 trailer");
	  Thread.sleep(3000);
	  driver.findElement(By.id("search-icon-legacy")).click();
	  Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","F:\\driver\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.get("http://youtube.com");
  }
}
