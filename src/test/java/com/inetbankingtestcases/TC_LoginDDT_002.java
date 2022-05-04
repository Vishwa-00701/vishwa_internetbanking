package com.inetbankingtestcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.utilites.XLSutility;
import com.inetbankingpageobjects.LoginPageobj;

public class TC_LoginDDT_002 extends Baseclass{
	
	

@Test(dataProvider = "LoginData")	
public void loginDDT(String uname, String pwd) {
	
LoginPageobj obj= new LoginPageobj(driver);
obj.setusername(uname);
obj.setpassword(pwd);
obj.clicklogin();
	
}
@DataProvider(name="LoginData")
public String[][] getdata() throws IOException {
	
	String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetbankingtestdata\\testdata1.xlsx";
	int rownum=XLSutility.getrowcount(path,"sheet1");
	int coloumncount=XLSutility.getcellcount(path, "Sheet1", 1);
	String logindats[][]=new String[rownum+1][coloumncount];
	for(int i=0;i<rownum+1;i++) {
		for(int j=0;j<coloumncount;j++) {
			logindats[i][j]=XLSutility.getcelldata(path, "sheet1", i, j);
			
		}
	}
	return logindats;
}

}


