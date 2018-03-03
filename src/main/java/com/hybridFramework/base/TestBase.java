package com.hybridFramework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;
import com.hybridFramework.excelreader.ExcelReader;
import com.hybridFramework.helper.logger.LoggerHelper;
import com.hybridFramework.utils.ObjectRepositories;
import com.hybridFramework.utils.Resources;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	WebDriver driver;
	ObjectRepositories OR;
	Properties properties;
	ExcelReader excelReader;
	ExtentTest test;
	static ExtentReports report;
	private static final Logger logger= LoggerHelper.getLogger(TestBase.class);
	
	static{
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		report = new ExtentReports(System.getProperty("user.dir")+"\\extentReports\\test"+"_"+formater.format(calender.getTime())+".html",false);
		report.addSystemInfo("UserName","Pankaj Kumar")
		.addSystemInfo("Environment","Development");
		report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		
	 }
	
	public void getBrowser(String browser){		
		if(System.getProperty("os.name").contains("Window")){
			
			if(browser.equalsIgnoreCase("Firefox")){
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", Resources.getResourcePath("\\drivers\\chromedriver.exe"));
				driver = new ChromeDriver();
			}

			logger.info("Selected Browse is " +browser);
		}
		if(System.getProperty("os.name").contains("Mac")){
			if(browser.equalsIgnoreCase("Firefox")){
				System.setProperty("webdriver.firefox.merionetee", System.getProperty("user.dir")+"/drivers/geckodriver");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("Chrome")){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
				driver = new ChromeDriver();
				
			}
			logger.info("Selected Browse is " +browser);
		}
	}
	public void loadPropertiesFile(){
		logger.info("Loading properies files...");
		properties = new Properties();
		String configPath=System.getProperty("user.dir")+"\\src\\main\\resources\\";
		File f1 = new File(configPath+"config.properties");
		FileInputStream file;
		try {
			file = new FileInputStream(f1);
			logger.info("Property file is found : " +f1);
			try {
				properties.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	public WebElement getLocator(String locator) throws Exception{
		System.out.println(locator);
		String[] str = locator.split(":");
		String locatorType= str[0];
		String locatorValue= str[1];
		
		if(locatorType.equalsIgnoreCase("id"))
			return driver.findElement(By.id(locatorValue));
		else if(locatorType.equalsIgnoreCase("name"))
			return driver.findElement(By.name(locatorValue));
		else if(locatorType.equalsIgnoreCase("classname")
				||locatorType.equalsIgnoreCase("class"))
			return driver.findElement(By.className(locatorValue));
		else if(locatorType.equalsIgnoreCase("tagname")
				||locatorType.equalsIgnoreCase("tag"))
			return driver.findElement(By.tagName(locatorValue));
		else if(locatorType.equalsIgnoreCase("linktext")
				||locatorType.equalsIgnoreCase("link"))
			return driver.findElement(By.linkText(locatorValue));
		else if(locatorType.equalsIgnoreCase("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if(locatorType.equalsIgnoreCase("cssselector")
				||locatorType.equalsIgnoreCase("css"))
			return driver.findElement(By.cssSelector(locatorValue));
		else if(locatorType.equalsIgnoreCase("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else 
			throw new Exception("Unknown locator type '"+locatorType+"'");
	}
	
	public List<WebElement> getLocators(String locator) throws Exception{
		String[] str = locator.split(":");
		String locatorType= str[0];
		String locatorValue=str[1];
		
		if(locatorType.equalsIgnoreCase("id"))
			return driver.findElements(By.id(locatorValue));
		else if(locatorType.equalsIgnoreCase("name"))
			return driver.findElements(By.name(locatorValue));
		else if(locatorType.equalsIgnoreCase("classname")
				||locatorType.equalsIgnoreCase("class"))
			return driver.findElements(By.className(locatorValue));
		else if(locatorType.equalsIgnoreCase("tagname")
				||locatorType.equalsIgnoreCase("tag"))
			return driver.findElements(By.tagName(locatorValue));
		else if(locatorType.equalsIgnoreCase("linktext")
				||locatorType.equalsIgnoreCase("link"))
			return driver.findElements(By.linkText(locatorValue));
		else if(locatorType.equalsIgnoreCase("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorValue));
		else if(locatorType.equalsIgnoreCase("cssselector")
				||locatorType.equalsIgnoreCase("css"))
			return driver.findElements(By.cssSelector(locatorValue));
		else if(locatorType.equalsIgnoreCase("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		else 
			throw new Exception("Unknown locator type '"+locatorType+"'");
	}	
	public WebElement getWebElement(String locator) throws Exception{
		OR =new ObjectRepositories();
		return getLocator(OR.getObjectRepositoriesData().getProperty(locator));
		
	}
	public List<WebElement> getWebElements(String locator) throws Exception{
		OR =new ObjectRepositories();
		System.out.println(OR.toString());
		return getLocators(OR.getObjectRepositoriesData().getProperty(locator));
	}
	public String getConfigProperty(String key){
		OR =new ObjectRepositories();
		return OR.getConfigProperty().getProperty(key);
		
	}
	
	public String[][] getExcelData(String excelFileName, String sheetName){
		logger.info("Reading Excel data...");
		excelReader = new ExcelReader();
		String fileLocation = Resources.getResourcePath("\\src\\main\\resources\\testdata\\")+excelFileName;
		return excelReader.readExcelData(fileLocation, sheetName);
	}
	
	public String getScreenshot(String imageName) throws IOException{
		if(imageName.equals("")){
			imageName = "_";
		}
		File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String storeLocation = System.getProperty("user.dir")+"\\Screenshots\\";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		
		String screenshotActualName = imageName+storeLocation+"_"+dateFormate.format(calendar.getTime())+".png";
		File destFile = new File(screenshotActualName);
		Files.copy(sourceFile, destFile);
		
		return screenshotActualName;
	}
	
	public WebDriverWait waitForElement(WebDriver driver, long timeOut, WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return wait;
	}
	
	public Wait<WebDriver> fluentWaitForElement(WebDriver driver, long timeOut, WebElement element){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeOut, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return wait;
	}
	
	public void emplicitWait(WebDriver driver, long timeOut){
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public void getTestResult(ITestResult result) throws IOException{
		if(result.getStatus()== ITestResult.STARTED){
			test.log(LogStatus.INFO, result.getName()+" is started ..");
		}
		else if(result.getStatus()== ITestResult.SUCCESS){
			test.log(LogStatus.PASS, result.getName()+" is passed successfuly.");
		}
		else if(result.getStatus()== ITestResult.SKIP){
			test.log(LogStatus.SKIP, result.getName()+" is skipped due to "+ result.getThrowable());
		}
		else if(result.getStatus()== ITestResult.FAILURE){
			test.log(LogStatus.FAIL, result.getName()+" is fail due to "+ result.getThrowable());
			
			String screenshot =  getScreenshot(result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshot));
		}		
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
		getTestResult(result);
	}
	@BeforeMethod
	public void beforeMethod(Method method){
		test = report.startTest(method.getName());
		test.log(LogStatus.INFO, method.getName()+"test Started.");
	}
	@AfterClass(alwaysRun=true)
	public void closeSession(){
	//driver.quit();
	report.endTest(test);
	report.flush();
	}
/*	public static void main(String[] args) throws Exception{
		System.out.println("Main");
		TestBase base = new TestBase();
		base.getWebElements("submitbutton");
		
	}*/
}
