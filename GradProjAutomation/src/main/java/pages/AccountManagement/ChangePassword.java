package pages.AccountManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangePassword {

    public WebDriver driver;
    WebDriverWait wait;

    public ChangePassword(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By oldPassword = By.id("OldPassword");
    private final By newPassword = By.id("NewPassword");
    private final By confirmNewPassword = By.id("ConfirmNewPassword");
    private final By btn = By.name("button-1 change-password-button");

    // methods

    public void setOldPassword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(oldPassword));
        driver.findElement(oldPassword).sendKeys("Nour");

    }

    public void  setLastName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(newPassword));
        driver.findElement(newPassword).sendKeys("Elsaid");

    }

    public void  setConfirm(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmNewPassword));
        driver.findElement(confirmNewPassword).sendKeys("Nxxx@gmail.com");

    }



    public void submit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn));
        driver.findElement(btn).click();
    }
}
