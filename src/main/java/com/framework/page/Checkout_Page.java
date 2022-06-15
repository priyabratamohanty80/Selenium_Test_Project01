package com.framework.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout_Page {
	
static WebDriver driver;

	
	public Checkout_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	WebDriverWait wait;

	@FindBy (id="checkout")
	WebElement checkout_button;
	
	@FindBy (id="first-name")
	WebElement first_name;
	
	@FindBy (id="last-name")
	WebElement last_name;
	
	@FindBy (id="postal-code")
	WebElement postal_code;
	
	@FindBy (id="continue")
	WebElement continue_button;
	
	@FindBy (xpath="//div[@class='summary_total_label']")
	WebElement total_value;
	
	@FindBy (xpath="//div[@class='cart_item_label']//descendant::div[@class='inventory_item_name']")
	List <WebElement> review_Items;
	
	@FindBy (xpath="//button[contains(@id,'remove-sauce-labs')]")
	WebElement remove_item;
	
	@FindBy (id="back-to-products")
	WebElement back_to_products;
	
	@FindBy (id="finish")
	WebElement finish_button;
	
	@FindBy (xpath="//*[@class='complete-header']")
	WebElement complete_purchase;
	
	public void navigate_To_Checkout()
	{
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(checkout_button));
		
		checkout_button.click();
	}
	
	public void fill_User_details(String user, String password, String postal) throws InterruptedException
	{	
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(first_name));
		first_name.sendKeys(user);
		last_name.sendKeys(password);
		postal_code.sendKeys(postal);
		
		continue_button.click();
	}
	
	public String calculate_Total() throws InterruptedException
	{	
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(total_value));
		
		String total = total_value.getText();
		String val[] = total.split(" ");
		return val[1];
	}
	
	public void remove_Item() throws InterruptedException
	{	
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(total_value));
		
		List <WebElement> lst = review_Items;
		for(int i=0; i< lst.size();i++)
		{
			if(i<1) {
			lst.get(i).click();
			break;
			}
		}
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(remove_item));
		remove_item.click();
		back_to_products.click();
	}
	
	public void finish_Purchase() throws InterruptedException
	{	
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(finish_button));
		
		finish_button.click();
	}
	
	public String verify_Purchase_Status() throws InterruptedException
	{	
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(complete_purchase));
		
		return complete_purchase.getText();
	}
}
