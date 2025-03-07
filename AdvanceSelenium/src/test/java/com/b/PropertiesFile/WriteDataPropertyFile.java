package com.b.PropertiesFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

// refer fos : PropertyFileWrite.properties

public class WriteDataPropertyFile {
	
	public static void main(String[] args) throws IOException {
		
		Properties p = new Properties();
		p.setProperty("un", "viraj");
		FileOutputStream fos = new FileOutputStream("src/test/resources/PropertyFileWrite.properties");
		p.store(fos, "No comment");
		fos.close();
		System.out.println("done");
		
	}

}

