package com.OrangeHRM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.tests.BaseClass;
import com.OrangeHRM.utilities.Selenium_helper;

import junit.framework.Assert;

public class LoginPage {

	WebDriver ldriver;

	Selenium_helper sel_h;



	public LoginPage(WebDriver rdriver) {

		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}


	@FindBy(xpath="//input[@name='username']") 
	WebElement uname;

	@FindBy(xpath="//input[@name='password']")
	WebElement Pwd;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement login_btn;



	public void uname(String username)
	{
		uname.sendKeys(username);

	}
	public void Password(String Passwrd)
	{
		Selenium_helper.send_data_textbox(ldriver, Pwd, Passwrd, 10);
		//Pwd.sendKeys(Passwrd);
	}
	public void login_btn()
	{

		Selenium_helper.clickElement(login_btn);
		//login_btn.click();
	}

	public void login_btn1()
	{
		Selenium_helper.waitForAobjectToBeVisible(ldriver,login_btn ,"Login_button" , 40);
		Selenium_helper.clickElement(login_btn);
	}

	public void login_fun()
	{
		uname(BaseClass.UnameText);
		Password(BaseClass.pwdText);
		login_btn();

	}

	public void login_fun1(String username, String Passwrd)
	{

		uname.sendKeys(username);

		//Pwd.sendKeys(Passwrd);

		Selenium_helper.send_data_textbox(ldriver,Pwd,Passwrd, 10000 );

		Selenium_helper.clickElement(login_btn);


	}


}
