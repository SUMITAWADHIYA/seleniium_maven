package com.durgasoft.selenium_maven_TestNG;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataExcelFile {
	public FileInputStream f;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow  r;
	public XSSFCell c;       	
  @Test
  public void f() throws Exception {
	  f=new FileInputStream("E:\\java\\practise-wspace\\SeleniumTestDemo\\testdataExcal\\Book1.xlsx");
	  w= new XSSFWorkbook(f);
	  s=w.getSheet("Sheet1");
	  r=s.getRow(2);
	  c=r.getCell(1);
	  System.out.println(c.getStringCellValue());
  } 
}
