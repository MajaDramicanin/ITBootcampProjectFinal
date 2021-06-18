package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage{
	
	public MealPage (WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	private WebElement getProductList() {
		return this.driver.findElement(By.id("listing"));
	}
	
	public WebElement getFirstProduct() {
		return this.getProductList().findElement(By.xpath("//div[@class=\"product-head\"]"));
	}
	
	public void addToCart(String quantity) {
		this.getFirstProduct().click();
		this.driver.findElement(By.name("product_qty")).sendKeys(quantity);
		this.driver.findElement(By.name("product_qty")).click();
		this.driver.findElement(By.className("js-proceedtoAddInCart")).click();
	}
	
	public void addToFavorite() {
		this.getProductList().findElement(By.xpath("//div/div/a")).click();
		
	}
	
	
	
	
	
	

}
