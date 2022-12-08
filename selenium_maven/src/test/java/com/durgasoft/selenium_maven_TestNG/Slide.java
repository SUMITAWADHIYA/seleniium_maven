package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class Slide {
	public WebDriver driver;
	@Test
  public void f() throws Exception {
//		WebElement image = driver.findElement(By.tagName("img"));
		WebElement image = driver.findElement(By.xpath("//img[@class='n2-ow']"));
		System.out.println(image);
		Actions action = new Actions(driver);
		action.clickAndHold(image).moveToElement(image).release().build().perform();
		Thread.sleep(1000);
		action.clickAndHold(image).moveToElement(image).release().build().perform();
		Thread.sleep(1000);
		action.clickAndHold(image).moveToElement(image).release().build().perform();
  }
	@Test(enabled =false)
	public void slid() {
		driver.navigate().to("http://executeautomation.com/demosite/index.html");

		WebElement menu = driver.findElement(By.id("Automation Tools"));
		WebElement selenium = driver.findElement(By.id("Selenium"));
		WebElement seleniumWebDriver = driver.findElement(By.id("Selenium WebDriver"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).moveToElement(selenium).moveToElement(seleniumWebDriver).click().build().perform();
	}
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://practice.automationtesting.in/");
  }

}
