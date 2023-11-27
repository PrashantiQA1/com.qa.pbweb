package com.pbweb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pbweb.driver.DriverScript;

public class HomePage extends DriverScript {
	
	
// ********************************************* Page Elements *********************************************//
	
	@FindBy(linkText = "Sign in") WebElement SigninLink;
	//@FindBy(linkText = "Log in") WebElement loginLink;
	@FindBy(xpath = "//img[@alt='Project Builder']") WebElement pbwebImg;
	@FindBy(id = "email") WebElement emailaddress;
	@FindBy(xpath ="(//a[@title='Logout')])") WebElement logoutLink;
	@FindBy(xpath = "(//a[@class='account'])[1]") WebElement userLoggedIn;
	
// ****************************************** Page Initialization *******************************************//
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
// ****************************************** Page Methods/Actions *******************************************//
	
	public boolean isRegisterLinkDisplayed()
	{
		return SigninLink.isDisplayed();
	}
		
	public boolean isUserLoggedDisplayed()
	{
		return userLoggedIn.isDisplayed();
	}
	
	public String getUserLoggedIn()
	{
		return userLoggedIn.getText();
	}
	
	public void clickLogout()
	{
		logoutLink.click();
	}
	
	public void clickSigninLink()
	{
		SigninLink.click();
	}
	
/*	public void clickLoginLink()
	{
		loginLink.click();
	}
	*/
	public boolean pbwebImg()
	{
		return pbwebImg.isDisplayed();
	}
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	
}