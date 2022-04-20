package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtUserPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement buttnLogin;
	
	@FindBy(name="btnReset")
	@CacheLookup
	WebElement buttnReset;
	
	@FindBy(xpath="//a[@href='Logout.php']")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String userName)
	{
		txtUserName.sendKeys(userName);
	}
	
	public void setUserPassword(String userPassword)
	{
		txtUserPassword.sendKeys(userPassword);
	}
	
	public void clickSubmit()
	{
		buttnLogin.click();
	}
	
	public void clickReset()
	{
		buttnReset.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
