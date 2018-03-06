package com.hybridFramework.helper.assersion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.hybridFramework.helper.logger.LoggerHelper;

public class AssersionHelper {
	private static final Logger log=LoggerHelper.getLogger(AssersionHelper.class);
	
	public static synchronized boolean verifyElementIsDisplayed(WebElement element){
		boolean flag=false;
		try{
			element.isDisplayed();
			log.info(element.getText()+" is displayed");
			return flag=true;
		}
		catch(Exception ex){
			log.error("Element not present ", ex);
		}
		return flag;
	}
	public static synchronized boolean verifyElementNotDisplayed(WebElement element){
		boolean flag=false;
		try{
			element.isDisplayed();
			log.info(element.getText()+" is displayed");
			
		}
		catch(Exception ex){
			log.error("Element not present ", ex);
			return flag=true;
		}
		return flag;
	}
	public static synchronized boolean verifyElementIsSelected(WebElement element){
		boolean flag=false;
		try{
			element.isSelected();
			log.info(element.getText()+" is selected");
			return flag=true;
		}
		catch(Exception ex){
			log.error("Element not selected ", ex);
		}
		return flag;
	}
	public static synchronized boolean verifyElementNotSelected(WebElement element){
		boolean flag=false;
		try{
			element.isSelected();
			log.info(element.getText()+" is selected");
			
		}
		catch(Exception ex){
			log.error("Element not selected ", ex);
			return flag=true;
		}
		return flag;
	}

	public static synchronized boolean verifyElementIsEnabled(WebElement element){		
		boolean flag=false;
		try{
			element.isEnabled();
			log.info(element.getText()+" is enabled");
			return flag=true;
		}
		catch(Exception ex){
			log.error("Element not enabled ", ex);
		}
		return flag;
	}
	public static synchronized boolean verifyElementNotEnabled(WebElement element){
		boolean flag=false;
		try{
			element.isEnabled();
			log.info(element.getText()+" is enabled");
			
		}
		catch(Exception ex){
			log.error("Element not enabled ", ex);
			return flag=true;
		}
		return flag;
	}
	public static synchronized boolean verifyTextEquals(WebElement element, String expectedText){
		boolean flag=false;
		String actualText= element.getText();
		try{
			
			if(expectedText.equals(actualText)){
				log.info(expectedText +" and "+ actualText+" are equals");
				return flag=true;
			}else{
				log.error(expectedText +" and "+ actualText+" are not equals");
				return flag;
			}
		}
		catch(Exception ex){
			log.error(expectedText +" and "+ actualText+" are not equals", ex);
			log.info("Texts are not equals", ex);
			return flag;
		}
	}
}
