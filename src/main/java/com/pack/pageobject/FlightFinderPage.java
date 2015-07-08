package com.pack.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage {
	
	protected WebDriver driver;
	private By flightFinderImg = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");
	private By flightType = By.xpath("//input[@name = 'tripType']");
	private By passengers= By.name("passCount"); 
	private By departing= By.name("fromPort");
	private By departingMonth = By.name("fromMonth");
	private By departingDay = By.name("fromDay");
	private By arriving = By.name("toPort");
	private By arrivingMonth	= By.name("toMonth");
	private By arrivingDay = By.name("toDate");
	private By serviceClass = By.name("servClass");
	private By airline = By.name("airline");
	private By continueBtn = By.name("findFlights");
	
	
	public FlightFinderPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getPageTitle(){
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public boolean getImgSrc(){
		String imgSrc = driver.findElement(flightFinderImg).getAttribute("src");
		String expectedSrc = "/images/masts/mast_flightfinder.gif";
		System.out.println("Image source: "+imgSrc);
		return imgSrc.contains(expectedSrc);
	}
	
	public void selectFlightType(String tripType){
		List<WebElement> radioBtns  = driver.findElements(flightType);
		System.out.println("Number of radio button: "+radioBtns.size());
		for (WebElement radioBtn : radioBtns){
			if (radioBtn.getAttribute("value").equals(tripType))
				radioBtn.click();
		}
	}
	
	public void setNumberOfPassenger(String number){
		Select sel = new Select(driver.findElement(passengers));
		List<WebElement> options = sel.getOptions();
		for (WebElement option : options){
			System.out.println(option.getText());	
		}
		sel.selectByValue(number);
	}
	
	public void setDepartingPort(String portName){
		Select sel = new Select(driver.findElement(departing));
		sel.selectByValue(portName);
	}
	
	public void setDepartingMonth(String month){
		Select sel = new Select(driver.findElement(departingMonth));
		sel.selectByValue(month);
	}
	
	public void setDepartingDay(String day){
		Select sel = new Select(driver.findElement(departingDay));
		sel.selectByValue(day);
	}
	
	public void setArrivingPort(String portName){
		Select sel = new Select(driver.findElement(arriving));
		sel.selectByValue(portName);
	}
	
	public void setArrivingMonth(String month){
		Select sel = new Select(driver.findElement(arrivingMonth));
		sel.selectByValue(month);
	}
	
	public void setArrivingDay(String day){
		Select sel = new Select(driver.findElement(arrivingDay));
		sel.selectByValue(day);
	}
	
	public void selectServiceClass(String sClass){
		List<WebElement> radioBtns  = driver.findElements(serviceClass);
		System.out.println("Number of radio button: "+radioBtns.size());
		for (WebElement radioBtn : radioBtns){
			if (radioBtn.getAttribute("value").equals(sClass))
				radioBtn.click();
		}
	}
	
	public void setAirline(String preference){
		Select sel = new Select(driver.findElement(airline));
		sel.selectByValue(preference);
	}
	
	public void clickContinue(){
		WebElement element = driver.findElement(continueBtn);
		if (element.isDisplayed()||element.isEnabled())
			element.click();
	}
	
	/*public SelectFlightPage clickContinue(){
	 * 	System.out.println("Clicking on continue");
		WebElement element = driver.findElement(continueBtn);
		if (element.isDisplayed()||element.isEnabled())
			element.click();
		return new SelectFlightPage(driver);
	}*/
	
}

