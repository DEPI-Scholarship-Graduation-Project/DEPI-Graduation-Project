package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features/forgetpassword.feature",
        glue = "stepsdef",
        tags = "@HappyScenario or @NegativeScenario",
        plugin = {"pretty", "html:target/reports/ForgetPasswordReport.html"})
public class ForgetPasswordTestRunner extends AbstractTestNGCucumberTests {
}
