package com.hybridFramework.helper.dropdown;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.hybridFramework.helper.logger.LoggerHelper;

public class DropdownHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(DropdownHelper.class);
	
	public DropdownHelper(WebDriver driver){
		this.driver = driver;
	}
	public void selectByVisibleText(){
		
	}
}
