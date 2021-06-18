package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage{
	
	public Actions action; 
	
	public ProfilePage (WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		this.action= new Actions(driver);

	}
	
	private WebElement getProfileForm() {
		return this.driver.findElement(By.id("profileInfoFrmBlock"));
	}
	
	public WebElement getFirstName () {
		return this.getProfileForm().findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastName () {
		return this.getProfileForm().findElement(By.name("user_last_name"));
	}
		
	public WebElement getAddress () {
		return this.getProfileForm().findElement(By.name("user_address"));
	}
	
	public WebElement getPhone () {
		return this.getProfileForm().findElement(By.name("user_phone"));
	}
	
	public WebElement getZipCode () {
		return this.getProfileForm().findElement(By.name("user_zip"));
	}
	
	public Select getCountry () {
		Select country = new Select(this.getProfileForm().findElement(By.id("user_country_id")));
		return country;
	}
	
	public Select getState () {
		Select state = new Select(this.getProfileForm().findElement(By.id("user_state_id")));
		return state;
	}
	
	public Select getCity () {
		Select city = new Select(this.getProfileForm().findElement(By.id("user_city")));
		return city;
	}
	
	public WebElement getSaveProfileBtn () {
		return this.getProfileForm().findElement(By.name("btn_submit"));
	}
	
	private WebElement getPasswordForm() {
		return this.driver.findElement(By.id("changePwdFrm"));
	}	
	
	public WebElement getCurrentPassword () {
		return this.getPasswordForm().findElement(By.name("current_password"));
	}
	
	public WebElement getNewPassword () {
		return this.getPasswordForm().findElement(By.name("new_password"));
	}
	
	public WebElement getConfirmPassword () {
		return this.getPasswordForm().findElement(By.name("conf_new_password"));
	}
	
	public WebElement getSavePasswordBtn () {
		return this.getPasswordForm().findElement(By.name("btn_submit"));
	}
	
	private WebElement getAvatar() {
		return this.driver.findElement(By.className("avatar"));
	}	
	
	public void hoverAvatar() {
		WebElement avatarDiv = this.getAvatar();
		action.moveToElement(avatarDiv).build().perform();
	}
	
	public WebElement getUploadImgBtn() {
		this.hoverAvatar();
		return this.getAvatar().findElement(By.className("uploadFile-Js"));		
	}
	
	public WebElement getRemoveImgBtn() {
		this.hoverAvatar();
		return this.getAvatar().findElement(By.className("remove"));
	}
	
	public void setProfileImg(String imgUrl) {
		this.getUploadImgBtn().sendKeys(imgUrl);
	}
	
	public void deleteProfileImg() {
		this.js.executeScript("arguments[0].click();", this.getRemoveImgBtn());
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
		Thread.sleep(500);
		
	}
	
}
