package com.durgasoft.commerce.homepage;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.durgasoft.commerce.basepage.BasePage;

public class screens extends BasePage{
  @Test
  public void f() throws Exception {
	  File scren = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile( scren, new File("F:\\Recorder\\.png"));
	  System.out.println(scren);
  }
  @BeforeTest
  public void beforetest() {
	  BrowserLaunch("Chrome","http://seleniumbymahesh.com");
  }
  
}
