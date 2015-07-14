package com.pack.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectFlightPage {

	protected WebDriver driver;
	private By continueBtn = By.name("reserveFlights"); 
	private By outFlight = By.name("outFlight");
	
	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectDepartFligh(){
		List<WebElement> radioButtons = driver.findElements(outFlight);
		for (WebElement radioButton : radioButtons){
			System.out.println(radioButton.getAttribute("value"));
			if(radioButton.getAttribute("value").startsWith("Pangea"))
				radioButton.click();
		}
	}

	public void clickOnContinue(){
		WebElement element = driver.findElement(continueBtn);
		if (element.isEnabled()||element.isDisplayed())
			element.click();
		else 
			System.out.println("Element not found");
	}
	
} //SelectFlightPage
