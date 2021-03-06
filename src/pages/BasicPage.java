package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {

	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;
	protected String errorMessage;

	public BasicPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
		this.waiter = waiter;
	}

	public String errorMessageSet(String message) {
		return " [ERROR] Unexpected " + message + " message ";
	}

}
