package com.pbweb.testcase;


import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginPageTest extends BaseTest {
	
	@Test(dataProvider = "wsdata")
	public void testLoginFunction(String username, String password)
	{
		logger = report.createTest("Test Login Function");
		hp.clickSigninLink();
		logger.pass("clicked on login button");
		lp.enterEmail(username);
		logger.pass("entered username email");
		lp.enterPassword(password);
		logger.pass("entered password");
		lp.clickSigninButton();
		logger.pass("clicked login button");
		String actual = hp.getUserLoggedIn();
		Assert.assertTrue(actual.contains(".com"));
		logger.pass("verified the user logged in");
		boolean flag = hp.isUserLoggedDisplayed();
		Assert.assertTrue(flag);
		logger.pass("verified the user logged element");
		hp.clickLogout();
		logger.pass("clicked logout");
	}

}