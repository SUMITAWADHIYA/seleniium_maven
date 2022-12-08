package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Autoit {
	public WebDriver driver;
	@Test
	public void autoIT() throws Exception {
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Perminent Registration")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("PNT_NAME")).sendKeys("Bhart");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='photo']")).click();
		Runtime.getRuntime().exec("F:\\HMS.exe");
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumbymahesh.com/HMS");

	}

}
