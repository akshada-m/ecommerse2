package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\features\\Scenario2.feature"
		,glue={"StepDefinitions"},
		stepNotifications = true,
		plugin = {"pretty","html:target/htmlReport.html"}
		//dryRun=true
		)
public class Runner {

}
