package com.durgasoft.commerce.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.durgasoft.commerce.basepage.BasePage;

public class Listener extends BasePage implements ITestListener {
	public void onTestStart(ITestResult arg0) {
		Reporter.log("the test Start Runnig:"+arg0.getMethod().getMethodName());	
	}
	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("the test Skipped Runnig:"+arg0.getMethod().getMethodName());
	}
	public void onTestSuccess(ITestResult arg0) {
		Reporter.log("the test Success Runnig:"+arg0.getMethod().getMethodName());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String method = arg0.getName();
		if(arg0.isSuccess()) {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String direction = (new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/durgasoft/commerce");
			File path = new File((String)direction +"/passedScreens/"+method+" "+sdf.format(cal.getTime())+".png");
			try {
				FileUtils.copyFile(file, path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	public void onTestFailure(ITestResult arg0) {
		Reporter.log("the test Failure Runnig:"+arg0.getMethod().getMethodName());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String method = arg0.getName();
		if(!arg0.isSuccess()) {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String direction = (new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/durgasoft/commerce");
			File path = new File((String)direction +"/failedScreens/"+method+" "+sdf.format(cal.getTime())+".png");
			try {
				FileUtils.copyFile(file, path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}

}
