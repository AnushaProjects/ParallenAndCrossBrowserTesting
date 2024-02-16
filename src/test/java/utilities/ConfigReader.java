package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import drivermanager.DriverManager;
import pageobjectmodel.GraphPage;

public class ConfigReader {

	public Properties prop;
	public static String URL;
	public static String username;
	public static String password;
	
	private static String browserType = null;
	
	
	public static String getBrowserType() throws Throwable {
		if (browserType != null)

			return browserType;

		else

			throw new RuntimeException("browser not specified in the testng.xml");
	}
	
	
	public static void setBrowserType(String browser) {
		browserType = browser;
	}


	public void loadProperties() {
		prop=new Properties();
		FileInputStream fis = null;
		try {
			fis=new FileInputStream("/Users/anushakarthick/NumpyNinja/ParallelAndCrossBrowserTesting/src/test/resources/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		URL=prop.getProperty("url");
		username=prop.getProperty("username");
		password=prop.getProperty("password");
	}
	
	
	public static void initElements() {
		PageFactory.initElements(DriverManager.getDriver(),GraphPage.class);
	}


	
}
