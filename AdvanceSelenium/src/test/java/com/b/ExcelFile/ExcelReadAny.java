package com.b.ExcelFile;




import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

//to retrieve any type of data(int,double,etc) in the form of string 

//row 3 cell 1 has numeric data : 9420101960



public class ExcelReadAny {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	

//		Establish connection 
		String path = "./src/test/resources/ExcelData_xml.xlsx";
		FileInputStream fis = new FileInputStream(path);
	
//		Read excel file
		Workbook book = WorkbookFactory.create(fis);

//		get cell
		Cell c13 = book.getSheetAt(0).getRow(3).getCell(1);

//      format cell value to string 
        DataFormatter formatter = new DataFormatter();
        String mobileNo = formatter.formatCellValue(c13);
		
		System.out.println(mobileNo);
	

	
	}	
	
}
