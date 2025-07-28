package com.inetBanking.testClases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig rc = new ReadConfig();
	
	public String baseURL = rc.getApplication();
	public String username = rc.getUsername();
	public String userpassword = rc.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String br)
	{
		
		logger = Logger.getLogger("Internet Banking");
		PropertyConfigurator.configure("log4j.properties");
		
		if (br.equals("chrome"))
		{
//		    WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equals("Edge"))
		{
//			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(br.equals("Firefox"))
		{
//			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL is opened");
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}

