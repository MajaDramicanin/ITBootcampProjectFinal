package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}


	public void addToCart(int quantity) {
		String qty = Integer.toString(quantity);
		this.driver.findElement(By.name("product_qty")).click();
		this.driver.findElement(By.name("product_qty")).sendKeys(Keys.BACK_SPACE);
		this.driver.findElement(By.name("product_qty")).sendKeys(qty);
		this.driver.findElement(By.className("js-proceedtoAddInCart")).click();
	}

	public void addToFavorite() {
		this.driver.findElement(By.className("favourite")).click();
	}

}
