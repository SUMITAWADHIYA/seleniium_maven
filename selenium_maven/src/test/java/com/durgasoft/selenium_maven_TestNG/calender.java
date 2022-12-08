package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.BeforeTest;

public class calender {
  @Test
  public void f() {
	  Calendar cal = Calendar.getInstance();
	  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY/HH/mm/ss");
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

}
