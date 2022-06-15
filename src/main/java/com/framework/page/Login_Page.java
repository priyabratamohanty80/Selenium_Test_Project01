package com.framework.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {
	
	static WebDriver driver;

	
	public Login_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	WebDriverWait wait;

	@FindBy (id="user-name")
	WebElement userName_input;
	
	@FindBy (id="password")
	WebElement password_input;
	
	@FindBy (id="login-button")
	WebElement login_button;
	
	public void login_To_Application(String user, String password)
	{
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(userName_input));
		
		userName_input.sendKeys(user);
		password_input.sendKeys(password);
		login_button.click();	
	}
}
