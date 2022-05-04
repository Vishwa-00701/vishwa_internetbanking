package com.inetbankingpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageobj {
	
	WebDriver ldriver;
	
	public LoginPageobj(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	@FindBy(name = "txtUsername")
	@CacheLookup
	WebElement txtusername;
	@FindBy(name="txtPassword")
	@CacheLookup
	WebElement txtPassword;
	@FindBy(id="btnLogin")
	@CacheLookup
	WebElement butttonlogin;
	
	public void setusername(String usrname) {
		txtusername.sendKeys(usrname);
	}
	
	public void setpassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clicklogin() {
		butttonlogin.click();
	}
	

}
