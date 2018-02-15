package com.hybridFramework.helper.window;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.hybridFramework.helper.logger.LoggerHelper;

public class WindowsHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WindowsHelper.class);
	
	public WindowsHelper(WebDriver driver){
		this.driver = driver;
	}
	
	public void getParentWindow(){
		
	}
	public void getAllChildWindows(){
		
	}
	public void getChildWindowByIndex(String index){
		
	}
	public void getChildWindowByName(String name){
		
	}
}
