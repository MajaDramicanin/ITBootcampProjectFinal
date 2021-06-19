package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage{
	
	public NotificationSystemPage (WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getAlertMsgDiv() {
		return this.driver.findElement(By.className("system_message"));		
	}
	
	public String getAlertTxt() {
		return this.getAlertMsgDiv().getText();
	}
	
	public void noAlertMsgWait() {		
		waiter.until(ExpectedConditions.attributeContains(this.getAlertMsgDiv(), "style", "display: none;"));
	}
	
	public void alertMsgWait() {
		waiter.until(ExpectedConditions.visibilityOf(getAlertMsgDiv()));
	}
	
	

}
