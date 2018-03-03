package com.hybridFramework.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hybridFramework.helper.logger.LoggerHelper;

public class HomePage {
	
	private Logger logger = LoggerHelper.getLogger(HomePage.class);
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
