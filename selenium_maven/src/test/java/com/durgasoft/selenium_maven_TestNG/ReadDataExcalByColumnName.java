package com.durgasoft.selenium_maven_TestNG;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataExcalByColumnName {
	public FileInputStream fi;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;
  @Test
  public void ReadColumnNAme() throws Exception{
	  fi = new FileInputStream("E:\\java\\practise-wspace\\SeleniumTestDemo\\testdataExcal\\Book1.xlsx");
	  w= new XSSFWorkbook(fi);
	  s = w.getSheet("Sheet1");
	  r=s.getRow(0);
	  c= null;
	  int column= -1;
	   for(int i=0;i<r.getLastCellNum();i++) {
		   System.out.println("Available column: " +r.getCell(i).getStringCellValue());
		   if(r.getCell(i).getStringCellValue().equalsIgnoreCase("Result")) {
			   column =i;	
			   System.out.println(column);
		   }		   		   
	   }
		r= s.getRow(4);
		c=r.getCell(column);
		System.out.println(c.getStringCellValue());
  }
}
