package com.pbweb.testcase;


import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pbweb.driver.DriverScript;
import com.pbweb.pages.HomePage;
import com.pbweb.pages.LoginPage;
import com.pbweb.pages.Createscenarios;
import com.pbweb.utils.ExcelUtil;
import com.pbweb.utils.HelperUtil;

public class BaseTest extends DriverScript {
	
	static ExtentHtmlReporter extent;
	static ExtentReports report;
	static ExtentTest logger;
	HomePage hp;
	LoginPage lp;
	Createscenarios cs;
	
	@BeforeSuite
	public void setUpReport()
	{
		extent = new ExtentHtmlReporter("./reports/wsreport.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		hp = new HomePage();
		lp = new LoginPage();
		cs = new Createscenarios();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				logger.fail("test-failed", 
						MediaEntityBuilder.createScreenCaptureFromPath(HelperUtil.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		report.flush();
		HelperUtil.sleep();
		quitDriver();
	}
	
	@DataProvider(name="pbweblogindata")
	public Object[][] testData()
	{
		ExcelUtil excel = new ExcelUtil("./src/test/resources/testdata/pbweblogindata.xlsx");
		int rows = excel.getRowCount(0);
		
		Object[][] data = new Object[rows][2];
		
		for(int i=0; i<rows; i++)
		{
			data[i][0]=excel.getCellData(0, i, 0);
			data[i][1]=excel.getCellData(0, i, 1);
		}
		return data;
		
	}

}
