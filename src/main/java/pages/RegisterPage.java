package pages;

import components.HeaderBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.ConfigReader;
import utility.ElementWaitUtility;

import java.util.*;


public class RegisterPage {
    private WebDriver driver;
    HeaderBar headerBar;
    private ElementWaitUtility elementWaitUtility;

    private final Logger logger = LoggerFactory.getLogger(RegisterPage.class);

    private By pageTitle = By.className("page-title") ;

    private By messageError = By.cssSelector(".validation-summary-errors li") ;

    private Map<String, By> formElements = new HashMap<String, By>() {{
        put("male", By.id("gender-male"));
        put("female", By.id("gender-female"));
        put("firstName", By.id("FirstName"));
        put("lastName", By.id("LastName"));
        put("email", By.id("Email"));
        put("password", By.id("Password"));
        put("confirmPassword", By.id("ConfirmPassword"));
        put("submit", By.xpath("//input[@value='Register']"));
    }};

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        headerBar = new HeaderBar(driver);
        elementWaitUtility = new ElementWaitUtility(driver);
    }

    public String getPageTitleElement() {

        return driver.findElement(pageTitle).getText();
    }

    public String getMessageErrorText(){
        return elementWaitUtility.waitForElementToBeVisible(messageError).getText() ;
    }

    public void enterGender(String gender) {

        elementWaitUtility.click(formElements.get(gender));
    }

    public void enterFirstName(String firstName) {
        elementWaitUtility.enterText(formElements.get("firstName"), firstName);
    }

    public void enterLastName(String lastName) {

        elementWaitUtility.enterText(formElements.get("lastName"), lastName);
    }

    public void enterEmail(String email) {

        elementWaitUtility.enterText(formElements.get("email"), email);
    }

    public void enterPassword(String password) {

        elementWaitUtility.enterText(formElements.get("password"), password);
    }

    public void enterConfirmPassword(String confirmPassword) {

        elementWaitUtility.enterText(formElements.get("confirmPassword"), confirmPassword);
    }

    public void enterRegisterFormData(Map<String, String> data){
        enterGender(data.get("gender"));
        enterFirstName(data.get("firstName"));
        enterLastName(data.get("lastName"));
        enterEmail(data.get("email"));
        enterPassword(data.get("password"));
        enterConfirmPassword(data.get("confirmPassword"));
    }

    public ConfirmRegister clickRegisterButton() {

        elementWaitUtility.click(formElements.get("submit"));
        return new ConfirmRegister(driver);
    }

    public HeaderBar getHederBar() {
        return headerBar;
    }
}

