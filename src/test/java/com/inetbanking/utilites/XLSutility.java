package com.inetbanking.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSutility {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getrowcount(String xlfile, String xlsheet) throws IOException {
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
		
	}
	
	public static  int getcellcount(String xlfile, String xlsheet, int rownos) throws IOException {
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownos);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}
	
	public static String getcelldata(String xlfile, String xlsheet, int rownos, int cellno) throws IOException {
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownos);
		cell=row.getCell(cellno);
		String celldata;
		try {
			DataFormatter formatter=new DataFormatter();
			String cellvalue=formatter.formatCellValue(cell);
			return cellvalue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			celldata="";
		}
		workbook.close();
		fi.close();
		return celldata;
	}
	
	public static void setcelldata(String xlfile, String xlsheet, int rownos, int cellno, String data) throws IOException {
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownos);
		cell=row.getCell(cellno);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	

}
