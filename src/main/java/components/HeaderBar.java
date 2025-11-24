package components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import utility.ElementWaitUtility;

import java.time.Duration;

public class HeaderBar {
    private WebDriver driver;
    private ElementWaitUtility elementWaitUtility;

    private final By websiteLogoLink = By.cssSelector("img[alt='Tricentis Demo Web Shop']");
    private final By loginLink = By.linkText("Log in");
    private By logoutLink = By.linkText("Log out");
    private final By searchBox = By.xpath("//input[@value='Search store']");
    private final By searchButton = By.xpath("//input[@value='Search']");;

    public HeaderBar(WebDriver driver) {
        this.driver = driver;
        elementWaitUtility = new ElementWaitUtility(driver);
    }

    public boolean getWebsiteLogoElement(){

        return driver.findElement(websiteLogoLink).isDisplayed();
    }

    public HomePage clickOnWebsiteLogoLink() {

        elementWaitUtility.click(websiteLogoLink);
        return new HomePage(driver);
    }

    public LoginPage clickOnLoginLink() {

        elementWaitUtility.click(loginLink);
        return new LoginPage(driver);
    }
    public HomePage clickOnLogOutLink() {

        elementWaitUtility.click(logoutLink);
        return new HomePage(driver);
    }


    public SearchPage searchProduct(String productTitle) {
        elementWaitUtility.enterText(searchBox, productTitle);
        elementWaitUtility.click(searchButton);
        // if alert appears then success
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            // do nothing
        }

        return new SearchPage(driver);
    }

    public boolean isUserLoggedIn() {
        elementWaitUtility.waitForElementToBeVisible(logoutLink);
        return !driver.findElements(logoutLink).isEmpty();
    }

    public boolean isUserNotLoggedIn() {
        elementWaitUtility.waitForElementToBeVisible(loginLink);
        return !driver.findElements(loginLink).isEmpty();
    }


    public HomePage getWebsiteLogoutLink() {

        elementWaitUtility.click(logoutLink);
        return new HomePage(driver);
    }
}
