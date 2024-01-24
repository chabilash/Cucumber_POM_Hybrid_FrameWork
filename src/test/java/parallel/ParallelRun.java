package parallel;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin           = {"pretty" , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		                    "timeline:test-output-thread/","rerun:target/failedrerun.txt"},
		monochrome       = true,
		glue             = {"parallel"},
		features         = {"src/test/resources/parallel/LoginPage.feature"}		
		
		)

public class ParallelRun extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
