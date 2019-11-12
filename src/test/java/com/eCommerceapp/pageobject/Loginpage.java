package com.eCommerceapp.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage {

	WebDriver driver;
	public Loginpage(WebDriver idriver)
	{
		driver=idriver;
		PageFactory.initElements(idriver, this);
		
		
	}
	
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement txtusername;
	
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
	WebElement txtpassword;
	
	
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")
	WebElement loginsubmit;
	
	@FindBy(xpath="//*[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/a")
	WebElement Signuplogin;
	
	@FindBy(xpath="//*[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")
	WebElement Signout1;
	
	@FindBy(xpath="//*[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div[2]/div[2]/div/ul/li[10]/a")
	WebElement Signout2;
	
	
	public void Sendusername(String iusername) throws InterruptedException
	{
		Thread.sleep(15000);
		WebDriverWait wait = new WebDriverWait(driver,30);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")));
		txtusername.sendKeys(iusername);
	}
	
	public void Sendpassword(String ipassword)
	{
		txtpassword.sendKeys(ipassword);
	}
	
	public void click()
	{
		loginsubmit.click();
	}
	
	public void Signinlogin()
	{
		Signuplogin.click();
	}
	
	public void Signout1() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,30);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")));
		Actions actions = new Actions(driver);
		actions.moveToElement(Signout1).perform();
		System.out.println("Done Mouse hover on 'Manohar' from Menu");
	}
	
	public void Signout2()
	{
		Signout2.click();
	}
}


