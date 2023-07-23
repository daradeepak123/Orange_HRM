package com.OrangeHRM.tests;

import org.testng.annotations.Test;

import com.OrangeHRM.utilities.Selenium_helper;

public class Get_data extends Selenium_helper {
	
	
	
	public void getData()
	{
		
		
		
		
		
	}
	
	
	
	
	@Test
	public void datapull()
	{
		String cred[]=getdata_excel(System.getProperty("user.dir")+"/Data/creds.xlsx","Sheet2");
		
		System.out.println(cred[1]);
		
		
		
	}
	
	

}
