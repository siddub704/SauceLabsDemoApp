package com.qa.commonmethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReusableMethods {

	public static Properties getProertyFile() throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\testdata\\logindata.txt");
		prop.load(file);
		return prop;

	}

	public static String getUrl() throws IOException {
		return getProertyFile().getProperty("url");
	}
	
	public static String getUserName() throws IOException {
		return getProertyFile().getProperty("username");
		
	}
	
	public static String getPassword() throws IOException {
		return getProertyFile().getProperty("password");
		
	}
}

