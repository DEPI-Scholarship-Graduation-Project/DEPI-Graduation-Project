package stepsdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Hooks {
    public static WebDriver driver;
    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void setup()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public void closeBrowser()
    {
        driver.quit();
    }

    public static WebDriver getDriver()
    {
        return driver;
    }

    public static void assertTestResult(String actualResult, String expectedResult)
    {
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
