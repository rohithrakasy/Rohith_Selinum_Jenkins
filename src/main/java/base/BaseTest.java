package base;

import java.io.ObjectInputFilter.Config;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import driver.DriverFactory;

import utils.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;
	
	public WebDriver getDriver() {
		return driver;
	}

	@BeforeTest
	public void setup() {
		
		prop = ConfigReader.getProperties();
//		WebDriverManager.chromedriver().setup();
//		Replace these steps by driver Factory class
//		driver = new ChromeDriver();
		
		driver= DriverFactory.initializeDriver(prop.getProperty("browser"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
