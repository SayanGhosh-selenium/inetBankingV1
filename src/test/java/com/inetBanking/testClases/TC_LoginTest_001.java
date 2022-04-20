package com.inetBanking.testClases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ExcelUtils;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setUserPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
				
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		
		int rownum=ExcelUtils.getRowCount(path, "Sheet1");
		int colcount=ExcelUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=ExcelUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}

}
