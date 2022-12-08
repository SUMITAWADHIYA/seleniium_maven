package com.durgasoft.selenium_maven_TestNG;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelDataByIndex {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;
	@Test
	public void WriteIndex()throws Exception {
		fi = new FileInputStream("E:\\java\\practise-wspace\\SeleniumTestDemo\\testdataExcal\\Book1.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		r = null;
		c = null;
		r = s.getRow(4);
		if(r == null)
			r=s.createRow(2);
		c =r.getCell(2);
		if(c == null)
			c =r.createCell(2);
		c.setCellValue("passdW");
		fo = new FileOutputStream("E:\\java\\practise-wspace\\SeleniumTestDemo\\testdataExcal\\Book1.xlsx");
		w.write(fo);
		fo.close();  
	}
}
