package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest {

	String url = this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo";
	String msgErrSelectLocation1 = "The Following Errors Occurred:";
	String msgErrSelectLocation2 = "Please Select Location";
	String msgAddedToCart = "Meal Added To Cart";
	String msgALoginFirst = "Please login first!";
	String msgAddedToFavorites = "Product has been added to your favorites.";
	String msgAllRemovedFromCart = "All meals removed from Cart successfully";
	String locationName = "City Center - Albany";

	@Test (priority = 1)
	public void addMealToCartTest() throws InterruptedException {
		
		driver.get(url);
		
		locationPopupPage.getCloseBtn().click();
		
		mealPage.addToCart(3);
		
		String msg = notificationSystemPage.getAlertTxt();
		Assert.assertTrue(msg.contains(msgErrSelectLocation1), " [ERROR] Unexpected add to cart message "); 
		Assert.assertTrue(msg.contains(msgErrSelectLocation2), " [ERROR] Unexpected add to cart message "); 
		notificationSystemPage.noAlertMsgWait();
		
		locationPopupPage.popUpLocation();
		locationPopupPage.setLocation(locationName);
		
		mealPage.addToCart(3);
		Assert.assertTrue(msg.contains(msgAddedToCart), " [ERROR] Unexpected add to cart message "); 
	
	}
	
	@Test (priority = 2)
	public void addMealToFavoriteTest () throws InterruptedException{
		driver.get(url);
		locationPopupPage.getCloseBtn().click();
		
		mealPage.addToFavorite();
		
		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgALoginFirst), " [ERROR] Unexpected add to favorites - login message "); 
		notificationSystemPage.noAlertMsgWait();
		
		url = this.baseUrl + "/guest-user/loginform";
		driver.get(url);
		
		loginPage.logIn(this.email, this.password);
		notificationSystemPage.noAlertMsgWait();
		
		url = this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo";
		driver.get(url);
		
		mealPage.addToFavorite();
		
		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgAddedToFavorites), " [ERROR] Unexpected add to favorites message "); 
		notificationSystemPage.noAlertMsgWait();
	}

	@Test (priority = 3)
	public void clearCartTest() throws IOException, InterruptedException {
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals");

		SoftAssert sa = new SoftAssert();

		url = this.baseUrl + "/meals";
		driver.get(url);
//		
		locationPopupPage.setLocation(locationName); 
//		Thread.sleep(7000); // By hand location setting, until I fix setLocation method
		Thread.sleep(1000);
		
		for (int i = 1; i <= 5; i++) {
			String mealUrl = sheet.getRow(i).getCell(0).getStringCellValue();
			int quantity = (int) sheet.getRow(i).getCell(1).getNumericCellValue();
			
			Thread.sleep(1000);
			driver.get(mealUrl);
			Thread.sleep(3000);
			mealPage.addToCart(quantity);
			Thread.sleep(300);
			sa.assertTrue(notificationSystemPage.getAlertTxt().contains(msgAddedToCart),
					" [ERROR] Unexpected add to cart message" + " for " + mealUrl);
			notificationSystemPage.noAlertMsgWait();
		}

		wb.close();
		sa.assertAll();

		cartSummaryPage.cartClearAll();

		Thread.sleep(200);

		Assert.assertTrue(notificationSystemPage.getAlertTxt().contains(msgAllRemovedFromCart),
				" [ERROR] Unexpected clear cart message ");
		notificationSystemPage.noAlertMsgWait();

	}

}
