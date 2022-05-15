package com.OrangeHRM.tests;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Logging_Reporting.Log4j_implement;




public class BaseClass {
	
	
	
	public String URL="https://opensource-demo.orangehrmlive.com/";
	public String Uname="Admin";
	public String pwd="admin123";
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeSuite
	public void files_open()
	{
		logger=LogManager.getLogger(Log4j_implement.class);
	}
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();

	}
	
	@AfterClass
	public void tear_down()
	{
		driver.quit();
	}


}
