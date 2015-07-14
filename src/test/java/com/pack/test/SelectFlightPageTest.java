package com.pack.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pack.pageobject.FlightFinderPage;
import com.pack.pageobject.SelectFlightPage;
import com.pack.pageobject.SignInPage;
import com.pack.pageobject.TestBaseSetup;



public class SelectFlightPageTest extends TestBaseSetup{

	private WebDriver driver;
	private SignInPage signInPage;
	private FlightFinderPage flightFinderPage;
	private SelectFlightPage selectFlightPage;
	
	@BeforeClass
	public void setup(){
		driver = getDriver();
	}
	@Parameters ({"userId" , "password"})
	@Test
	public void verifySelectPage(String userId, String password){
		signInPage = new SignInPage(driver);
		flightFinderPage = signInPage.loginFunction(userId, password);
		selectFlightPage = flightFinderPage.clickContinue();
		selectFlightPage.selectDepartFligh();
		selectFlightPage.clickOnContinue();
	}
	
	
	
}
