package com.OrangeHRM.pageobjects;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.utilities.Selenium_helper;

public class DashboardPage {

	WebDriver ldriver;

	Selenium_helper sel_h;

	public DashboardPage(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement dashboard;

	public void dashboard() {
		// sel_h.element_visible(ldriver, dashboard, 10);
		sel_h.clickElement(dashboard);
	}
}
