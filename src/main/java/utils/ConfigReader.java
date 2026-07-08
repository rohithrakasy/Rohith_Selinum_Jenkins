package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties getProperties()  {
		
		Properties prop = new Properties();
		
		try {
			FileInputStream file = new FileInputStream("./src/test/resources/config.properties");
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}

}
