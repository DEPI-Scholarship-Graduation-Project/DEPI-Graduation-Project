package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import utility.ElementWaitUtility;

import java.time.Duration;

public class HeaderBar {
    private WebDriver driver;
    private ElementWaitUtility elementWaitUtility;

    private final By websiteLogoLink = By.cssSelector("img[alt='Tricentis Demo Web Shop']");

    private final By loginLink = By.linkText("Log in");

    private By logoutLink = By.linkText("Log out");

    public HeaderBar(WebDriver driver) {
        this.driver = driver;
        elementWaitUtility = new ElementWaitUtility(driver);
    }

    public boolean getWebsiteLogoElement(){

        return driver.findElement(websiteLogoLink).isDisplayed();
    }

    public HomePage clickOnWebsiteLogoLink() {

        elementWaitUtility.click(websiteLogoLink, 10);
        return new HomePage(driver);
    }

    public LoginPage clickOnLoginLink() {

        elementWaitUtility.click(loginLink, 10);
        return new LoginPage(driver);
    }


    public boolean isUserLoggedIn() {
        elementWaitUtility.waitForElementToBeVisible(logoutLink, 3);
        return !driver.findElements(logoutLink).isEmpty();
    }

    public HomePage getWebsiteLogoutLink() {

        elementWaitUtility.click(logoutLink, 10);
        return new HomePage(driver);
    }
}
