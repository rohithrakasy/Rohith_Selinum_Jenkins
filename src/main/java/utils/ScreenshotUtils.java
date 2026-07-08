package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.nio.file.Files;

public class ScreenshotUtils {
	
	public static String captureScreenshot(WebDriver driver,String testName) {
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmsss").format(new Date());
		
		String screenshotPath = "./screenshots/" + testName +"_"+ timestamp + ".png";
		
		File destination = new File(screenshotPath);
		
		destination.getParentFile().mkdirs();
		
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(source.toPath(), destination.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return screenshotPath;
	}

}
