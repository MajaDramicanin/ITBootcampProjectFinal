package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage{
	
	public NotificationSystemPage (WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getAlertMsgDiv() {
		return this.driver.findElement(By.className("system_message"));		
	}
	
	public String getAlertTxt() throws InterruptedException {
		Thread.sleep(200);
		WebElement msgDiv = this.getAlertMsgDiv().findElement(By.className("content"));
//		waiter.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(msgDiv, "Processing...")));
		boolean msgSucc = true;
		String msg = "";
		try{
			msg = msgDiv.getText();
		} catch (Exception e) {
			msgSucc = false;
		}
		if (!(msgSucc)) {
			msg = msgDiv.findElement(By.className("div_error")).getText();
			String msgR2 = msgDiv.findElement(By.xpath("//li")).getText();
			msg = msg + " " + msgR2;
		}
		return msg;
	}
	
	public void noAlertMsgWait() {		
		waiter.until(ExpectedConditions.attributeContains(this.getAlertMsgDiv(), "style", "display: none;"));
	}
	
	public void alertMsgWait() {
		waiter.until(ExpectedConditions.visibilityOf(getAlertMsgDiv()));
	}
	
	

}
