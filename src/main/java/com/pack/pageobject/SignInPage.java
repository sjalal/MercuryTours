package com.pack.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

	protected WebDriver driver;
	private By userName = By.name("userName");
	private By passwd = By.name("password");
	private By loginBtn = By.name("login");
	//All objects belongs to this page
	
	//constructor for this class (Note: you need create this basic constructor for each page object class)
	public SignInPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void setUserId(String userId){
		driver.findElement(userName).sendKeys(userId);
	}
	
	public void setPassword(String password){
		driver.findElement(passwd).sendKeys(password);
	}
	
	public String getPageTitle(){
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public FlightFinderPage clickLoginBtn() {
		System.out.println("Clicking on Login button...");
		WebElement element = driver.findElement(loginBtn);
		if (element.isEnabled() || element.isDisplayed())
			element.click();
		else System.out.println("Elements not found");
		return new FlightFinderPage(driver);
	}
	
	public FlightFinderPage loginFunction(String userId, String password){
		System.out.println("Signing in...");
		driver.findElement(userName).sendKeys(userId);
		driver.findElement(passwd).sendKeys(password);
		WebElement element = driver.findElement(loginBtn);
		element.click();
		return new FlightFinderPage(driver);
	}
	
}

