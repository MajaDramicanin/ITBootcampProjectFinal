package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {
	
	protected WebDriver driver;
	protected WebDriverWait waiter;

	public BasicPage(WebDriver driver) {
		this.driver = driver;
	}

}
