package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private By pageTitle = By.className("page-title") ;
    private By username = By.id("Email");
    private By password = By.id("Password");
    private By loginButton = By.cssSelector("input[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitleElement() {
        return driver.findElement(pageTitle).getText();
    }

    public void enterUserName(String name) {
        driver.findElement(username).sendKeys(name);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public HomePage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
