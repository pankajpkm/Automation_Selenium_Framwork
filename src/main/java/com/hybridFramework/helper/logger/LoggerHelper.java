package com.hybridFramework.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.logging.log4j.core.Logger;

import com.hybridFramework.utils.Resources;

public class LoggerHelper {

	private static boolean root=false;
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clasz){
		if(root){
			return Logger.getLogger(clasz);
		}
		PropertyConfigurator.configure(Resources.getResourcePath("\\src\\main\\resources\\")+"log4j.properties");
		root=true;
		return Logger.getLogger(clasz);
	}
}
