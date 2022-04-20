package com.inetBanking.testClases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewAccountPage;
import com.inetBanking.utilities.ExcelUtils;

public class TC_NewAccountTest_004 extends BaseClass {


	@Test
	public void NewAccount() throws IOException, InterruptedException
	{
		NewAccountPage acc = new NewAccountPage(driver);

		acc.clickNewAccount();
		acc.skipAD();

		logger.info("Providing details for new account....");

		String path= System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/CustomerDetails.xlsx";
		String id = ExcelUtils.getCellData(path, "Sheet1", 1, 0);

		acc.custID(id);
		acc.selectAccount("Savings");
		acc.depositAmount("4000");
		acc.submit();

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res=driver.getPageSource().contains("Account Generated Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewAccount");
			Assert.assertTrue(false);
		}
		LoginPage login = new LoginPage(driver);
		login.clickLogout();

	}

}
