package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features/",glue = "stepDefinitions",plugin = {"json:target/cucumber.json"},dryRun = false)
public class TestRunner {

}
