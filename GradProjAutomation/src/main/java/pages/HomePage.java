package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    //Only in Guest Mode
    private By registerLink = By.linkText("Register");
    private By loginLink = By.linkText("Log in");
    //Only in Logged-in Mode
    //Other Locators can be added here

    //Actions
    public RegisterPage clickOnRegisterLink()
    {
        driver.findElement(registerLink).click();
        return new RegisterPage(driver);
    }

    public LoginPage clickOnLoginPage()
    {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

}