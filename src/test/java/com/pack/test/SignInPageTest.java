package com.pack.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.pageobject.SignInPage;
import com.pack.pageobject.TestBaseSetup;

public class SignInPageTest extends TestBaseSetup {

	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = getDriver();
	}

	@Test
	public void sampleTest() throws Exception {
		System.out.println("Printing from sign in class");
		// Need to login into the Mercury Application

		// To access the method in any class
		// You need to first create object for that class and then call
		// the methods of that class with the object
		// Creating object of a class means invoking constructor method of that
		// class
	}

	@Test
	public void verifySignIn() throws Exception {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.setUserId("test");
		signInPage.setPassword("test");
		signInPage.clickLoginBtn();
	}

	@Test
	public void verifyPageTitle() throws Exception {
		SignInPage signInPage = new SignInPage(driver);
		Assert.assertEquals(signInPage.getPageTitle(), "Welcome: Mercury Tours");
		System.out.println("Sign in page title: " + signInPage.getPageTitle());
	}

}// SignInPageTest

