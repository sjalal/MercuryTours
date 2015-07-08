package com.pack.pageobject;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestBaseSetup {

	private WebDriver driver;
	//private String baseUrl;
	
	
	/*public WebDriver getDriver() throws Exception{
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream("C:\\app\\MercuryTour\\global.properties");
		p.load(fi);
		baseUrl = p.getProperty("url");
		if (p.getProperty("browser").contains("firefox"))
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(baseUrl);
			return driver;
	}*/

	public WebDriver getDriver(){
		//System.out.println(driver);
		return driver;
	}
	
	private void setDriver(String browserType, String appUrl){
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appUrl);
			break;
		case "firefox":
			driver = initFirefoxDriver(appUrl);
			break;
		case "ie":
			driver = initIEDriver(appUrl);
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appUrl);
		}
	}
			
	private static WebDriver initFirefoxDriver(String appURL){
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	private  WebDriver initChromeDriver(String appURL){
		//initialize chrome driver
		return driver;
	}
	
	private WebDriver initIEDriver(String appURL){
		//initialize Internet explorer
		return driver;
	}
	
	
	@BeforeClass
	@Parameters ({"browserType", "appUrl"})
	public void initializeTestBaseSetup(String browserType, String appUrl){
		try {
			setDriver(browserType, appUrl);
		} catch (Exception e){
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	
	@Test
	@Parameters({"browserType", "appUrl"})
	public void testing(String browser, String url ){
		System.out.println("Browser Type: "+browser);
		System.out.println("URL Address: "+url);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}// TestBaseSetup

