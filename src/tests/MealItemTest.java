package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest{
	
	String url = this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo";
	String msgErrSelectLocation1 = "The Following Errors Occurred:";
	String msgErrSelectLocation2 ="Please Select Location";
	String msgAddedToCart = "Meal Added To Cart";
	String msgALoginFirst = "Please login first!";
	String msgAddedToFavorites = "Product has been added to your favorites.";
	String msgAllRemovedFromCart = "All meals removed from Cart successfully";
	String locationName = "City Center - Albany";	
	
//	@Test 
//	public void addMealToCartTest() throws InterruptedException {
//		
//		driver.get(url);
//		
//		locationPopupPage.getCloseBtn().click();
//		
//		mealPage.addToCart(3);
//		
//		String msg = notificationSystemPage.getAlertTxt();
//		Assert.assertTrue(msg.contains(msgErrSelectLocation1), " [ERROR] Unexpected add to cart message "); 
//		Assert.assertTrue(msg.contains(msgErrSelectLocation2), " [ERROR] Unexpected add to cart message "); 
//		notificationSystemPage.noAlertMsgWait();
//		
//		locationPopupPage.popUpLocation();
//		locationPopupPage.setLocation(locationName);
//	}
//	
//	@Test 
//	public void addMealToFavoriteTest () throws InterruptedException{
//		driver.get(url);
//		locationPopupPage.getCloseBtn().click();
//		
//		mealPage.addToFavorite();
//		
//		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgALoginFirst), " [ERROR] Unexpected add to favorites - login message "); 
//		notificationSystemPage.noAlertMsgWait();
//		
//		url = this.baseUrl + "/guest-user/loginform";
//		driver.get(url);
//		
//		loginPage.logIn(this.email, this.password);
//		notificationSystemPage.noAlertMsgWait();
//		
//		url = this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo";
//		driver.get(url);
//		
//		mealPage.addToFavorite();
//		
//		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgAddedToFavorites), " [ERROR] Unexpected add to favorites message "); 
//		notificationSystemPage.noAlertMsgWait();
//	}
	
	@Test
	public void clearCartTest() {
		url = this.baseUrl + "/meals";
		driver.get(url);
		
		
	}
	

	
}
