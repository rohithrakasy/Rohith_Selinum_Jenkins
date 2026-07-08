package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import base.BaseTest;
import utils.WaitUtils;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	// Locators
	private By usernameTextBox = By.name("username");
	private By passwordtextBox = By.name("password");
	private By loginBtn = By.xpath("//button[@type='submit']");

	public void login(String username, String password) {

		type(usernameTextBox, username);
		type(passwordtextBox, password);
		click(loginBtn);

	}

}
