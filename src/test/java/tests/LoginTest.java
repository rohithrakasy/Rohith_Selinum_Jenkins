package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;



import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginOrageHrmtest() {
		
		
		
		LoginPage loginpage= new LoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		
//		loginpage.login("Admin", "admin123");
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(dashboardPage.isDashboardDisplayed(),"Dashboard page is not displayed");
	}

}
