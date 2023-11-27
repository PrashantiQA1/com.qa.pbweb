package com.pbweb.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class HelperUtil {
	
	/*
	 * call this sleep method whenever needed to force wait the execution
	 */
	public static void sleep()
	{
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * this method is used to capture the screenshot
	 */
	public static String captureScreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenPath = "C:\\Users\\User\\git\\com.qa.pbweb\\reports\\screenshots\\screen.png";
		try {
			FileHandler.copy(src, new File(screenPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenPath;
	}
	
	

}
