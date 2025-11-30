package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features/register.feature",
        glue = "stepsdef",
        tags = "@HappyScenario or @Regression",
        plugin = {"pretty", "html:target/reports/RegisterReport.html"})
public class RegisterTestRunner extends AbstractTestNGCucumberTests {
}
