package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import com.durgasoft.selenium_maven_java.BasePage;
import atu.testrecorder.ATUTestRecorder;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class BBC extends BasePage {
	ATUTestRecorder recorder;
	@Test(priority =0 )
	public void link() throws Exception {
		WebElement header = driver.findElement(By.xpath("//div[@class='most-popular']"));
		List<WebElement> links = header.findElements(By.tagName("a"));
		System.out.println("Avaiable links"+links.size());
		for(int i=0;i<links.size();i++) {
			System.out.println(links.get(i).getText()); 
			links.get(i).click();
			Thread.sleep(3000);
			System.out.println(driver.getCurrentUrl());
			driver.navigate().back();
			header = driver.findElement(By.xpath("//div[@class='most-popular']"));
			links = header.findElements(By.tagName("a"));
		}
	}
	@Test(priority =1 )
	public void close() throws Exception {
		driver.close();
		recorder.stop();
		
	}
	@BeforeTest
	public void beforeTest() throws Exception {
		recorder= new ATUTestRecorder("F://recoder", "BBC",false);
		recorder.start();
		browserLunch("Chrome", "http://BBC.com");
	}

}
