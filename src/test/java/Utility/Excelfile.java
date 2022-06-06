package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelfile {
	//public void BrowserStackReadExcelTest()throws IOException{
	public static void main(String args[]) throws IOException {
		
		//Path of the excel file
		FileInputStream fs = new FileInputStream("C:\\Users\\mindsdet185\\eclipse-workspace2\\nobroker.in\\Excelfile\\testdata.xls");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row1 = sheet.getRow(0);
		Cell cell1 = row1.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		Row row2 = sheet.getRow(1);
		
		}
	
	}

