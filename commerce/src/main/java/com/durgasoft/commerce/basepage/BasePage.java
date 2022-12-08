package com.durgasoft.commerce.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	public static  WebDriver driver;
	public String log4jpath = "log4j.properties";
	public static final String path ="./config.properties";
	public static ExtentReports extent;
	public ExtentTest test;
	public ITestResult result;
	
	static
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyy_HH_mm_ss");
		extent = new ExtentReports(System.getProperty
		("user.dir")+"/src/main/java/com/durgasoft/commerce/htmlreport/"+sdf.format(cal.getTime())+"html",false);
	}

	public  String getData(String key) throws Exception {
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fi);
		return p.getProperty(key);	
	}
	@BeforeMethod
	public void startReport(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO,result.getName()+"Test is started");
	}
	@AfterMethod
	public void endReport(ITestResult result) {
		getResult(result);
	}

	public  void getResult(ITestResult result2) {
		if(result2.getStatus()==ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result2.getName()+"Test is Passed");
		}else if(result2.getStatus()==ITestResult.SKIP) {
			test.log(LogStatus.SKIP,result2.getName()+"Test is Skipped and the Reason"+result2.getThrowable());
		}else if(result2.getStatus()==ITestResult.FAILURE) {
			test.log(LogStatus.FAIL,result2.getName()+"Test is Fail and the Reason"+result2.getThrowable());		
		}
	}
	public void BrowserLaunch(String browser, String url) {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","F:\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver","F:\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","F:\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		PropertyConfigurator.configure(log4jpath);
	}
}
