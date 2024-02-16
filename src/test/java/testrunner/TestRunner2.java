package testrunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigReader;

@CucumberOptions(
		features ={"src/test/resources/features/"},//feature files path
		plugin = {"pretty","html:target/dsalgoproject.html"},//reporting purpose
		
				glue= {"stepdefinition","hooks"},//step definition and hooks class path
		monochrome = true
		)

public class TestRunner2 extends AbstractTestNGCucumberTests{
	
	@BeforeTest
    @Parameters({"Browser"})
    public void defineBrowser(String browser) throws Throwable {
        ConfigReader.setBrowserType(browser);
        System.out.println(browser);
    }
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {			
		return super.scenarios();
}
}

