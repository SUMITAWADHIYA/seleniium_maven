package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;

import com.durgasoft.selenium_maven_java.BasePage;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class BBC2 extends BasePage {
  @Test
  public void MoreAround()throws Exception {
	  WebElement header = driver.findElement(By.xpath("//div[@class='correspondent-headlines']"));
	   List<WebElement> link = header.findElements(By.tagName("a"));
	   System.out.println("Avaliable all Links"+link.size());
	   for(int i=0;i<link.size();i++) {
		   link.get(i).click();
		   Thread.sleep(3000);
		   System.out.println(driver.getCurrentUrl());
		   driver.navigate().back();
		   header = driver.findElement(By.xpath("//div[@class='correspondent-headlines']"));
		   link = header.findElements(By.tagName("a"));
	   }
  }
  @BeforeTest
  public void beforeTest() {
	  browserLunch("Chrome", "http://BBC.com");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
