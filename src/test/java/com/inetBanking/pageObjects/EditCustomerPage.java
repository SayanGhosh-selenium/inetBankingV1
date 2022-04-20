package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver ldriver;

	public EditCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@href='EditCustomer.php']")
	@CacheLookup
	WebElement editCust;
	
	@FindBy(xpath="//input[@name='cusid']")
	@CacheLookup
	WebElement custID;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	@CacheLookup
	WebElement submitbttn;
	
	@FindBy(xpath="//input[@name='name']")
	@CacheLookup
	WebElement name;

	@FindBy(xpath="//input[@name='gender']")
	@CacheLookup
	WebElement gender;

	@FindBy(xpath="//input[@name='dob']")
	@CacheLookup
	WebElement DOB;

	@FindBy(xpath="//textarea[@name='addr']")
	@CacheLookup
	WebElement address;

	@FindBy(xpath="//input[@name='city']")
	@CacheLookup
	WebElement city;

	@FindBy(xpath="//input[@name='state']")
	@CacheLookup
	WebElement state;

	@FindBy(xpath="//input[@name='pinno']")
	@CacheLookup
	WebElement PIN;

	@FindBy(xpath="//input[@name='telephoneno']")
	@CacheLookup
	WebElement phnnum;

	@FindBy(xpath="//input[@name='emailid']")
	@CacheLookup
	WebElement email;

	@FindBy(xpath="//input[@name='sub']")
	@CacheLookup
	WebElement submitbtn;
	
	public void clickEditCustomer() {
		editCust.click();
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
		custID.sendKeys(id);
		submitbttn.click();
	}
	

	public void custName(String cname) {
		name.clear();
		name.sendKeys(cname);
	}

	public void custgender(String cgender) {
		gender.clear();
		gender.sendKeys(cgender);
	}

	public void custdob(String date) {
		DOB.clear();
		DOB.sendKeys(date);
	}

	public void custaddress(String caddress) {
		address.clear();
		address.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		city.clear();
		city.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		state.clear();
		state.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		PIN.clear();
		PIN.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		phnnum.clear();
		phnnum.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		email.clear();
		email.sendKeys(cemailid);
	}

	public void custsubmit() {
		submitbtn.click();
	}
	

}
