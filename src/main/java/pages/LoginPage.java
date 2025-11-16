package pages;

import components.HeaderBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.ElementWaitUtility;

import java.util.*;


public class LoginPage {
    private WebDriver driver;
    HeaderBar headerBar;
    private ElementWaitUtility elementWaitUtility;

    private final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private By pageTitle = By.className("page-title") ;
    private By messageError = By.cssSelector(".message-error span") ;
    private Map<String, By> formElements = new HashMap<String, By>() {{
        put("email", By.id("Email"));
        put("password", By.id("Password"));
        put("submit", By.cssSelector("input[type='submit']"));
    }};

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        headerBar = new HeaderBar(driver);
        elementWaitUtility = new ElementWaitUtility(driver);
    }

    public String getPageTitleElement() {

        return driver.findElement(pageTitle).getText();
    }

    public String getMessageErrorText(){
        return elementWaitUtility.waitForElementToBeVisible(messageError, 10).getText() ;
    }

    public void enterUserEmail(String email) {

        elementWaitUtility.enterText(formElements.get("email"), 3, email);
    }

    public void enterPassword(String pass) {

        elementWaitUtility.enterText(formElements.get("password"), 3, pass);
    }

    public HomePage clickLoginButton() {

        elementWaitUtility.click(formElements.get("submit"), 3);
        return new HomePage(driver);
    }

    public HeaderBar getHederBar() {
        return headerBar;
    }
}
