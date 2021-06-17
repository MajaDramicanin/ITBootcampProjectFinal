package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jdk.nashorn.internal.scripts.JS;

public class LocationPopupPage extends BasicPage{
	
	private JavascriptExecutor js; 
	
	public LocationPopupPage (WebDriver driver, JavascriptExecutor js) {
		super(driver);	
		this.js = js;
		
	}
	
	public WebElement getLocationHeader() {
		return driver.findElement(By.xpath("//div[@class=\"location-selector\"]/a"));
	}
	
	public WebElement getCloseBtn() {
		return driver.findElement(By.className("close-btn"));
	}
	
	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}
	
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '\" + locationName + \"')]/.."));
	}
	
	public WebElement getLocationInput(String locationName) {
		return  driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	
	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	
	public void popUpLocation() {
		this.getLocationHeader().click();
	}
	
	public void setLocation(String locationName) {
		this.getKeyword().click();
		int dataValue = Integer.parseInt(this.getLocationItem(locationName).getAttribute("data-value"));
		js.executeScript("arguments[0].value=arguments[1];", this.getLocationInput(locationName), dataValue);	
	}

}
