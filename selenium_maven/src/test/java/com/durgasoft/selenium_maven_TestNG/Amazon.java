package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;

import com.durgasoft.selenium_maven_java.BasePage;
import com.durgasoft.selenium_maven_java.PageUI;
import org.testng.annotations.BeforeTest;

public class Amazon extends BasePage{
  @Test(description ="This test case is valid" )
  public void f() {
	  PageUI HRM = new PageUI(driver);
	  HRM.Orang();
  }
  @BeforeTest
  public void beforeTest() {
	  browserLunch("Chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

}
