package pages.AccountManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerInfo {


    public WebDriver driver;
    WebDriverWait wait;

    public CustomerInfo(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //locators
    private final By firstName =By.id("FirstName");
    private final By lastName = By.name("LastName");
    private final By gender = By.id("gender-female");
    private final By email = By.id("Email");
    private final By btn = By.name("save-info-button");

    // methods

    public void setFirstName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys("Nour");

    }

    public void  setLastName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        driver.findElement(firstName).sendKeys("Elsaid");

    }

    public void  setEmail(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(firstName).sendKeys("Nxxx@gmail.com");

    }



    public void setGender() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(gender));
        driver.findElement(firstName).click();
    }

    public void submit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn));
        driver.findElement(btn).click();
    }
}
