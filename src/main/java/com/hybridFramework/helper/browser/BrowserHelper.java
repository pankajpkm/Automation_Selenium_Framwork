package com.hybridFramework.helper.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.hybridFramework.helper.logger.LoggerHelper;

public class BrowserHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(BrowserHelper.class);
	
	public BrowserHelper(WebDriver driver){
		this.driver = driver;
	}
	public void navBack(){
		
	}
	public void navForward(){
		
	}
	public void refresh(){
		
	}
}
