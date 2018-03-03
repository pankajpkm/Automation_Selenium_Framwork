package com.hybridFramework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.hybridFramework.helper.logger.LoggerHelper;


public class ObjectRepositories {
	Properties or;
	File f;
	FileInputStream file;
	private Logger logger = LoggerHelper.getLogger(Class.class);
	public Properties getObjectRepositoriesData() throws IOException{
		or = new Properties();
		String ORLocation = "\\src\\test\\java\\com\\hybridFramework\\or\\";
		
		//add this lines to read other object repositories
		f = new File(Resources.getResourcePath(ORLocation)+"homePageObjects.properties");
		logger.info("Loading Object Repositories from : "+f);
		file= new FileInputStream(f);
		or.load(file);	
		return or;
	}
	public Properties getConfigProperty(){
		or = new Properties();
		String ORLocation = "\\src\\main\\resources\\";
		f = new File(Resources.getResourcePath(ORLocation)+"config.properties");
		logger.info("Loading Object Repositories from : "+f);
		try {
			file= new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			or.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return or;
	}
}
