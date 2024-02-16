package drivermanager;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;

public class DriverManager {
	
	public static ChromeOptions co=new ChromeOptions();
	public static EdgeOptions ed=new EdgeOptions();
	private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();	
	
	public static void launchBrowser(@Optional("chrome") String browser) {
		// TODO Auto-generated method stub
		
		System.out.println(browser);
		
		if(browser.equalsIgnoreCase("chrome")) {	
			co.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver.set(new ChromeDriver(co));
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			ed.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver.set(new EdgeDriver(ed));	
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			
			driver.set(new FirefoxDriver());	
		}		
	
	}	
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
}
