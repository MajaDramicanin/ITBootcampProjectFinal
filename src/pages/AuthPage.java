package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AuthPage extends BasicPage{

	public AuthPage (WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);	
	}
	
	
	public WebElement getUserBtn() {		
		return this.driver.findElement(By.xpath("//a[@class=\"after-arrow user-trigger-js\"]"));
	}

		
	public WebElement getLogoutBtn() {
		return this.driver.findElement(By.xpath("'//div[@class=\"my-account-dropdown\"]/ul/li[2]/a"));
	}
	
	public void logoutUser() throws InterruptedException {
		this.getUserBtn().click();
		Thread.sleep(500);
		js.executeScript("arguments[0].click();", this.getLogoutBtn());
		Thread.sleep(500);
	}
	
	
}
