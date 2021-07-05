package tests;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
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
	
//	protected String errorMessage;

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

	public String errorMessageSet(String message) {
		return " [ERROR] Unexpected " + message + " message ";
	}

	@BeforeMethod
	public void Configuration() {

		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		waiter = new WebDriverWait(driver, 20, 200);
		js = (JavascriptExecutor) driver;

		authPage = new AuthPage(driver, waiter, js);
		cartSummaryPage = new CartSummaryPage(driver, waiter, js);
		locationPopupPage = new LocationPopupPage(driver, waiter, js);
		loginPage = new LoginPage(driver, waiter, js);
		mealPage = new MealPage(driver, waiter, js);
		notificationSystemPage = new NotificationSystemPage(driver, waiter, js);
		profilePage = new ProfilePage(driver, waiter, js);
		searchResultPage = new SearchResultPage(driver, waiter, js);

	}

	@AfterMethod
	public void screenshotOnFailureAndClose(ITestResult result) throws IOException, InterruptedException {

		if (result.getStatus() == ITestResult.FAILURE) {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");			
			String imgUrl = "C:\\Users\\majad\\Desktop\\IT Bootcamp\\projects\\ITBootcampProjectFinal\\screenshots\\" + ldt.format(formatDateTime) + ".png";;
						
			FileUtils.copyFile(srcFile, new File(imgUrl));

		}
		Thread.sleep(1000);
		this.driver.quit();
		Thread.sleep(2000);
	}

}
