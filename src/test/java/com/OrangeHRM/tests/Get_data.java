package com.OrangeHRM.tests;

import org.testng.annotations.Test;

import com.OrangeHRM.utilities.Selenium_helper;

public class Get_data extends Selenium_helper {
	
	
	@Test
	public void datapull()
	{
		String cred[]=getdata_excel();
		
		System.out.println(cred[1]);
		
		
		
	}
	
	

}
