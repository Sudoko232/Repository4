package com.eCommerceapp.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Orderitem 
{
	WebDriver driver;
	
	public Orderitem(WebDriver idriver)
	{
	
	driver=idriver;
	PageFactory.initElements(idriver, this);
	
    }
	
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")   
	WebElement Searchtext;
	
	
	@FindBy(xpath="//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/button")
	WebElement Searchitem;
	
	 
	public void searchitem(String Product)
	{
		Searchtext.sendKeys(Product);
	}
	
	public void clicksearch() throws InterruptedException
	{
		Thread.sleep(15000);
		Searchitem.click();
	}
	
	public void Clearsearchitem() throws InterruptedException
	{
		Thread.sleep(5000);
		Searchtext.clear();
		
	}
	
}
