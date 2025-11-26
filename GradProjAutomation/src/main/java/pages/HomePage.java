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
    private final By registerLink = By.linkText("Register");
    private final By loginLink = By.linkText("Log in");
    //Only in Logged-in Mode
    private final By myAccountLink = By.xpath("//a[@class='account']"); // use with care as there are two elements with this xpath
    private final By logoutLink = By.linkText("Log out");
    //Other Locators can be added here

    //Actions
    public RegisterPage clickOnRegisterLink()
    {
        driver.findElement(registerLink).click();
        return new RegisterPage(driver);
    }

    public LoginPage clickOnLoginLink()
    {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public String getLoggedInEmail()
    {
        return driver.findElement(myAccountLink).getText();
    }

    public void clickOnLogoutLink()
    {
        driver.findElement(logoutLink).click();
    }
}