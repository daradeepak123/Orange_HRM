package com.OrangeHRM.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tt {
	public static WebDriver d;
	
	@Test
	public void h()
	{
		WebDriverManager.firefoxdriver().setup();
		d=new FirefoxDriver();
	}
	
	
	

}
