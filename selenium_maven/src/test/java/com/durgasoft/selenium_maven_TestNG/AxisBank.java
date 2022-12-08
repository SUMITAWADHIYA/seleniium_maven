package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class AxisBank {
	public static WebDriver driver;
  @Test
  public void f() throws Exception {
	  Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='close_button']")).click();
	  WebElement header = driver.findElement(By.xpath("//div[@class='productsViewWrap']"));
	  List<WebElement> links = header.findElements(By.tagName("a"));
	  System.out.println("Avalible links:"+links.size());
	  for(int i=0;i<links.size();i++) {
		  System.out.println(links.get(i).getText());
		  Thread.sleep(3000);
		  links.get(i).click();
		  System.out.println(driver.getCurrentUrl());
		  driver.navigate().back();
		  driver.findElement(By.xpath("//div[@class='close_button']")).click();
		  header = driver.findElement(By.xpath("//div[@class='productsViewWrap']"));
		  links = header.findElements(By.tagName("a"));
	  }  	
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  HashMap<String, Integer> conentSettings = new HashMap<String, Integer>();
	  HashMap<String, Object> proflie = new HashMap<String, Object>();
	  HashMap<String, Object> prefs = new HashMap<String, Object>();
	  conentSettings.put("notifications",2);
	  conentSettings.put("geoloction", 2);
	  conentSettings.put("media_stream", 1);
	  proflie.put("managed_default_content_settings",conentSettings);
	  prefs.put("proflie", proflie);
	  options.setExperimentalOption("prefs", prefs);	  
	  driver= new ChromeDriver(options);
	  driver.manage().deleteAllCookies();
	  driver.get("https://www.axisbank.com/");
  }
}
