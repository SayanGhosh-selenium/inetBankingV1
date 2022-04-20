package com.inetBanking.testClases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.utilities.ExcelUtils;

public class TC_EditCustomerTest_003 extends BaseClass{
	
	@Test
	public void editCustomer() throws IOException
	{
		EditCustomerPage editcust = new EditCustomerPage(driver);
		editcust.clickEditCustomer();
		editcust.skipAD();
		
		logger.info("Editing Customer details....");
		
		String path= System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/CustomerDetails.xlsx";
		String id = ExcelUtils.getCellData(path, "Sheet1", 1, 0);
		
		editcust.custID(id);
		
		editcust.custaddress("Desi road");
		editcust.custsubmit();
		
		String alertmsg = driver.switchTo().alert().getText();
		if(alertmsg.equalsIgnoreCase("No Changes made to Customer records"))
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Test case passed...");
			Assert.assertTrue(true);
		}
		else
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver,"EditCustomer");
			logger.info("Test case failed...");
			Assert.assertTrue(false);
		}
		
	}

}
