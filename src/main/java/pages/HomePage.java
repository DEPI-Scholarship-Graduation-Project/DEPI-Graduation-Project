package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Locators with private access
    private final By websiteLogo = By.cssSelector("img[alt='Tricentis Demo Web Shop']");
    private final By loginLink = By.linkText("Log in");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    // Actions
    public boolean getWebsiteLogoElement() {
        return driver.findElement(websiteLogo).isDisplayed();
    }

    public LoginPage clickOnLoginLink() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }


}