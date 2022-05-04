package com.inetbanking.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig(){
		
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream file=new FileInputStream(src);
			pro=new Properties();
			pro.load(file);
			
		}catch (Exception e) {
			System.out.println("The Exception is"+e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url=pro.getProperty("baseurl");
		return url;
	}
	
	public String getUsername() {
		String username=pro.getProperty("username");
		return username;
		
	}
	
	public String getpassword() {
		String password=pro.getProperty("password");
		return password;
		
	}
	
	public String getChromebrowser() {
		String chrome_browser=pro.getProperty("chromedriver");
		return chrome_browser;
	}

	
	
	

}
