package stepdefinition;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import drivermanager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.GraphPage;
import utilities.CommonUtilMethods;

public class DSGraphStepDefinition {
	
	
	GraphPage graphpg=new GraphPage();
	CommonUtilMethods commonUtil= new CommonUtilMethods();
	WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));
	JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
	Actions action =new Actions(DriverManager.getDriver());
	
	
	
	@When("The user clicks on Graph Get Started button")
	public void user_clicks_on_graph_get_started_button() {
		wait.until(ExpectedConditions.visibilityOf(graphpg.graph_getStarted));
		Assert.assertEquals(true, graphpg.graph_getStarted.isDisplayed());
		Assert.assertEquals(graphpg.graph_getStarted.getText(),"Get Started");
		graphpg.graph_getStarted.click();
		 
	}

	@Given("The user is in the Home page after logged in")
	public void the_user_is_in_the_home_page_after_logged_in() throws IOException {
	
		wait.until(ExpectedConditions.visibilityOf(graphpg.signin_link));
		commonUtil.Login();
		wait.until(ExpectedConditions.visibilityOf(graphpg.signout_link));
	}

	@Then("The user should be directed to {string} Page")
	public void the_user_should_be_directed_to_page(String new_page) {
	if(new_page.equals("Graph")) {
		wait.until(ExpectedConditions.visibilityOf(graphpg.Graph_page));
		System.out.println("User directed to Graph Page");
	}
	
	//Graph
		else if (new_page.equals("GraphIntro")) {
			wait.until(ExpectedConditions.visibilityOf(graphpg.commonxpathtext("Graph")));
			js.executeScript("window.scrollBy(0,250)", "");
			System.out.println("User directed to Graph Page");
			
		}
		else if (new_page.equals("Graph Representations")) {
			wait.until(ExpectedConditions.visibilityOf(graphpg.commonxpathtext("Graph Representations")));
			js.executeScript("window.scrollBy(0,250)", "");
			System.out.println("User directed to Graph Representations Page");
			
		}
}

	@When("The user clicks {string} link")
	public void the_user_clicks_link(String common_link) {
		if (common_link.equals("Graph")) {
	    	
			graphpg.commonxpathclick("graph");
			
		}
	    else if (common_link.equals("Graph Representations")) {
		
	    	graphpg.commonxpathclick("graph-representations");
			
		}
}

	//common
	@When("The user clicks {string} button")
	public void the_user_clicks_button(String try_button) {
		wait.until(ExpectedConditions.visibilityOf(graphpg.tryHere_button));
		Assert.assertEquals(graphpg.tryHere_button.getTagName(), "a");
		graphpg.tryHere_button.click();
		
	}

	//common
	@Then("The user should be redirected to a page having an tryEditor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
		wait.until(ExpectedConditions.visibilityOf(graphpg.run_button));
		if(graphpg.run_button.isDisplayed()) {
		System.out.println("tryEditor with a Run button is displayed");
		
		}
		else {
			System.out.println("tryEditor with a Run button is not displayed");
		}

	}
	@When("The user enters Wrong Python code in the tryEditor and clicks on Run button")
	public void the_user_enters_wrong_input_in_the_try_editor_and_clicks_on_run_button() {
		wait.until(ExpectedConditions.visibilityOf(graphpg.Texteditor));
		System.out.println("User directed to TextEditor Page");
		
		
		graphpg.Texteditor.click();
		
		action.sendKeys("pri('Hello')").build().perform();
		
		graphpg.run_button.click();
	}

	@Then("It throws an Alert")
	public void it_throws_an_alert() {
	   try {
		   wait.until(ExpectedConditions.alertIsPresent());
			
			System.out.println("Python code is incorrect---Enter Correctly");
			
			Alert alert=DriverManager.getDriver().switchTo().alert();
			alert.accept();
			
	} catch (Exception e) {
		
	}
	}

	@When("The user enters Valid Python code in the tryEditor and clicks on Run button")
	public void the_user_enters_valid_input_in_the_try_editor_and_clicks_on_run_button() {
		graphpg.Texteditor1.click();
		
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
		action.sendKeys("print('Hello')").build().perform();
		//testData.usingExcelSheetForTestData();
		graphpg.run_button.click();
		
	}

	@Then("The Output displays in Console")
	public void the_output_displays_in_console() {
		
		System.out.println("The output is :" +graphpg.output.getText());
		System.out.println("The output is :" +graphpg.output.getText());
		Assert.assertTrue(graphpg.output.getText().contains("Hello"));
		
	}
	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_page(String string) {
		String practice_page=DriverManager.getDriver().getCurrentUrl();
		Assert.assertTrue(practice_page.contains("practice"));
		System.out.println("In Practice Question Page - "+practice_page);

	}
	@When("The user clicks on the {string}")
	public void the_user_clicks_on_the(String link) {
		DriverManager.getDriver().navigate().back();
		Assert.assertEquals(true,graphpg.signout_link.isDisplayed());
		graphpg.signout_link.click();
		System.out.println("User clicked on signout");
	}



	@When("The user clicks Graph Practice Questions link")
	public void the_user_clicks_graph_practice_questions_link() {
		Assert.assertEquals(true,graphpg.graphPractice.isDisplayed());
		graphpg.graphPractice.click();
	  
	}
	
}
