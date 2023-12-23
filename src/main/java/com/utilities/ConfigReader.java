package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
 
	Properties prop;
	
	public Properties configReader() throws IOException {
	String filepath=	System.getProperty("user.dir");
	
	File file = new File(filepath+"\\src\\test\\resources\\config\\config.properties");
	FileInputStream fis= new FileInputStream(file);
	prop = new Properties();
	prop.load(fis);
	return prop;

	}
	
//	public static void main(String[] args) throws IOException {
//		ConfigReader cf= new ConfigReader();
//		
//	Properties prop1=	cf.configReader();
//	System.out.println(prop1.get("browser"));
//	}
}
