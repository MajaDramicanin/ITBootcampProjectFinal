package tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{
	String url = this.baseUrl + "/guest-user/loginform";
	String msgSuccLogin = "Login Successfull";
	String msgSuccSetup = "Setup Successful";
	String msgSuccLogout = "Logout Successfull!";
	String msgSuccImgUpload = "Profile Image Uploaded Successfully";
	String msgSuccImgDelete = "Profile Image Deleted Successfully";		
	
	
	String firstName = "Anne"; 
	String lastName = "Watson"; 
	String address = "Cambridge Road 22"; 
	String phoneNo = "125690"; 
	String zipCode = "333"; 
	String country = "United Kingdom"; 
	String state = "Bristol"; 
	String city = "Avon";
	
	@Test (priority=1)
	public void editProfileTest() throws InterruptedException { 
		
		driver.get(url);
		
		locationPopupPage.getCloseBtn().click();
		
		
		loginPage.logIn(this.email, this.password);
		
		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgSuccLogin), " [ERROR] Unexpected login message "); 
		notificationSystemPage.noAlertMsgWait();
		
		url = this.baseUrl + "/member/profile";
		driver.get(url);
		
		profilePage.updateProfileInfo(firstName, lastName, address, phoneNo, zipCode, country, state, city);

		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgSuccSetup), " [ERROR] Unexpected setup message "); 
		notificationSystemPage.noAlertMsgWait();
		
		authPage.logoutUser();		
		
		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgSuccLogout), " [ERROR] Unexpected logout message "); 
		notificationSystemPage.noAlertMsgWait();		
	}
	
	@Test (priority=2)
	public void changeProfileImage() throws IOException, InterruptedException {
		String imgUrl = new File("img//image.png").getCanonicalPath();
		System.out.println(imgUrl);
		
		url = this.baseUrl + "/guest-user/loginform";		
		driver.get(url);
		
		locationPopupPage.getCloseBtn().click();
		
		
		loginPage.logIn(this.email, this.password);
		
		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgSuccLogin), " [ERROR] Unexpected login message "); 
		notificationSystemPage.noAlertMsgWait();
		
		url = this.baseUrl + "/member/profile";
		driver.get(url);
		
		profilePage.setProfileImg(imgUrl);
		
		Thread.sleep(3000);
		
//		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgSuccImgUpload), " [ERROR] Unexpected upload profile image message "); 
//		notificationSystemPage.noAlertMsgWait();
//		
//		profilePage.deleteProfileImg();
//		
//		notificationSystemPage.alertMsgWait();
//		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgSuccImgDelete), " [ERROR] Unexpected delete profile image message "); 
//		notificationSystemPage.noAlertMsgWait();
//
//		authPage.logoutUser();		
//		
//		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgSuccLogout), " [ERROR] Unexpected logout message "); 
//		notificationSystemPage.noAlertMsgWait();
	}

}
