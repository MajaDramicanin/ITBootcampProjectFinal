package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;
import pages.SearchResultPage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;

	protected String baseUrl;
	protected String email;
	protected String password;

	protected AuthPage authPage;
	protected CartSummaryPage cartSummaryPage;
	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected MealPage mealPage;
	protected NotificationSystemPage notificationSystemPage;
	protected ProfilePage profilePage;
	protected SearchResultPage searchResultPage;

	public BasicTest() {
		this.baseUrl = "http://demo.yo-meals.com";
		this.email = "customer@dummyid.com";
		this.password = "12345678a";

	}

	@BeforeMethod
	public void Configuration() {

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		waiter = new WebDriverWait(driver, 10, 300);
		js = (JavascriptExecutor)driver;

		authPage = new AuthPage(driver);
		cartSummaryPage = new CartSummaryPage(driver);
		locationPopupPage = new LocationPopupPage(driver, js);
		loginPage = new LoginPage(driver);
		mealPage = new MealPage(driver);
		notificationSystemPage = new NotificationSystemPage(driver);
		profilePage = new ProfilePage(driver);
		searchResultPage = new SearchResultPage(driver);

	}

	@AfterMethod
	public void Close() {

	}

}
