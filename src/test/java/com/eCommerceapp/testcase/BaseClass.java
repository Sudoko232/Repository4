package com.eCommerceapp.testcase;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.eCommerceapp.utilities.Readconfig;

public class BaseClass {
	
	Readconfig readconfig = new Readconfig();
	
	/*
	public String baseURL="https://www.flipkart.com/";
	public String username="Testing.usage.rock@gmail.com";
	public String password="Test@888";
	*/
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getusername();
	public String password=readconfig.getpassword();
	
	WebDriver driver;
	public static Logger logger;
	
	//commended for executing another tc
	@Parameters("browser") 
	@BeforeClass
	public void setup(String br)
	{
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\bin\\drivers\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
				
		logger= Logger.getLogger("eCommerceapp");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
		driver= new ChromeDriver();
		driver.manage().window().maximize();
  }
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconfig.getiepath());
			driver= new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		driver.get(baseURL);
	}
	
	@AfterClass
	public void teardown()
	{
		//driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
				
	}

}
