package com.inetbankingtestcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbankingpageobjects.LoginPageobj;

public class TC_LoginTest_001 extends Baseclass{
	
	@Test
	public void Logintest() throws IOException {
		
		
		logger.info("UrL is opened");
		LoginPageobj lp=new LoginPageobj(driver);
		
		lp.setusername(username);
		logger.info("User name entered");
		lp.setpassword(password);
		logger.info("Password entered");
		lp.clicklogin();
		
		
		
		
	    if (driver.getTitle().equalsIgnoreCase("OrangeHRM")) 
	    {
		  
		 Assert.assertTrue(true); 
		 logger.info("Test Passed");
		 } else {
		 capturescreen(driver,"Logintest");
		 Assert.assertTrue(false);
		 logger.info("Test Failed");
		  }
		 
	}

}
