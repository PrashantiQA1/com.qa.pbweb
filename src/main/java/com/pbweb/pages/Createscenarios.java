package com.pbweb.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import com.pbweb.driver.DriverScript;

public class Createscenarios extends DriverScript {
	
	
	// ********************************************* Page Elements *********************************************//
		
		
		@FindBy(linkText = "Create New Scenario") WebElement CreateScenario;
		@FindBy(id = "createnewscenario") WebElement CreateScenarioButton;
		
		// ********************************************* Page Initialization *********************************************//
	
		public void createscenarios() 
	{
		CreateScenario.click();
	
	}
		public boolean clickCreateScenarioButton()
		{
			CreateScenario.click();
			return false;
		}
      public String ScenarioPagetitle() 
      {
    	  
        System.out.println(driver.getTitle());
		return null;  
      }
      
}
