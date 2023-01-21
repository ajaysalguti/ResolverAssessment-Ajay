package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*
        @author aSalguti
        monochrome - True will return more readable logs in console
        dryRun - will help in creation of missing stepDefinitions
        Perform assertion to check the button is enabled
           */
@CucumberOptions(features = {"src/test/java/features/"}, glue = {"stepDefinitions"},
        tags = "@allTests", monochrome = true, dryRun = false,
        plugin = {"pretty", "html:target/cucumber","json:target/cucumber.json"})

public class MainRunner extends AbstractTestNGCucumberTests {

}

