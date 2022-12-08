package com.durgasoft.selenium_maven_TestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelDataBYColumnName {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;
  @Test
  public void WriteColumnName()throws Exception {
		fi = new FileInputStream("E:\\java\\practise-wspace\\SeleniumTestDemo\\testdataExcal\\Book1.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		r= null;
		c =null;
		int colNum = -1;
		r=s.getRow(0);
		for(int i=0;i<r.getLastCellNum();i++) {
			if(r.getCell(i).getStringCellValue().equalsIgnoreCase("Result")) {
				colNum =i;
			}
		}
		r=s.getRow(2);
		if(r==null)
			r =s.createRow(3);
		c.setCellValue(colNum);
		if(c==null);
		c=r.createCell(colNum);
		c.setCellValue("BLOCKED");
		fo= new FileOutputStream("E:\\java\\practise-wspace\\SeleniumTestDemo\\testdataExcal\\Book1.xlsx");
		w.write(fo);
		fo.close();
		
	}
  }

