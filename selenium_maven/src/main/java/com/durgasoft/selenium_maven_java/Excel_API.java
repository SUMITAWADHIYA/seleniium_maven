package com.durgasoft.selenium_maven_java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_API {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet sheet = null;
	public XSSFRow  row = null;
	public XSSFCell cell = null;
	public String filePath;

	public Excel_API(String file)throws Exception {
		this.filePath = file;
		fi = new FileInputStream(filePath);
		w = new XSSFWorkbook(fi);
		fi.close();
	}
	//reading cell data form Excel by using column index
	public String getCellData(String sheetName, int colNum ,int rowNum) {
		try {
			sheet = w.getSheet(sheetName);
			row =sheet.getRow(rowNum);
			if(cell.getCellTypeEnum()==CellType.STRING) {
				return cell.getStringCellValue();
			}else if(cell.getCellTypeEnum()==CellType.NUMERIC|| cell.getCellTypeEnum()==CellType.FORMULA) {
				String cellValue =String.valueOf(cell.getNumericCellValue());
				return cellValue();
			}else if(cell.getCellTypeEnum()==CellType.BLANK) {
				return " ";
			}else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "No matching value";
		}
	}
	public String cellValue() {
		return null;
	}
	//reading cell data form Excel by using column Name
	public String getCellData(String sheetName, String colName ,int rowNum) {
		try {
			int colNum = -1;
			sheet=w.getSheet(sheetName);
			row = sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++) {
				if(row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
					colNum =i;
				}
			}
			row = sheet.getRow(rowNum);
			cell =row.getCell(colNum);
			if(cell.getCellTypeEnum()==CellType.STRING) {
				return cell.getStringCellValue();
			}else if(cell.getCellTypeEnum()==CellType.NUMERIC||cell.getCellTypeEnum()==CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				return cellValue();
			}else if(cell.getCellTypeEnum()==CellType.BLANK) {
				return " ";
			}else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "No Machting Value";
		}
	}
	//Writing cell data to excel by using column index
	public boolean setCellData(String sheetName , int colNum ,int rowNum, String value)throws Exception {
		try {
			sheet = w.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			if(row==null)
				row = sheet.createRow(rowNum);
			cell= row.getCell(colNum);
			if(cell==null)
				cell = row.createCell(colNum);
			cell.setCellValue(value);
			fo= new FileOutputStream(filePath);
			w.write(fo);
			fo.close();									
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
}	
	//Writing cell data to excel by using column Name
		public boolean setCellData(String sheetName , String colName ,int rowNum ,String value )throws Exception {
			try {
				int colNum = -1;
				sheet = w.getSheet(sheetName);
				row = sheet.getRow(0);
				for (int i=0;i<row.getLastCellNum();i++) {
					if(row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
						colNum =i;						
					}
				}
				row= sheet.getRow(rowNum);
			if(row==null)
				row = sheet.createRow(rowNum);
			cell= row.getCell(colNum);
			if(cell== null)
				cell = row.createCell(colNum);
			cell.setCellValue(value);
			fo= new FileOutputStream(filePath);
			w.write(fo);
			fo.close();						
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
}
		//identify no. of rows and no. of column in excel file
		public int getRows(String sheetName) {
			sheet= w.getSheet(sheetName);
			int rowCount =sheet.getLastRowNum()+1;
			return rowCount;
		}
		public int getColumn(String sheetName) {
			sheet =w.getSheet(sheetName);
			row = sheet.getRow(0);
			int columnCount = row.getLastCellNum();
			return columnCount;
		}
		}