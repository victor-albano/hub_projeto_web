package br.com.RsiHub3.ProjetoTDD.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	
	public void readExcel (String filePath, String sheetName) throws IOException {
		File file = new File(filePath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		int linhaCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
		
		for (int i = 0 ; i <= linhaCount; i++) {
			XSSFRow linha = newSheet.getRow(i);
			
			for (int j = 0; j < linha.getLastCellNum(); j++) {
				System.out.println(linha.getCell(j).getStringCellValue() + "||");
			}
		}
	}
	
	public String getCellValue (String filePath, String sheetName, int linhaNumber, int cellNumber) throws IOException {
		
		File file = new File(filePath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		XSSFRow linha = newSheet.getRow(linhaNumber);
		
		XSSFCell cell = linha.getCell(cellNumber);
		
		return cell.getStringCellValue();
	}
}
