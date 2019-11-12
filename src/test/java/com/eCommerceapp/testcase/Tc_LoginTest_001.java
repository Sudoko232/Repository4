package com.eCommerceapp.testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eCommerceapp.pageobject.Loginpage;

public class Tc_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		//driver.get(baseURL);
		logger.info("Url launched");
		Loginpage lp= new Loginpage(driver);
		
		System.out.println("Cliked on signin");
		lp.Sendusername(username);
		lp.Sendpassword(password);
		lp.click();
		logger.info("Logged into application");
		System.out.println(driver.getTitle());
		String title= "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		if(driver.getTitle().equals(title))
				{
			Assert.assertTrue(true);
			logger.info("Tc passed");
				}
		 else  
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Tc failed");
		}
		
				
				
		
	}
	
	
}
