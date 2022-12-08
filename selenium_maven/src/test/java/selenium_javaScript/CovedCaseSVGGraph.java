package selenium_javaScript;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class CovedCaseSVGGraph {
	public WebDriver driver;
	
  @Test
  public void SVGGraph() {
	 List<WebElement> graphlist = 
			 driver.findElements(By.xpath("//*[@id=\\\"fc_1\\\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[3]"));
	 Actions ac = new Actions(driver);
	 for(WebElement e : graphlist) {
		 ac.moveToElement(e).build().perform();
		 String text = driver.findElement
				 (By.xpath("//*[@id=\"fc_1\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/svg/path")).getText();
		 System.out.println(text);
	 }
	 
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","F:\\driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://www.google.com/search?q=india+coved+case&oq=india+coved+case&aqs=chrome..69i57.5881j0j1&sourceid=chrome&ie=UTF-8");
	  
  }

}
