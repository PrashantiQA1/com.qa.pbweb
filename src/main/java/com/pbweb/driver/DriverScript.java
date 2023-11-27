package com.pbweb.driver;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Name: DriverManager
 * Description: This class manages the driver instance and also loads the properties file
 * Developed By: Prashanti Mantrala
 * Approved By : 
 * Data Created/Modified: 11/20/2023
 */


public class DriverScript {
	
	public static WebDriver driver;
	static Properties prop;
	
	public DriverScript()
	{
		try
		{
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("unable to load the properties file! please check :"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void initApplication()
	{
		String browser = prop.getProperty("browser");
		
		if(browser.trim().equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.trim().equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.trim().equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("unsupported browser value please check config file for more information");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		getAppURL();
		
	}
	
	public static void getAppURL()
	{
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	public static void quitDriver()
	{
		driver.quit();
	}

}