package base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    String baseUrl = "https://demowebshop.tricentis.com/";

    //private final Logger logger = LoggerFactory.getLogger(BaseTest.class) ;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() { driver.get(baseUrl); }

    @AfterClass
    public void closeBrowser() { driver.quit(); }

    protected void logoutBeforeTest()
    {
        try {
            homePage.clickOnLogoutLink();
            System.out.println("Optional element found and clicked.");
        } catch (NoSuchElementException e) {
            System.out.println("Optional element not present. Skipping action and continuing test.");
        }
    }

    protected void assertTestResult(String actualResult, String expectedResult)
    {
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}