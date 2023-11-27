package com.pbweb.testcase;



import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {
	
	@Test
	public void testHomePageTitle()
	{
		logger = report.createTest("Test HomePage Title Validation");
		String actual = hp.getHomePageTitle();
		logger.pass("get the homepage title");
		System.out.println(actual);
		Assert.assertEquals("Dashboard", actual);	
		logger.pass("validated homepage title");
	}
	
	@Test
	public void testPbWebImgIsDisplayed()
	{
		logger = report.createTest("Test PbWeb Logo isDisplayed");
		boolean flag = hp.pbwebImg();
		logger.pass("locate the pbweb logo");
		System.out.println(flag);
		Assert.assertTrue(flag);
		logger.pass("logo is present and is displayed");
	}

}