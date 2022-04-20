package com.inetBanking.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver ldriver;

	public NewCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[@href='addcustomerpage.php']")
	@CacheLookup
	WebElement lnkNewCustomer;

	@FindBy(xpath="//input[@name='name']")
	@CacheLookup
	WebElement name;

	@FindBy(xpath="//input[@name='rad1' and @value='m']")
	@CacheLookup
	WebElement genderM;

	@FindBy(xpath="//input[@name='rad1' and @value='f']")
	@CacheLookup
	WebElement genderF;

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

	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement password;

	@FindBy(xpath="//input[@name='sub']")
	@CacheLookup
	WebElement submitbtn;

	@FindBy(xpath="//input[@name='res']")
	@CacheLookup
	WebElement resetbtn;
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr/td[2]")
	@CacheLookup
	public List<WebElement> customerData1;
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[14]/td/a")
	@CacheLookup
	WebElement continuebtn;


	public void clickAddNewCustomer() {
		lnkNewCustomer.click();
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

	public void custName(String cname) {
		name.sendKeys(cname);
	}

	public void custgender(String cgender) {
		if(cgender.equalsIgnoreCase("Male"))
			genderM.click();
		else
			genderF.click();
	}

	public void custdob(String date) {
		DOB.sendKeys(date);
	}

	public void custaddress(String caddress) {
		address.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		city.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		state.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		PIN.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		phnnum.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		email.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		password.sendKeys(cpassword);
	}

	public void custsubmit() {
		submitbtn.click();
	}
	
	public void custcontinue() {
		continuebtn.click();
	}
	
}
