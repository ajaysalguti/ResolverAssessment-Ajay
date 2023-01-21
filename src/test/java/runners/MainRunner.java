package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/java/features/"}, glue = {"stepDefinitions"},
          monochrome = true, dryRun = true,
        plugin = {"pretty", "html:target/cucumber"})
public class MainRunner extends AbstractTestNGCucumberTests {

}
