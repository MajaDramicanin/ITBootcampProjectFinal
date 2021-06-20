package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdk.nashorn.internal.scripts.JS;

public class LocationPopupPage extends BasicPage {

	private JavascriptExecutor js;

	public LocationPopupPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}

	public WebElement getLocationHeader() {
		return driver.findElement(By.xpath("//div[@class=\"location-selector\"]/a"));
	}

	public WebElement getCloseBtn() {
		return driver.findElement(By.xpath("//a[@class=\"close-btn close-btn-white\"]"));
	}

	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}

	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '\" + locationName + \"')]/.."));
	}

	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}

	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	public void popUpLocation() {
		this.getLocationHeader().click();
	}

	public void setLocation(String locationName) {
		this.getKeyword().click();
//		waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
//		js.executeScript("arguments[0].scrollIntoView();", this.getLocationItem(locationName));
		String dataValue = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1];", this.getLocationInput(), dataValue);
		this.getSubmit().click();
	}

}
