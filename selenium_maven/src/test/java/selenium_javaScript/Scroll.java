package selenium_javaScript;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Scroll {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("scroll(0,200)");
	  Thread.sleep(3000);
	  jse.executeScript("scrollBy(0,500)");
	  Thread.sleep(3000);
	  jse.executeScript("scrollintoView(1000)");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "F:\\driver\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://Amazon.in");
  }
}
