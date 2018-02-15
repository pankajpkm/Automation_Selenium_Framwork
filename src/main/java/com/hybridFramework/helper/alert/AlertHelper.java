package com.hybridFramework.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.hybridFramework.helper.logger.LoggerHelper;

public class AlertHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver){
		this.driver = driver;
	}
	
	public void getAlert(){
		
	}
	public void getAlertText(){
		
	}
	public void acceptAlert(){
		
	}
	public void dismisAlert(){
		
	}
}
