package com.OrangeHRM.utilities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class Selenium_helper {
	
	



	Selenium_helper sh;

	public static WebDriver currentDriver; 
	public static String fieldName = "fName";
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	public static JavaScriptUtils js;
	
	
	
	

	public static void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 15; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}

	private static void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) currentDriver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	
	public void Extent_invoke()
	{
		report = new ExtentReports();
		spark = new ExtentSparkReporter("C:\\Users\\darad\\eclipse-workspace\\Orange_HRM\\ExtentReport\\Report.html");
		report.attachReporter(spark);
	}
	
	public String[] getdata_excel()

	{
		String[] data = new String[2];
		try
		{
		//System.getProperty("user.dir")+ "/src/config/config.properties"
		File file=new File(System.getProperty("user.dir")+"/Data/creds.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sht=wb.getSheet("Sheet2");
		
		
		
		String uname=sht.getRow(0).getCell(0).getStringCellValue();
		String Pwd=sht.getRow(0).getCell(1).getStringCellValue();
		
		
		data[0]=uname;
		data[1]=Pwd;
		
		System.out.println("celldata   1 "+data[0]);
		System.out.println("celldata   1 " +data[1]);
		
		
		
		}
		catch (Exception e)
		{
			e.getStackTrace();
			System.out.println(e);
		}
		return data;
	}
	
	 public static void waitForAobjectToBeVisible(WebDriver driver,WebElement element, String objectName, long timeOutInSeconds)
	 {
	 WebDriverWait wait;
	 try {
		
	 wait = new WebDriverWait(driver, timeOutInSeconds);
	 wait.until(ExpectedConditions.visibilityOf(element));
	 }catch(Throwable t)
	 {
	 if(t.getClass().getSimpleName().trim().equalsIgnoreCase("TimeoutException"))
	 {
	 //insertReportLine(LogStatus.FAIL, objectName+" Object Couldnot be found on the UI [TimeOut Occured after "+timeOutInSeconds+" seconds]");
	 Assert.assertTrue(false,objectName+" Object Couldnot be found on the UI[TimeOut Occured after "+timeOutInSeconds+" seconds]");
	 }
	 else
	 {
	 //insertReportLine(LogStatus.FAIL, t.getClass().getSimpleName()+" Exception occured while waiting for "+objectName+" element");
	 Assert.assertTrue(false, t.getClass().getSimpleName()+" Exception occured while waiting for "+objectName+" element");
	 }
	 }
	 }
	
	 
	 public static void element_visible(WebDriver driver, WebElement ele, long time)
	 {
		 WebDriverWait wait;
		 try {
			 
			 wait = new WebDriverWait(driver, time);
			 wait.until(ExpectedConditions.visibilityOf(ele));
			 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
	 }
	 
	 
	 
	 public static void send_data_textbox(WebDriver driver,WebElement ele,String data, long time)
	 {
		 element_visible(driver,ele,time);
		 if (ele!=null && ele.isDisplayed())
		 {
			 ele.sendKeys(data);
			 report.createTest("data passed into text box", "no issues identified with "+ele+"");
		 }
		 else
		 {
			 assertEquals(false, true, "this text box "+ele+"is not visible check the code");
			 report.createTest("data is not passed into text box", "there is some issues identified with "+ele+"");
				
			 
		 }
		 
		 
	 }
	 
	 
	 
	
	public static boolean clickElement(WebElement buttonElement) 
	 {
	 try
	 {
	 if(buttonElement!=null && buttonElement.isEnabled())
	 {
	 //flash(buttonElement);
	 buttonElement.click();
	// insertReportLine(LogStatus.PASS, "The "+fieldName+" element of "+pageName+" should be clicked ","The "+fieldName+" element of "+pageName+" element is clicked " );
	 return true;
	 }else
	 {
	 //insertReportLine(LogStatus.FAIL, "The "+fieldName+" element of "+pageName+" should be clicked ","The "+fieldName+" element of "+pageName+" element is not clicked " );
	 Assert.assertTrue(false, "Unable to Click on "+fieldName+". The field is either null or not enabled");
	 }
	 }
	 catch(Exception e)
	 {
	 e.getMessage();
	 //insertReportLine(e);
	 //insertReportLine(LogStatus.FAIL, "The "+fieldName+" element of "+pageName+" should be clicked ",e.getClass().getName()+"Exception occured while clicking on "+fieldName+" element of "+pageName );
	// Assert.assertTrue(false, e.getClass().getName()+"Exception occured while Clicking on "+fieldName+" element of "+pageName);
	 }
	 return false;
	 }
	
	
	

}
