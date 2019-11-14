package com.eCommerceapp.testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eCommerceapp.pageobject.Loginpage;
import com.eCommerceapp.pageobject.Orderitem;
import com.eCommerceapp.utilities.XLutils;

public class Tc_LoginOrderitem extends BaseClass
{
	@Test(priority=1)
	public void loginTest() throws IOException, InterruptedException
	{
		//driver.get(baseURL);
		logger.info("Url launched");
		Loginpage lp= new Loginpage(driver);
		
		System.out.println("Cliked on signin");
		lp.Sendusername(username);
		lp.Sendpassword(password);
		lp.click();
    }
	
	@Test(priority=2, dataProvider="Products")
	public void Searchitem(String Product) throws InterruptedException
	{
		Orderitem oi= new Orderitem(driver);
		Thread.sleep(15000);
		oi.searchitem(Product);
		logger.info("Item to be searched entered");
		oi.clicksearch();
		logger.info("Searched Item Displayed");
		oi.Clearsearchitem();
		logger.info("Product cleared from search tab");
		
		
	}
	
	@DataProvider(name="Products")
	String[][] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/src/test/java/com/eCommerceapp/testData/DatasheetOrderitems.xlsx";
		
		int rownum=XLutils.getRowCount(path, "Sheet1");
		int colcount=XLutils.getCellCount(path,"Sheet1",1);
		
		String Productdata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				Productdata[i-1][j]=XLutils.getCellData(path,"Sheet1", i,j);//array it should be stored
			}
				
		}
	return Productdata;
	}
		
	
}