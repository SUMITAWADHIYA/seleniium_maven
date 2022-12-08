package com.durgasoft.commerce.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer {
	private int retryCount = 0;
	private int maxRetryCount = 3;

	public boolean retry(ITestResult arg0) {
		if(retryCount<maxRetryCount) {
			log("Retry Testing"+arg0.getName()+"with status"+getResultStatusName(arg0.getStatus())+"for the"+(retryCount+1)+"times");
			retryCount++;
			return true;
		}

		return false;
	}
	public void log(String string) {
		Reporter.log(string);
	}
	public String getResultStatusName(int status) {
		String resultName = null;
		if(status == 1)
			resultName = "SuccessFull";
		if(status == 2)
			resultName = "Failed";
		if(status == 3)
			resultName = "Skipper";
		return resultName;

	}
}
