package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;


import utils.ScreenshotUtils;
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
		ScreenshotUtils.captureScreenshot(driver, "Login_Test");
		Assert.assertTrue(dashboardPage.isDashboardDisplayed(),"Dashboard page is not displayed");
//		Assert.assertTrue(false,"Dashboard page is not displayed");
	}

}
