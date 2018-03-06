package com.hybridFramework.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.hybridFramework.helper.logger.LoggerHelper;

public class AlertHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver){
		this.driver = driver;
	}
	
	public Alert getAlert(){
		log.debug("");
		return driver.switchTo().alert();
	}
	public void acceptAlert(){
		log.debug("Accepting alert");
		getAlert().accept();
	}
	public void dismissAlert(){
		log.debug("Dismiss alert");
		getAlert().dismiss();
	}
	public String getAlertText(){
		String text= getAlert().getText();
		log.info("Alert text : "+text);
		return text;
	}
	public boolean isAlertPresent(){
		try{
			driver.switchTo().alert();
			log.debug("Alert Present");
			return true;
		}
		catch(NoAlertPresentException e){
			log.debug("No alert present : False");
			return false;
		}
	}
	public void acceptAlertIfPresent(){
		if(isAlertPresent())
		return;
		acceptAlert();
		log.debug("Accepted present alert");
	}
	public void dismisAlertIfPresent(){
		if(isAlertPresent())
			return;
		dismissAlert();
		log.debug("Dismissed present alert");
	}
	public void acceptPromt(String str){
		//implementations goes here
	}
}
