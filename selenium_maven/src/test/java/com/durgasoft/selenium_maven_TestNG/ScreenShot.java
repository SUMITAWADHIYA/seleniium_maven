package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import com.durgasoft.selenium_maven_java.BasePage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class ScreenShot extends BasePage{
	@Test(enabled = false)
	public void Screen() throws Exception {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("F:\\recorder\\images.png"));
		System.out.println(file);
	}
	@Test(enabled =false)
	public void Screen_1() throws Exception {
		List<WebElement> links = driver.findElements(By.partialLinkText("NEW BATCHES"));
		System.out.println("Available links are:"+links.size());
		//	  links.get(0).click();
		for(int i=0;i<links.size();i++) {
			System.out.println("links name"+links.get(i).getText());
			links.get(i).click();
			System.out.println(driver.getCurrentUrl());
		}
		if(!(links.size()==0)) {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("F:\\recorder\\imagescreen.png"));
			System.out.println(file);	  
		}    
	}
	@Test
	public void ScreenData()throws Exception {
		List<WebElement> links = driver.findElements(By.partialLinkText("NEW BATCHES"));
		System.out.println("Available links are:"+links.size());
		links.get(0).click();
		System.out.println(links);
		Date dd = new Date();
		DateFormat Dformet = new SimpleDateFormat("dd-MM-yyy-hh-mm-ss");
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("F:\\recorder\\"+Dformet.format(dd)+"screenshort.png"));
	}
	@BeforeTest
	public void beforeTest() {
		browserLunch("Chrome","http://seleniumbymahesh.com");
		browserLunch(null, null);
	}
}
