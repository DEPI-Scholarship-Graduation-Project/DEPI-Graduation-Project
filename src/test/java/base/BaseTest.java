package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utility.ConfigReader;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage; // so that all test cases start from homePage


    private final Logger logger = LoggerFactory.getLogger(BaseTest.class) ;

    @BeforeClass
    public void beforeClass() {
        String browser = ConfigReader.get("browser") ;

        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser");
        }

        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        logger.info("Driver quit");
    }


}
