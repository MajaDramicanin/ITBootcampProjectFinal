package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdk.nashorn.internal.scripts.JS;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}

	public WebElement getLocationHeader() {
		return driver.findElement(By.xpath
				("//div[@class=\"location-selector\"]/a"));
	}

	public WebElement getCloseBtn() {
		return driver.findElement
				(By.xpath("//a[@class=\"close-btn close-btn-white\"]"));
	}

	public WebElement getKeyword() {
		return driver.findElement(By.id("locality_keyword"));
	}

	public WebElement getLocationItem(String locationName) {
		WebElement locationItem = waiter.until
				(ExpectedConditions.presenceOfElementLocated(By.xpath
						("//li/a[contains(text(), \"" + locationName + "\")]/..")));
		return locationItem;
		
	}

	public WebElement getLocationInput() {
		WebElement locationInput = waiter.until
				(ExpectedConditions.presenceOfElementLocated(By.xpath
						("//*[@id='location_id']")));
		return locationInput;
	}

	public WebElement getSubmit() {		
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	public void popUpLocation() {
		this.getLocationHeader().click();
	}

	public void setLocation(String locationName) throws InterruptedException {
		this.getKeyword().click();
		Thread.sleep(3000);
		WebElement locationItem = this.getLocationItem(locationName);
		String dValue = locationItem.getAttribute("data-value");
		WebElement locationInput = this.getLocationInput();		
		js.executeScript("arguments[0].value=arguments[1];", locationInput, dValue);
		Thread.sleep(300);
		this.getSubmit().submit();
	}

}
