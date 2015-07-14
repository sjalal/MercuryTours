package com.pack.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseSetup {

	protected WebDriver driver;
	static String chromeDriverPath = "C:/Users/sjalal0228/Desktop/Selenium_Java/Drivers/chromedriver_win32/";
	static String ieDriverPath = "C:/Users/sjalal0228/Desktop/Selenium_Java/Drivers/IEDriverServer_x64_2.46.0/";

	// private String baseUrl;

	/*
	 * public WebDriver getDriver() throws Exception{ Properties p = new
	 * Properties(); FileInputStream fi = new
	 * FileInputStream("C:\\app\\MercuryTour\\global.properties"); p.load(fi);
	 * baseUrl = p.getProperty("url"); if
	 * (p.getProperty("browser").contains("firefox")) driver = new
	 * FirefoxDriver(); driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * driver.get(baseUrl); return driver; }
	 */

	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String appUrl) {
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

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		return driver;
	}

	private WebDriver initChromeDriver(String appURL) {
		// initialize chrome driver
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", chromeDriverPath
				+ "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initIEDriver(String appURL) {
		// initialize IE driver
		System.out.println("Launching Internet Explorer..");
		System.setProperty("webdriver.ie.driver", ieDriverPath
				+ "IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		return driver;
	}

	@BeforeClass
	@Parameters({ "browserType", "appUrl" })
	public void initializeTestBaseSetup(String browserType, String appUrl) {
		try {
			setDriver(browserType, appUrl);
		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}// TestBaseSetup

