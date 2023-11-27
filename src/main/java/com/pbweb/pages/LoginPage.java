package com.pbweb.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pbweb.driver.DriverScript;

public class LoginPage extends DriverScript {
	
// ********************************************* Page Elements *********************************************//
	
	@FindBy(id = "email") WebElement emailTextbox;
	@FindBy(id = "password") WebElement passwordTextbox;
	@FindBy(id = "forgotPassword") WebElement forgotPasswordLink;
	@FindBy(id = "next") WebElement SigninButton;
	
// ****************************************** Page Initilization *******************************************//
	
	public LoginPage()
	 {
		PageFactory.initElements(driver, this);
	 }
		
// ****************************************** Page Methods/Actions *******************************************//
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickSigninButton()
	{
		SigninButton.click();
	}
	
	public void enterEmail(String email)
	{
		emailTextbox.clear();
		emailTextbox.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		passwordTextbox.sendKeys(password);
	}
	
	public boolean forgotPasswordLink()
	{
		return forgotPasswordLink.isDisplayed();
	}
		
	

}