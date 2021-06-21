package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public List<WebElement> getSearchResults(){
		return driver.findElements(By.xpath("//*[@class=\"product-name\"]/a"));		
	}
	
	public int getSearchResultsNumber() {
		return this.getSearchResults().size();
	}

}
