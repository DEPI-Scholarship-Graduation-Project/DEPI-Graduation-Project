package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class HeaderBar {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By websiteLogoLink = By.cssSelector("img[alt='Tricentis Demo Web Shop']");

    private final By loginLink = By.linkText("Log in");

    public HeaderBar(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getWebsiteLogoElement(){

        return driver.findElement(websiteLogoLink).isDisplayed();
    }

    public HomePage clickOnWebsiteLogoLink() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(websiteLogoLink)));

        driver.findElement(websiteLogoLink).click();
        return new HomePage(driver);
    }

    public LoginPage clickOnLoginLink() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginLink)));

        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

}
