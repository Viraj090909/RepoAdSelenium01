package com.b.ExcelFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWrite {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

//		Establish connection 
		String path = "./src/test/resources/ExcelData_xml.xlsx";
		FileInputStream fis = new FileInputStream(path);
	
//		Read excel file
		Workbook book = WorkbookFactory.create(fis);
	
		
//		create sheet row and cell		
		Row r2 = book.getSheetAt(0).createRow(2);
		Cell c12 = r2.createCell(1);
		c12.setCellValue("Kene");  

//		write (save data) in the excel file
		FileOutputStream fos = new FileOutputStream(path);
	    book.write(fos);
	    fos.close();
	    
	    
		
	}

}
