package com.inetbankingtestcases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilites.ReadConfig;


public class Baseclass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseurl=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		
		
		
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		if(br.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromebrowser());
		driver=new ChromeDriver();
		}
		
		driver.get(baseurl);
	}
	@AfterClass
	public void taerDown() {
		driver.quit();
	}
	
	public void capturescreen(WebDriver driver,String tname ) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileHandler.copy(source,target);
	}

}
