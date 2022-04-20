package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configurations//cofig.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is : " + e.getMessage());
		}
	}
	
	public String getApplication()
	{
		String url =pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String user =pro.getProperty("username");
		return user;
	}
	
	public String getPassword()
	{
		String pass =pro.getProperty("userpassword");
		return pass;
	}
	
	public String getChromePath()
	{
		String chromepath =pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIEpath()
	{
		String iepath =pro.getProperty("iepath");
		return iepath;
	}

}
