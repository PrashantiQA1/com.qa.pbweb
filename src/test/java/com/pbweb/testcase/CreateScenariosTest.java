package com.pbweb.testcase;



import org.testng.AssertJUnit;
import org.testng.annotations.Test;


	public class CreateScenariosTest extends BaseTest {
		
		@Test
		public void testScenariosTitle()
		{
			logger = report.createTest("Test scenarios Title Validation");
			String actual=cs.ScenarioPagetitle();
			
			logger.pass("get the scenarios title");
			System.out.println(actual);
			AssertJUnit.assertEquals("Scenarios", actual);	
			logger.pass("validated scenarios title");
		}
		
		@Test
		public void testCreateScenarioButtonDisplayed()
		{
			logger = report.createTest("Test CreateScenarios button isDisplayed");
			boolean flag = cs.clickCreateScenarioButton();
			logger.pass("locate the createscenario button ");
			System.out.println(flag);
			AssertJUnit.assertTrue(flag);
			logger.pass("button is present and is displayed");
		}

	}


