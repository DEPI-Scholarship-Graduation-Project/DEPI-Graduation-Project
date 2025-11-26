package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utility.ConfigReader;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    private final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void beforeClass() {

        String browser = ConfigReader.get("browser").toLowerCase();
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        switch (browser) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                Map<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("credentials_enable_service", false);
                chromePrefs.put("profile.password_manager_enabled", false);
                chromePrefs.put("profile.default_content_setting_values.notifications", 2);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                chromeOptions.addArguments("--disable-save-password-bubble");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-infobars");
                chromeOptions.addArguments("--remote-allow-origins=*");
                if (headless) chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                Map<String, Object> edgePrefs = new HashMap<>();
                edgePrefs.put("credentials_enable_service", false);
                edgePrefs.put("profile.password_manager_enabled", false);
                edgePrefs.put("profile.default_content_setting_values.notifications", 2);
                edgeOptions.setExperimentalOption("prefs", edgePrefs);
                edgeOptions.addArguments("--disable-save-password-bubble");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--window-size=1920,1080");
                if (headless) edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;

            case "firefox":
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("signon.rememberSignons", false);
                profile.setPreference("signon.autofillForms", false);
                profile.setPreference("signon.generation.enabled", false);
                profile.setPreference("signon.management.page.enabled", false);
                profile.setPreference("extensions.formautofill.available", "off");
                profile.setPreference("extensions.formautofill.creditCards.enabled", false);
                profile.setPreference("extensions.formautofill.addresses.enabled", false);
                profile.setPreference("dom.webnotifications.enabled", false);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(profile);
                if (headless) firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
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
//        driver.quit();
        logger.info("Driver quit");
    }
}
