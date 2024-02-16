package hooks;

import drivermanager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageobjectmodel.GraphPage;
import utilities.CommonUtilMethods;
import utilities.ConfigReader;

public class Hooks {

	GraphPage graphpg=new GraphPage();
	CommonUtilMethods commonUtil= new CommonUtilMethods(); 
	ConfigReader config = new ConfigReader();
	
	@Before
	public void beforeScenerio() throws Throwable {
		System.out.println("inside hooks");
		config.loadProperties();
		String browser = ConfigReader.getBrowserType();
		DriverManager.launchBrowser(browser);
		ConfigReader.initElements();
		commonUtil.launchURL();	
	}
	
	@After
	public void driverClose() {
		
		if (DriverManager.getDriver() != null) {
			DriverManager.getDriver().quit();
		}
		
	}
}
