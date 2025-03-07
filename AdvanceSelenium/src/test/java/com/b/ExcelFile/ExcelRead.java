package com.b.ExcelFile;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {
	
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		String path = "src/test/resources/ExcelData_xml.xlsx";
		FileInputStream fis = new FileInputStream(path);
		
		Workbook book = WorkbookFactory.create(fis);
		
//		Sheet s0 = book.getSheetAt(0);
//		Row r1 = s0.getRow(1);
//		Cell c1 = r1.getCell(1);
//		String NAME = c1.getStringCellValue();
//		System.out.println(NAME);
		
	   
		String name1 = book.getSheetAt(0)
	    		          .getRow(1)
	    		          .getCell(1)
	    		          .getStringCellValue();
	  
		System.out.println(name1);
		
		String name2 = book.getSheetAt(0).getRow(2).getCell(1).getStringCellValue();

        System.out.println(name2);
		
		
	    
	    		          
	}

}
