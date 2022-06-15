package com.framework.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page {
	
static WebDriver driver;

	
	public Home_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	WebDriverWait wait;

	@FindBy (xpath="//div[@class='header_secondary_container']")
	WebElement swagLabs_home;
	
	@FindBy (xpath="//button[@class='btn btn_primary btn_small btn_inventory']")
	List <WebElement> addToCart;
	
	@FindBy (id="shopping_cart_container")
	WebElement shoppingCartIcon;
	
		
	
	public void add_Items_to_cart()
	{
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(swagLabs_home));
		
		List <WebElement> lst = addToCart;
		for(int i=0; i< lst.size();i++)
		{
			if(i<2) {
			lst.get(i).click();
			}
		}	
	}
	
	public void navigate_to_checkout()
	{
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(shoppingCartIcon));
		shoppingCartIcon.click();	
	}
}
