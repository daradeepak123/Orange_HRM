package com.OrangeHRM.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class Selenium_helper {
	
	public static WebDriver currentDriver; 
	public static String fieldName = "fName";
	
	
	
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
	
	
	public static boolean clickElement(WebElement buttonElement) 
	 {
	 
	 try
	 {
	 if(buttonElement!=null && buttonElement.isEnabled())
	 {
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
