package com.OrangeHRM.tests;



import java.awt.Desktop;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.OrangeHRM.pageobjects.LoginPage;
import com.OrangeHRM.utilities.Selenium_helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Logging_Reporting.Log4j_implement;
import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseClass extends Selenium_helper{
	
	
	
	public String URL="https://opensource-demo.orangehrmlive.com/";
	public static String Uname="Admin";
	public static String pwd="admin123";
	public static WebDriver driver;
	public static Logger logger;
	public static LoginPage lp;
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	@BeforeSuite
	public void files_open()
	{
		
		report = new ExtentReports();
		spark = new ExtentSparkReporter("C:\\Users\\darad\\eclipse-workspace\\Orange_HRM\\ExtentReport\\Report.html");
		report.attachReporter(spark);
		logger=LogManager.getLogger(Log4j_implement.class);
	}
	
	@BeforeClass
	public WebDriver setup()
	{
		try
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(URL);
		
		String creds[]=getdata_excel();
		
		lp=new LoginPage(driver);
		report.createTest("test pass");
		
		

		//lp.login_fun1(creds[0],creds[1]);
	//	lp.login_fun1(Uname,pwd);
//		lp.uname(Uname);
//		lp.Password(pwd);
//		lp.login_btn();
		
		
		}
		catch(Exception e)
		{
			e.getStackTrace();
			
		}
		return driver;
		
		
		
		

	}
	
	@AfterClass
	public void tear_down()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void end_suit()
	{
		
		try {
	report.flush();
	Desktop.getDesktop().browse(new File("C:\\Users\\darad\\eclipse-workspace\\Orange_HRM\\ExtentReport\\Report.html").toURI());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		}
	


}
