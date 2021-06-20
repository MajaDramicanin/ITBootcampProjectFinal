package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ProfilePage extends BasicPage {

	public Actions action;

	public ProfilePage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		this.action = new Actions(driver);

	}

	private WebElement getProfileForm() {
		return this.driver.findElement(By.id("profileInfoFrmBlock"));
	}

	public WebElement getFirstName() {
		return this.getProfileForm().findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {
		return this.getProfileForm().findElement(By.name("user_last_name"));
	}

	public WebElement getAddress() {
		return this.getProfileForm().findElement(By.name("user_address"));
	}

	public WebElement getPhone() {
		return this.getProfileForm().findElement(By.name("user_phone"));
	}

	public WebElement getZipCode() {
		return this.getProfileForm().findElement(By.name("user_zip"));
	}

	public Select getCountry() {
		Select country = new Select(this.getProfileForm().findElement(By.id("user_country_id")));
		return country;
	}

	public Select getState() {
		Select state = new Select(this.getProfileForm().findElement(By.id("user_state_id")));
		return state;
	}

	public Select getCity() {
		Select city = new Select(this.getProfileForm().findElement(By.id("user_city")));
		return city;
	}

	public WebElement getSaveProfileBtn() {
		return this.getProfileForm().findElement(By.name("btn_submit"));
	}

	private WebElement getPasswordForm() {
		return this.driver.findElement(By.id("changePwdFrm"));
	}

	public WebElement getCurrentPassword() {
		return this.getPasswordForm().findElement(By.name("current_password"));
	}

	public WebElement getNewPassword() {
		return this.getPasswordForm().findElement(By.name("new_password"));
	}

	public WebElement getConfirmPassword() {
		return this.getPasswordForm().findElement(By.name("conf_new_password"));
	}

	public WebElement getSavePasswordBtn() {
		return this.getPasswordForm().findElement(By.name("btn_submit"));
	}

	public WebElement getAvatar() {
		return this.driver.findElement(By.className("avatar"));
	}

	public void hoverAvatar() {
		action.moveToElement(getAvatar()).build().perform();
	}

	public WebElement getUploadImgBtn() {
		return this.driver.findElement(By.xpath("//*[@title=\"Uplaod\"]"));
	}
	
	public WebElement getUploadFile() {
		return driver.findElement(By.xpath("//input[@type=\"file\"]"));
	}

	public WebElement getRemoveImgBtn() {
		return this.getAvatar().findElement(By.className("remove"));
	}

	public void setProfileImg(String imgUrl) throws InterruptedException, AWTException {

		WebElement btnUpload = this.getUploadImgBtn();
		this.hoverAvatar();
		Thread.sleep(500);
		btnUpload.click();		
		this.getUploadFile().sendKeys(imgUrl);	

		Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ESCAPE);
	    robot.keyRelease(KeyEvent.VK_ESCAPE);

		Thread.sleep(500);
	}

	public void deleteProfileImg() throws InterruptedException {
		this.hoverAvatar();
		Thread.sleep(500);
		this.getRemoveImgBtn().click();
		Thread.sleep(500);
	}

	public void updateProfileInfo(String firstName, 
								  String lastName, 
								  String address, 
								  String phoneNo, 
								  String zipCode,			
								  String country, 
								  String state, 
								  String city) throws InterruptedException {
		
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		this.getPhone().clear();
		this.getPhone().sendKeys(phoneNo);
		this.getZipCode().clear();
		this.getZipCode().sendKeys(zipCode);
		this.getCountry().selectByVisibleText(country);
		Thread.sleep(500);
		this.getState().selectByVisibleText(state);
		Thread.sleep(500);
		this.getCity().selectByVisibleText(city);
		Thread.sleep(500);
		this.getSaveProfileBtn().submit();
		Thread.sleep(1000);

	}

}
