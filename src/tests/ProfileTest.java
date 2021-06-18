package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{
	
	@Test
	public void editProfileTest() throws InterruptedException {
		
		String url = this.baseUrl + "/guest-user/loginform";
		String msgSuccLogin = "Login Successfull";
		String msgSuccSetup = "Setup Successful";
		String msgSuccLogout = "Logout Successfull";
		
		String firstName = "Anne"; 
		String lastName = "Watson"; 
		String address = "Cambridge Road 22"; 
		String phoneNo = "125690"; 
		String zipCode = "333"; 
		String country = "United Kingdom"; 
		String state = "Bristol"; 
		String city = "Avon"; 
		
		driver.get(url);
		
		locationPopupPage.getCloseBtn().click();
		
		
		loginPage.logIn(this.email, this.password);
		
		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgSuccLogin), " [ERROR] Unexpected login message "); 
		notificationSystemPage.noAlertMsgWait();
		
		url = this.baseUrl + "//member/profile";
		driver.get(url);
		
		profilePage.updateProfileInfo(firstName, lastName, address, phoneNo, zipCode, country, state, city);

		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgSuccSetup), " [ERROR] Unexpected setup message "); 
		notificationSystemPage.noAlertMsgWait();
		
		authPage.logoutUser();
		
		
		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgSuccLogout), " [ERROR] Unexpected logout message "); 
		notificationSystemPage.noAlertMsgWait();
		
		
	}

}
