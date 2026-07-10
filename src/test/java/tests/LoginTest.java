package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;


import utils.ScreenshotUtils;
import base.BaseTest;
import driver.DriverFactory;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginOrageHrmtest() {
		
		
		
		LoginPage loginpage= new LoginPage();
		DashboardPage dashboardPage = new DashboardPage();
		
		
//		loginpage.login("Admin", "admin123");
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		ScreenshotUtils.captureScreenshot("Login_Test");
		Assert.assertTrue(dashboardPage.isDashboardDisplayed(),"Dashboard page is not displayed");
//		Assert.assertTrue(false,"Dashboard page is not displayed");
	}
	
	@Test
	public void verifyLoginPageTitle() {

	    String actualTitle = DriverFactory.getDriver().getTitle();

	    Assert.assertEquals(
	            actualTitle,
	            "OrangeHRM",
	            "Login page title is incorrect"
	    );
	}

}
