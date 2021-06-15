package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import pages.basePages;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resource/features",
    glue = "steps",
    plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
    monochrome = true,
    tags ="@Grid"
)

public class runner {
    @AfterClass
    public static void cleanDriver(){
        basePages.closeBrowser();

    }
}