package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features/login.feature",
        glue = "stepsdef",
        tags = "@HappyScenario or @Regression",
        plugin = {"pretty", "html:target/reports/LoginReport.html"})
public class LoginTestsRunner extends AbstractTestNGCucumberTests {
}
