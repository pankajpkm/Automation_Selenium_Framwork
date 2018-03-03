package com.hybridFramework.config;

import com.hybridFramework.base.TestBase;

public class Config extends TestBase{
	
	public String getEnvironment(){
		return getConfigProperty("Environment");
	}
	public String getUrl(){
		return getConfigProperty("Url");
	}
	public String getBrowser(){
		return getConfigProperty("Browser");
	}
	public String getBrowsers(){
		return getConfigProperty("Browsers");
	}
	public String getUsername(){
		return getConfigProperty("Username");
	}
	public String getPassword(){
		return getConfigProperty("Password");
	}
	public String getExplecitWait(){
		return getConfigProperty("ExplecitWait");
	}
	public String getPageLoadTimeOut(){
		return getConfigProperty("PageLoadTimeOut");
	}
	public String getDBType(){
		return getConfigProperty("DataBase.Type");
	}
	public String getDBUrl(){
		return getConfigProperty("DataBase.Url");
	}
	public String getDbUserName(){
		return getConfigProperty("DataBase.UserName");
	}
	public String getDBPassword(){
		return getConfigProperty("DataBase.Password");
	}
}
