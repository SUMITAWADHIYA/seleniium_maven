package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class ActionsClass {
	public WebDriver driver;
  @Test(enabled=false)
  public void Drag() {//drag and drop 
	  driver.switchTo().frame(0);
	  WebElement drag = driver.findElement(By.id("draggable"));
	  Actions a = new Actions(driver);
	  a.clickAndHold(drag).moveByOffset(40,60).release().build().perform();	  
	  }
  @Test(enabled=false)
  public void Dragdown() {//move to drag and drop
	  driver.findElement(By.linkText("Droppable")).click();
	  driver.switchTo().frame(0);
	  WebElement drag = driver.findElement(By.id("draggable"));
	  WebElement drop = driver.findElement(By.id("droppable"));
	  Actions ac= new Actions(driver);
//	  ac.dragAndDrop(drag, drop).build().perform();
	  ac.clickAndHold(drag).moveToElement(drop).release().build().perform();
  }
  @Test
  public void resizeObject() {// resize to object
	  driver.findElement(By.linkText("Resizable")).click();
	  driver.switchTo().frame(0);
	  WebElement resize = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
	  
	  Actions aa = new Actions(driver);
	  aa.dragAndDropBy(resize,100,150).perform();
	  aa.moveToElement(resize, 200,100);	
	  aa.clickAndHold();
	  aa.moveByOffset(200, 150);
	  aa.release();
	  aa.perform();
	 
	  
  }
  @Test(enabled=false)
  public void Slider() {
	  driver.findElement(By.linkText("Slider")).click();
	  driver.switchTo().frame(0);
	  WebElement slide = driver.findElement(By.xpath("//*[@id='slider']/span"));
	  Actions action = new Actions(driver);
	  action.dragAndDropBy(slide,100,0).build().perform();
//	  action.clickAndHold(slide).moveByOffset(300,0).release().build().perform();	  
  }
  @Test(enabled=false)
  public void RightClickOnElement() {//right click on any Element
	  WebElement element = driver.findElement(By.xpath(""));
	  Actions actions = new Actions(driver);
	  actions.contextClick(element).perform();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","F://driver//chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
//	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.get("https://jqueryui.com/draggable/");
  }

}
