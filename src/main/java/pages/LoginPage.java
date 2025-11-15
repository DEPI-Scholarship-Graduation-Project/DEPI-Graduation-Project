package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.ElementWaitUtility;


public class LoginPage {
    private WebDriver driver;
    private ElementWaitUtility elementWaitUtility;

    private final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private By pageTitle = By.className("page-title") ;
    private By username = By.id("Email");
    private By password = By.id("Password");
    private By loginButton = By.cssSelector("input[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementWaitUtility = new ElementWaitUtility(driver);
    }

    public String getPageTitleElement() {
        return driver.findElement(pageTitle).getText();
    }

    public void enterUserEmail(String email) {
        elementWaitUtility.enterText(username, 3, email);
    }

    public void enterPassword(String pass) {
        elementWaitUtility.enterText(password, 3, pass);
    }

    public HomePage clickLoginButton() {
        elementWaitUtility.click(loginButton, 3);
        return new HomePage(driver);
    }
}
