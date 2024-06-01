package CucumberTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features= "F:\\SHIV NEWSCRIPTS\\CucumberRAProject\\src\\test\\java\\Features\\AddPlaceAPI.feature"
,glue = {"StepDefinition"}
,dryRun = true)

public class TestRunner extends AbstractTestNGCucumberTests
{
	//  ,tags = "@DeletePlace 
}
