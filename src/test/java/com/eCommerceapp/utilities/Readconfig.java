package com.eCommerceapp.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	
	public Readconfig()
	{
		File src = new File("./Configurations/Config.properties");
		try
		{
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is" +e.getMessage());
		}
				
		}

	public String getApplicationURL()
	{
		String URL= pro.getProperty("baseURL");
		return URL;
		
	}
	
	public String getusername()
	{
		String username= pro.getProperty("username");
		return username;
		
	}
	
	public String getpassword()
	{
		String password= pro.getProperty("password");
		return password;
		
	}
	
	public String getchromepath()
	{
		String chromepath= pro.getProperty("chromepath");
		return chromepath;
		
	}
	
	public String getiepath()
	{
		String iepath= pro.getProperty("iepath");
		return iepath;
		
	}
}
