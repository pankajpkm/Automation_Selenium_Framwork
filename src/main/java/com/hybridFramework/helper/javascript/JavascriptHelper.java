package com.hybridFramework.helper.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hybridFramework.helper.logger.LoggerHelper;

public class JavascriptHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavascriptHelper.class);
	
	public JavascriptHelper(WebDriver driver){
		this.driver = driver;
	}
	public Object javascriptExecuter(String script){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		log.info(script);
		return executor.executeScript(script);
	}
	public Object javascriptExecuter(String script, Object ...args){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		return executor.executeScript(script, args);
	}
	public void scrollToElement(WebElement element){
		
	}
	public void scrollToElementAndClick(WebElement element){
		
	}
}
