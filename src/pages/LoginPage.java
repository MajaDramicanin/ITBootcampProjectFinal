package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage{
	
	public LoginPage (WebDriver driver) {
		super(driver);	
	}

	public WebElement getEmail() {
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}
	
	public void signIn(String email, String password) {
		this.getEmail().sendKeys(email);
		this.getPassword().sendKeys(password);
		driver.findElement(By.name("btn_submit")).click();
	}
	
}
