package com.OrangeHRM.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserChoice {
	
	private File file;
	private FileInputStream fi;
	public static String browser;
	public String propertiesPathName=System.getProperty("user.dir")+"\\src\\test\\java\\com\\OrangeHRM\\testdata\\config.properties";
	public String url;
	
	public static WebDriver driver;
	
	
	public WebDriver browser() throws IOException
	{
		file = new File(propertiesPathName);
		fi = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fi);
		browser = prop.getProperty("browser");
		url = prop.getProperty("URL");
		System.out.println(browser);
		System.out.println(url);
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			
			driver=new EdgeDriver();
		}
		else if(browser.equals("ff"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();
		}
		driver.get(url);
		
		return driver;
		
	}
	
	
	

}
