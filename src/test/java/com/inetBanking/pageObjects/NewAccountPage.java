package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
	
	WebDriver ldriver;

	public NewAccountPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@href='addAccount.php']")
	@CacheLookup
	WebElement newAccount;
	
	@FindBy(xpath="//input[@name='cusid']")
	@CacheLookup
	WebElement cusID;
	
	@FindBy(xpath="//select[@name='selaccount']")
	@CacheLookup
	WebElement selectAccount;
	
	@FindBy(xpath="//input[@name='inideposit']")
	@CacheLookup
	WebElement depositAmount;
	
	@FindBy(xpath="//input[@name='button2']")
	@CacheLookup
	WebElement submitbttn;
	
	public void clickNewAccount() {
		newAccount.click();
	}
	
	public void skipAD() {
		try {
			ldriver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
			ldriver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
			
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
			
		}
		catch(NoSuchFrameException e)
		{
			e.getMessage();
		}
		finally
		{
			ldriver.switchTo().defaultContent();
		}
		try {
			ldriver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
			
			ldriver.switchTo().frame("ad_iframe");
			ldriver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
		}
		catch(NoSuchFrameException e)
		{
			e.getMessage();
		}
		finally
		{
			ldriver.switchTo().defaultContent();
		}
		
	}
	
	public void custID(String id) {
		cusID.sendKeys(id);
	}
	
	public void selectAccount(String accountType)
	{
		Select acc = new Select(selectAccount);
		acc.selectByVisibleText(accountType);
	}
	
	public void depositAmount(String amount)
	{
		depositAmount.sendKeys(amount);
	}
	
	public void submit()
	{
		submitbttn.click();
	}

}
