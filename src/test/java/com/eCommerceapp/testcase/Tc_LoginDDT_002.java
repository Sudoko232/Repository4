package com.eCommerceapp.testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eCommerceapp.pageobject.Loginpage;
import com.eCommerceapp.utilities.XLutils;

public class Tc_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pass) throws InterruptedException
	{
		Loginpage lp= new Loginpage(driver);
		lp.Sendusername(user);
		lp.Sendpassword(pass);
		lp.click();
		lp.Signout1();
		lp.Signout2();
		
		
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/src/test/java/com/eCommerceapp/testData/Datasheet.xlsx";
		
		int rownum=XLutils.getRowCount(path, "Sheet1");
		int colcount=XLutils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLutils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
		
	
	
}
