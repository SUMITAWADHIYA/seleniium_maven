package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import com.durgasoft.selenium_maven_java.BasePage;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class RGPV extends BasePage{
  @Test
  public void RGV() throws Exception{
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//i[@class='fa fa-times-circle']")).click();
	 WebElement header = driver.findElement(By.xpath("//div[@class='panel-body']"));
	 List<WebElement> links = header.findElements(By.tagName("a"));
	 System.out.println("Available links"+links.size());
	 for(int i=0;i<links.size();i++) {
		 System.out.println(links.get(i).getText());
		 links.get(i).click();
		 Thread.sleep(3000);
		 System.out.println(driver.getCurrentUrl());
		 Set<String> Wins = driver.getWindowHandles();
		 System.out.println(Wins);
		 Object[] s = Wins.toArray();
		 driver.switchTo().window(s[1].toString());
		 driver.close();
		 driver.switchTo().window(s[0].toString());
		 header = driver.findElement(By.xpath("//div[@class='panel-body']"));
		 links = header.findElements(By.tagName("a"));		
	 }	 
  }
  @BeforeTest
  public void beforeTest() {
	  browserLunch("Chrome", "https://www.rgpv.ac.in/");
  }

}
