import java.io.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class DataToFroExcel {
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		String FilePath = "d://filepath.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = WorkbookFactory.create(fs);
		
		//get sheet control , passing sheet name
		Sheet sh = wb.getSheet("Sheet1");
		
		//get 1st row
		Row r = sh.getRow(1);
		
		//get 2nd column from 1st row
		String user = r.getCell(2).getStringCellValue();
		
		System.out.println("Username: "+user);
	}
	
	public String getExcelData(String FilePath, String sheet , int row, int col) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = WorkbookFactory.create(fs);
		
		//get sheet control , passing sheet name
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		
		String data = r.getCell(col).getStringCellValue();
		return data;
	}
	
	public void setExcelData(String FilePath, String sheet, int row, int cell, String data) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = WorkbookFactory.create(fs);
		
		//get sheet control , passing sheet name
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		
		Cell c = r.createCell(cell);
		
		c.setCellType(c.CELL_TYPE_STRING);
		c.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(FilePath);
		wb.write(fos);
		
	}
	
	
	
	

}
