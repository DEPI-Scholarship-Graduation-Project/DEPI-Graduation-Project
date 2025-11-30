package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ThreadGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utility.ConfigReader;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected HomePage homePage;
    private final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setUp() {

        String browser = ConfigReader.get("browser").toLowerCase();
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
        WebDriver webDriver;

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
                webDriver = ThreadGuard.protect( new ChromeDriver(chromeOptions));
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
                webDriver = ThreadGuard.protect( new EdgeDriver(edgeOptions));
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
                webDriver = ThreadGuard.protect( new FirefoxDriver(firefoxOptions));
                break;

            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.set(webDriver);
        getDriver().manage().window().maximize();

        getDriver().get(ConfigReader.get("baseUrl"));
        homePage = new HomePage(getDriver());
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        driver.remove();
        logger.info("Driver quit for thread: " + Thread.currentThread().getId());
    }
}
