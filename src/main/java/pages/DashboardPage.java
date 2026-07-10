package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utils.WaitUtils;

public class DashboardPage extends BasePage {

	

	private By headerText = By.xpath("//h6[text()='Dashboard']");

	public DashboardPage() {
		super();
	}

	public boolean isDashboardDisplayed() {
		
//		return driver.findElement(headerText).isDisplayed();
		
//		return waitUtils.waitforVisibility(headerText).isDisplayed();
		
		return displayed(headerText);

	}

}
