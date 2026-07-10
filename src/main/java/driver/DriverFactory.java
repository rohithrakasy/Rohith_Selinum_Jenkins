package driver;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver initializeDriver(String browser) {

//		WebDriver driver;
		

		switch (browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());;
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			break;

		default:
			throw new RuntimeErrorException(null, "Invalid browser Name: " + browser);
		}

		return driver.get();
	}
	
	public static WebDriver getDriver() {
		
		return driver.get();
	}
	
	public static void quitDriver() {
		
		if(driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
	
	
	

}
