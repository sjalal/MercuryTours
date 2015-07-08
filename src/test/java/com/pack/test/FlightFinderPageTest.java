package com.pack.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.pageobject.FlightFinderPage;
import com.pack.pageobject.SignInPage;
import com.pack.pageobject.TestBaseSetup;

public class FlightFinderPageTest extends TestBaseSetup{

	private WebDriver driver;
	private SignInPage signInPage;
	private FlightFinderPage flightFinderPage;
	
	@BeforeClass
	public void setup(){
		driver = getDriver();
	}
	
	@Test
	public void sampleTest()throws Exception{
		System.out.println("Printing from Flight finder class");
	}
	
	@Test 
	public void verifyImgSrc()throws Exception{
		Assert.assertTrue(flightFinderPage.getImgSrc(), "Image not found");
	}
	
	@Test
	public void verifyFlightType()throws Exception{
		signInPage = new SignInPage(driver);
		flightFinderPage = signInPage.loginFunction("test", "test");
		flightFinderPage.setNumberOfPassenger("2");
		flightFinderPage.setDepartingPort("Paris");
		flightFinderPage.selectFlightType("oneway");
	}
	
}//FlighFinderPageTest

