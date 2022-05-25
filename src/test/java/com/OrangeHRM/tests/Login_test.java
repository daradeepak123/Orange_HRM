package com.OrangeHRM.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.OrangeHRM.pageobjects.LoginPage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;

public class Login_test extends BaseClass{
	
	
	
	@Test
	public void Login_HRM()
	{
//		driver.get(URL);
//		
//		LoginPage lp=new LoginPage(driver);
//		lp.uname(Uname);
//		lp.Password(pwd);
//		lp.login_btn();

		logger.info("this is login page functionality");
		logger.error("this got errored out");
		
		assertEquals(driver.getTitle(), "OrangeHRM");
		

		if (driver.getTitle().contains("OrangeHR"))
		{
			System.out.println("TEst Case Pass---->");
			logger.info("login is successful");
//			Status status=Status.PASS;
//			test.log(status, fieldName);
			
			
			
		}
		else
		{
			System.out.println("TC Fail");
			logger.info("login failed");
//			Status status=Status.FAIL;
//			test.log(status, fieldName);
		}
		
		
	}
	

}
