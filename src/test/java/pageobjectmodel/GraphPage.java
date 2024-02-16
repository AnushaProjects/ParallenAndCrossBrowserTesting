package pageobjectmodel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import drivermanager.DriverManager;


public class GraphPage {

	public GraphPage() {
	    PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@FindBy(xpath = "//h4[text()='Graph']")
	public WebElement Graph_page;
	@FindBy(xpath = "//a[@href='graph']")
	public WebElement graph_getStarted;
	@FindBy(xpath = "//a[@href='/graph/practice']")
	public WebElement graphPractice;
	
	

	@FindBy(xpath = "//a[@href='/tryEditor']")
	public  WebElement tryHere_button;
	@FindBy(xpath="//*[@class='input']")
	public  WebElement Texteditor;
	@FindBy(xpath="//pre[@role='presentation']")
	public  WebElement Texteditor1;
	@FindBy(xpath = "//button[text()='Run']")
	public  WebElement run_button;
	@FindBy(id = "output")
	public  WebElement output;
	
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	public WebElement DS_link;
	@FindBy(xpath = "//div[@class='dropdown-menu show']/a")
	public List<WebElement> ds_dropdown_entries;
	@FindBy(xpath = "//a[text()='Get Started']")
	public WebElement get_started;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	public WebElement alert_message;
	
	//Registration
	@FindBy(xpath = "//a[text()=' Register ']")
	public WebElement register_link;
	
	
	//Sign in
	@FindBy(xpath = "//a[text()='Sign in']")
	public WebElement signin_link;
	
	
	//Sign Out
	@FindBy(xpath = "//a[text()='Sign out']")
	public WebElement signout_link;
	
	@FindBy(name = "username")
	public WebElement username1;
	@FindBy(name = "password1")
	public WebElement password1;
	@FindBy(name = "password2")
	public WebElement password2;
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement submit_btn;
	//reuse alert_message
	
	//Login
	@FindBy(name = "username")
	public WebElement username;
	@FindBy(name = "password")
	public WebElement password;
	//reuse submit_btn
	//alert_message
	
	


	
	
	
	public void commonxpathclick(String pageLinks ) {
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));
		WebElement commonLink=DriverManager.getDriver().findElement(By.xpath("//a[@href='"+pageLinks+"']"));
		wait.until(ExpectedConditions.visibilityOf(commonLink));
		String linkValidation=commonLink.getTagName();
		Assert.assertEquals(linkValidation, "a");
		commonLink.click();
		
	}
	
	
	
	public WebElement commonxpathtext(String allpageCheck ) {
		WebElement pageCheck=DriverManager.getDriver().findElement(By.xpath("//p[text()='"+allpageCheck+"']"));
		return pageCheck;
	}
	
}
 	 	