package com.inetbanking.utilites;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest testlogger;
	
	public void onStart(ITestContext tr) {
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportname="Test-Report-"+timestamp+".html";
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reportname);
		htmlreporter.loadXMLConfig("C:\\Users\\vishwanath\\eclipse-workspace\\Inetbankingdemoproj\\extent-config.xml");
	    
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Vishwa");
		
		htmlreporter.config().setDocumentTitle("Internet Banking");
		htmlreporter.config().setReportName("Functional Test Report");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreporter.config().setTheme(Theme.STANDARD);
		
		
	  }
	
	public void onTestSuccess(ITestResult tr) {
		
		testlogger=extent.createTest(tr.getName());//creat new entry in the report
		testlogger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));//send the passed information
	}

	
	public void onTestFailure(ITestResult tr) {
	    
		testlogger=extent.createTest(tr.getName());//creat new entry in the report
		testlogger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String Screenshotpath=System.getProperty("user.dir")+"\\Screenshot\\"+tr.getName()+".png";
		File file=new File(Screenshotpath);
		if(file.exists()) {
			try {
				
				testlogger.fail("Screen shot is below:" + testlogger.addScreenCaptureFromPath(Screenshotpath));
	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	  }

	  
	 public void onTestSkipped(ITestResult tr) {
		 testlogger=extent.createTest(tr.getName());//creat new entry in the report
		 testlogger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	  }
	 
	 public void onFinish(ITestContext testcontext) {
		 extent.flush();
	 }
	

}
