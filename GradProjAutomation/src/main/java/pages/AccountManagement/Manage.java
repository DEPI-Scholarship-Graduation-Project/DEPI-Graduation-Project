package pages.AccountManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Manage {
    public WebDriver driver;
    WebDriverWait wait;

    public Manage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By info = By.linkText("Customer info");
    private final By addresses = By.linkText("Addresses");
    private final By orders = By.linkText("Orders");
    private final By changePassword = By.linkText("Change password");

    private final By accountLink = By.xpath("//a[@class='account']");



    public Addresses navToAddresses() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addresses));
        driver.findElement(addresses).click();
        return  new Addresses(driver);
    }

    public void navToOrders() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orders));
        driver.findElement(orders).click();
    }
    public CustomerInfo navToInfo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(info));
        driver.findElement(info).click();
        return new  CustomerInfo(driver);
    }
    public ChangePassword navToChangePassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(changePassword));
        driver.findElement(changePassword).click();
        return  new ChangePassword(driver);
    }
}
