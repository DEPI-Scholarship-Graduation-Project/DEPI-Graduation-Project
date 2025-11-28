package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By emailBox = By.xpath("//input[@id='Email']");
    private final By passwordBox = By.xpath("//input[@id='Password']");
    private final By rememberMeCheckBox = By.xpath("//input[@id='RememberMe']");
    private final By forgotPasswordLink = By.linkText("Forgot password?");
    private final By loginButton = By.xpath("//input[@value='Log in']");
    private final By invalidEmailFormatMessage = By.xpath("//span[@class='field-validation-error']");
    private final By failedLoginErrorMessage = By.xpath("//div[@class='validation-summary-errors']");

    //Actions
    public void insertEmail(String email)
    {
        driver.findElement(emailBox).sendKeys(email);
    }

    public void insertPassword(String password)
    {
        driver.findElement(passwordBox).sendKeys(password);
    }

    public void checkRememberMeBox()
    {
        driver.findElement(rememberMeCheckBox).click();
    }

    public void clickOnLoginButton()
    {
        driver.findElement(loginButton).click();
    }

    public PasswordRecoveryPage clickOnForgotPasswordLink()
    {
        driver.findElement(forgotPasswordLink).click();
        return new PasswordRecoveryPage(driver);
    }

    public String getInvalidEmailFormatMessage()
    {
        return driver.findElement(invalidEmailFormatMessage).getText();
    }

    public String getFailedLoginErrorMessage() {
        return driver.findElement(failedLoginErrorMessage).getText();
    }
}
