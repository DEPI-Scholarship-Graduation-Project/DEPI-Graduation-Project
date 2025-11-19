package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By emailBox = By.xpath("//input[@id='Email']");
    private By passwordBox = By.xpath("//input[@id='Password']");
    private By rememberMeCheckBox = By.xpath("//input[@id='RememberMe']");
    private By forgotPasswordLink = By.linkText("Forgot password?");
    private By loginButton = By.xpath("//input[@value='Log in']");

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

    public HomePage clickOnLoginButton()
    {
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public PasswordRecoveryPage clickOnForgotPasswordLink()
    {
        driver.findElement(forgotPasswordLink).click();
        return new PasswordRecoveryPage(driver);
    }
}
