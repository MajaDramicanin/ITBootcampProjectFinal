package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BasicTest {
	protected String baseUrl;
	protected String email;
	protected String password;
	
public BasicTest (){
	this.baseUrl = "http://demo.yo-meals.com";
	this.email = "customer@dummyid.com";
	this.password = "12345678a";
}
	@BeforeMethod
	public void Configuration() {
		
	}
	
	@AfterMethod 
	public void Close() {
		
	}


}
