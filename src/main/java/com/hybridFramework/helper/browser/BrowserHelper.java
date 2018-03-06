package com.hybridFramework.helper.browser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.hybridFramework.helper.logger.LoggerHelper;

public class BrowserHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(BrowserHelper.class);
	
	public BrowserHelper(WebDriver driver){
		this.driver = driver;
	}
	public void navTo(String url){
		log.info("Navigating to "+url);
		driver.navigate().to(url);
	}
	public void navBack(){
		log.info(" ");
		driver.navigate().back();
	}
	public void navForward(){
		log.info(" ");
		driver.navigate().forward();
	}
	public void refresh(){
		log.info(" ");
		driver.navigate().refresh();
	}
	public Set<String> getWindowHandles(){
		Set<String> handles = driver.getWindowHandles();
		log.info("Windows handles size "+handles.size());
		return handles;
	}
	public void switchToWindow(int index){
		List<String> windows = new ArrayList<String>(getWindowHandles());
		if(index<0 || index>windows.size()){
			throw new IllegalArgumentException("Invalid index "+index);
		}
		driver.switchTo().window(windows.get(index));
		log.info("Switching to "+index);
	}
	public void switchToParentWindow(){
		List<String> windows = new ArrayList<String>(getWindowHandles());
		driver.switchTo().window(windows.get(0));
	}
	public void switchToParentAndCloseWindows(){
		List<String> windows = new ArrayList<String>(getWindowHandles());
		for(int i=1; i<=windows.size(); i++){
			driver.switchTo().window(windows.get(i));
			log.info("Closing window id "+windows.get(i));
			driver.close();			
		}
		log.info("Switching to parent window");
		switchToParentWindow();
	}
	public void switchToIfram(String framNameOrId){
		driver.switchTo().frame(framNameOrId);
		log.info("Fram name or Id :" +framNameOrId);
	}
}
