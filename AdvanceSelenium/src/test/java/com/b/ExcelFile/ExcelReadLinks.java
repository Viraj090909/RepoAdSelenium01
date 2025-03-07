package com.b.ExcelFile;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

// RESOURCE : src/test/resources/ExcelDataLinks.xlsx

public class ExcelReadLinks {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
//		Establish connection 
		String path = "src/test/resources/ExcelDataLinks.xlsx";
		FileInputStream fis = new FileInputStream(path);
		
//		excel file
		Workbook book = WorkbookFactory.create(fis);		
		Sheet s0 = book.getSheetAt(0);
		
//		get cell data
		for (int i=0; i<s0.getLastRowNum(); i++)
		{
			System.out.println(s0.getRow(i).getCell(1).getStringCellValue());
		
		}
		
		book.close();
	}

}
