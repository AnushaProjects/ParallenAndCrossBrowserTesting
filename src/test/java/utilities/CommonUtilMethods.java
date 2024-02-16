package utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivermanager.DriverManager;
import pageobjectmodel.GraphPage;

public class CommonUtilMethods {
	
	
	GraphPage graphpg=new GraphPage();
	//ConfigReader config=new ConfigReader();

	
	public void Login() throws IOException {
		graphpg.signin_link.click();
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(graphpg.username));
		graphpg.username.sendKeys(ConfigReader.username);
		graphpg.password.sendKeys(ConfigReader.password);
		graphpg.submit_btn.click();
		
	}
	public void launchURL() {
		System.out.println(ConfigReader.URL);
		DriverManager.getDriver().get(ConfigReader.URL);
		DriverManager.getDriver().manage().window().maximize();
		System.out.println("Launched the DSalgo website");
		
	}
}
