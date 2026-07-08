package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class BasePage {
	
	protected WebDriver driver;
	protected WaitUtils waitUtils;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.waitUtils = new WaitUtils(driver);
	}
	
	protected void type(By locator,String name) {
		waitUtils.waitforVisibility(locator).sendKeys(name);
	}
	
	protected void click(By locator) {
		waitUtils.waitforClickable(locator).click();
	}
	
	protected boolean displayed(By locator) {
		return waitUtils.waitforVisibility(locator).isDisplayed();
	}

}
