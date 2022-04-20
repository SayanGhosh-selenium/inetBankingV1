package com.inetBanking.testClases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.NewCustomerPage;
import com.inetBanking.utilities.ExcelUtils;

public class TC_NewCustomerTest_002 extends BaseClass {
	
	@Test(dataProvider="NewCustomerData")
	public void addNewCustomer(String name,String gender,String dob,String address,String city,String state,String PIN,String phn,String pwd) throws InterruptedException, IOException
	{
		
		NewCustomerPage addcust=new NewCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		addcust.skipAD();
		
		logger.info("providing customer details....");
		
		
		addcust.custName(name);
		addcust.custgender(gender);
		addcust.custdob(dob);
		Thread.sleep(3000);
		addcust.custaddress(address);
		addcust.custcity(city);
		addcust.custstate(state);
		addcust.custpinno(PIN);
		addcust.custtelephoneno(phn);
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword(pwd);
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		
		if(res==true)
		{

			int j = 0;
			for(WebElement ele:addcust.customerData1)
			{
				String val = ele.getText();
				String path= System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/CustomerDetails.xlsx";
				ExcelUtils.setCellData(path, "Sheet1", 1, j, val);
				j++;
			}
			
			Assert.assertTrue(true);
			logger.info("Test case passed....");
			addcust.custcontinue();	
		}
		else
		{
			logger.info("Test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	@DataProvider(name="NewCustomerData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/NewCustomerData.xlsx";
		
		int rownum=ExcelUtils.getRowCount(path, "Sheet1");
		int colcount=ExcelUtils.getCellCount(path,"Sheet1",1);
		
		String Custdata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				Custdata[i-1][j]=ExcelUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return Custdata;
	}

}
