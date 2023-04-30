package com.OrangeHRM.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.OrangeHRM.pageobjects.DashboardPage;
import com.OrangeHRM.pageobjects.LoginPage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;

public class Login_test extends BaseClass{
	
	
	DashboardPage dp=new DashboardPage(driver);
	@Test
	public void Login_HRM() throws InterruptedException
	{
//		driver.get(URL);
//		
		LoginPage lp=new LoginPage(driver);
		lp.uname(Uname);
		lp.Password(pwd);
		lp.login_btn();

		Thread.sleep(2000);
		System.out.println("Login successful");
		logger.info("this is login page functionality");
		//logger.error("this got errored out");
		
		dp.dashboard();
		
		assertEquals(driver.getTitle(), "OrangeHRM");
		System.out.println("title information added "+driver.getTitle());
		

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
