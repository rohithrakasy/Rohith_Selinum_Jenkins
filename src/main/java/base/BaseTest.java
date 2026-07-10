package base;

import java.io.ObjectInputFilter.Config;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import driver.DriverFactory;

import utils.ConfigReader;

public class BaseTest {

//	protected WebDriver driver;
	protected Properties prop;

//	public WebDriver getDriver() {
//		return driver;
//	}

	@BeforeMethod
	public void setup() {

		prop = ConfigReader.getProperties();
//		WebDriverManager.chromedriver().setup();
//		Replace these steps by driver Factory class
//		driver = new ChromeDriver();
		
		String browser = System.getProperty("browser",prop.getProperty("browser"));

		DriverFactory.initializeDriver(browser);

		DriverFactory.getDriver().manage().window().maximize();

		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		DriverFactory.getDriver().get(prop.getProperty("url"));
	}

	@AfterMethod
	public void teardown() {
		if (DriverFactory.getDriver() != null) {
			DriverFactory.quitDriver();
		}
	}

}
