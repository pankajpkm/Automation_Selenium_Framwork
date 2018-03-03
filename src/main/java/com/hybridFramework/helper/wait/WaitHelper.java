package com.hybridFramework.helper.wait;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.hybridFramework.helper.logger.LoggerHelper;

public class WaitHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver){
		this.driver = driver;
	}
}
