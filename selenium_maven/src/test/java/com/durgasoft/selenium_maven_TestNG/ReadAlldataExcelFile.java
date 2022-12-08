package com.durgasoft.selenium_maven_TestNG;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadAlldataExcelFile {
	public FileInputStream fi;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;
	
  @Test
  public void ReadAllData() throws Exception {
	  fi = new FileInputStream("E:\\java\\practise-wspace\\SeleniumTestDemo\\testdataExcal\\Book1.xlsx");
	  w = new XSSFWorkbook(fi);
	  s = w.getSheet("Sheet1");
	  int rowcount = s.getLastRowNum()-s.getFirstRowNum();
	  System.out.println("Avilable no. of row:"+ rowcount);
	  for(int i=0;i<rowcount;i++) {
		  r=s.getRow(i);
		  for(int j=0;j<r.getLastCellNum();j++) {
			  System.out.println(r.getCell(j).getStringCellValue());
		  }
		  System.out.println();
	  }
  }
}
