package com.hybridFramework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Resources {

	public static String getResourcePath(String resource){
		String path= getBaseDir()+resource;
		
		return path;
	}

	private static String getBaseDir() {
		String basePath= System.getProperty("user.dir");
		return basePath;
	}
	public static InputStream getResourcesPathInputStream(String path) throws FileNotFoundException{
		return new FileInputStream(Resources.getResourcePath(path));
	}
}
