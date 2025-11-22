package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
    private ChromeOptions options ;

    private final Logger logger = LoggerFactory.getLogger(BaseTest.class) ;

    @BeforeClass
    public void beforeClass() {
        String browser = ConfigReader.get("browser");

        switch (browser.toLowerCase()){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if(Boolean.parseBoolean(ConfigReader.get("headless"))){
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if(Boolean.parseBoolean(ConfigReader.get("headless"))){
                    edgeOptions.addArguments("--headless");
                }
                edgeOptions.addArguments("--window-size=1920,1080");
                driver = new EdgeDriver(edgeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if(Boolean.parseBoolean(ConfigReader.get("headless"))){
                    firefoxOptions.addArguments("--headless");
                }
                firefoxOptions.addArguments("--window-size=1920,1080");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }

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
