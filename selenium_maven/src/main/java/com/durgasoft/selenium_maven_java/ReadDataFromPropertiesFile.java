package com.durgasoft.selenium_maven_java;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertiesFile {
	public static final String path ="./config.properties";
	public static String getData(String Key) throws Exception {
		File f=new File(path);
		Properties p=new Properties();
		FileInputStream fi = new FileInputStream(f);
		p.load(fi);
		return p.getProperty(Key);
	}
	public static void main(String[] args) throws Exception {
		System.out.println(getData("browser"));
		System.setProperty("webdriver.chrome.driver","F:/driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get(getData("prodURL"));
//		driver.get(getData("excelpath"));
		driver.findElement(By.name(getData("usernameLoc"))).sendKeys(getData("username"));
		driver.findElement(By.name(getData("passwordLoc"))).sendKeys(getData("password"));
		driver.findElement(By.name(getData("loginLoc"))).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText(getData("logoutLoc"))).click();		
	}
}
