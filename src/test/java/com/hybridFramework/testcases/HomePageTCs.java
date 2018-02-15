package com.hybridFramework.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridFramework.base.TestBase;
import com.hybridFramework.helper.logger.LoggerHelper;

public class HomePageTCs extends TestBase {
	
	Logger logger = LoggerHelper.getLogger(HomePageTCs.class);
	
	@DataProvider(name="ExcelData")
	public Object[][] getData(){
		//System.out.println("Printing data :"+getExcelData("TestData.xlsx", "Dashboard"));
		return getExcelData("TestData.xlsx", "Dashboard");
	}
	@Test(dataProvider="ExcelData")
	public void testMethod(String Test_Id, String Description, String Run_Mode){		
		logger.info("Reading dashboard data of excel sheet..");
		System.out.println("Test_Id : " + Test_Id);	
		System.out.println("Description : " + Description);
		System.out.println("Run_Mode : " + Run_Mode);		
	}
}
