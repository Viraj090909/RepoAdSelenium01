package com.b.pdf;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPdf {

	public static void main(String[] args) throws IOException {
		
	     String path = "src/test/resources/PdfData.pdf";
	     
	     FileInputStream fis = new FileInputStream(path);
	     PDDocument doc = PDDocument.load(fis);
	     
//	     to get no of pages:
	     int pageCount = doc.getNumberOfPages();
         System.out.println(pageCount);
         
//       to read pdf :
         PDFTextStripper pts = new PDFTextStripper();
         
//       to get all the text from pdf: pts.getText(doc);
         System.out.println(pts.getText(doc));
         
//       to get text from particular pages
         pts.setStartPage(1);
         pts.setStartPage(2);
         System.out.println(pts.getText(doc));
         
         
         
         
         
	}

}
