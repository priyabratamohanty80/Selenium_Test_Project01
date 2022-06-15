package com.framework.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.framework.BrowserFactory.BrowserFactory;
import com.framework.test.Framework_Constants;

public class HelperClass {
	
	public static WebDriver driver;

	@BeforeSuite
	public void beforeSuite()
	{

		driver = BrowserFactory.getWebDriver(Framework_Constants.BROWSER);
		driver.get("https://www.saucedemo.com/");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		driver.quit();
	}

}
