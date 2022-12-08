package com.durgasoft.commerce.homepage;

import org.testng.annotations.Test;
import com.durgasoft.commerce.basepage.BasePage;
import com.durgasoft.commerce.pageUI.PageUI;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class HMS extends BasePage {
	public static final Logger log = Logger.getLogger(HMS.class.getName());	
	@Test
	public void HHMMSS()throws Exception {

		log.info("****String HMSLogin****");
		PageUI el = new PageUI(driver);
		el.Login();
		log.info("****End HMSLogout****");
	}
	@Test
	public void verify() {
		System.out.println("System is pass");
	}

	@BeforeClass
	public void beforeTest() throws Exception {
		BrowserLaunch(getData("browser"),getData("url"));
	}
	@AfterClass
	public void endTest() {
		closeBrowser();

	}
	public  void closeBrowser() {
		driver.quit();
		extent.endTest(test);
		extent.flush();

	}
}
