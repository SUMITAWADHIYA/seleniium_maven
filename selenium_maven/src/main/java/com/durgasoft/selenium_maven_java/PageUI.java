package com.durgasoft.selenium_maven_java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageUI {
	@FindBy(name="username")WebElement txtUsername;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(xpath ="//button[@type='submit']")WebElement btnLogin;
	
	public PageUI(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void Orang(){
		txtUsername.sendKeys("Admin");
		txtPassword.sendKeys("admin123");
		btnLogin.click();
		
	}
}
