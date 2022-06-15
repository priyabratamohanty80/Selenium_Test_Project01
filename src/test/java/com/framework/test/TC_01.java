package com.framework.test;

import java.io.IOException;
import java.util.ArrayList;

import org.omg.SendingContext.RunTime;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.page.Home_Page;
import com.framework.page.Checkout_Page;
import com.framework.page.Login_Page;
import com.framework.utils.HelperClass;

public class TC_01 extends HelperClass{
	
	Home_Page home ;
	Login_Page login ;
	Checkout_Page checkout ;


	@Test (priority = 1)
	public void login_To_Applications() throws IOException, InterruptedException
	{
		login =  PageFactory.initElements(driver, Login_Page.class);
		login.login_To_Application(Framework_Constants.USER_NAME, Framework_Constants.PASSWORD);
		
		home =  PageFactory.initElements(driver, Home_Page.class);
		home.add_Items_to_cart();
	}
	
	@Test(priority = 2)
	public void purchase_Order() throws IOException, InterruptedException
	{
		home =  PageFactory.initElements(driver, Home_Page.class);
		home.navigate_to_checkout();
		
		checkout =  PageFactory.initElements(driver, Checkout_Page.class);
		checkout.navigate_To_Checkout();
		checkout.fill_User_details(Framework_Constants.FIRST_NAME,Framework_Constants.LAST_NAME,Framework_Constants.POSTAL_CODE);
		
		Assert.assertEquals(checkout.calculate_Total(), Framework_Constants.TOTAL_VALUE);
		
		checkout.remove_Item();
		home.navigate_to_checkout();
		checkout.navigate_To_Checkout();
		checkout.fill_User_details(Framework_Constants.FIRST_NAME,Framework_Constants.LAST_NAME,Framework_Constants.POSTAL_CODE);
		Assert.assertEquals(checkout.calculate_Total(), Framework_Constants.TOTAL_VALUE_POST_REMOVE);
		
		checkout.finish_Purchase();
		Assert.assertEquals(checkout.verify_Purchase_Status(), Framework_Constants.PURCHASE_COMPLETE_MESSAGE);

	}
}
