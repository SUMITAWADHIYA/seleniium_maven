package com.durgasoft.selenium_maven_ebay;

import org.testng.annotations.Test;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class url {
	public WebDriver driver;
  @Test
  public void search() throws Exception {
	  driver.findElement(By.id("gh-ac")).sendKeys("Cloths");
	  driver.findElement(By.id("gh-btn")).click();
	  File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file, new File("D:\\screenshoot\\image.png"));
	  System.err.println("file will be screenshoot"+file);
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://ebay.com");
  }

}
