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
    private final By changeBtn = By.cssSelector(".button-1.change-password-button");

    private final By errorOld= By.xpath("//*[text()='Old password is required.']");
    private final By errorNew= By.xpath("//*[text()='New password is required.']");
    private final By errorConfirm= By.xpath("//*[text()='Password is required.']");
    private final By errorLess= By.xpath("//*[text()='The password should have at least 6 characters.']");
    private final By errorWrongPass= By.cssSelector("div.validation-summary-errors ul li");
    private final By errorMismatching= By.xpath("//*[text()='The new password and confirmation password do not match.']");


    // methods

    public void setOldPassword(String old){
        wait.until(ExpectedConditions.visibilityOfElementLocated(oldPassword));
        driver.findElement(oldPassword).sendKeys(old);

    }

    public void setNewPassword(String newPass){
        wait.until(ExpectedConditions.visibilityOfElementLocated(newPassword));
        driver.findElement(newPassword).sendKeys(newPass);

    }

    public void setConfirm(String confirm){
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmNewPassword));
        driver.findElement(confirmNewPassword).sendKeys(confirm);

    }



    public void submit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(changeBtn));
        driver.findElement(changeBtn).click();
    }

    public String getErrorMsg(String field) {
        switch (field){
            case "O":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorOld));
                return driver.findElement(errorOld).getText();


            case "N":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorNew));
                return driver.findElement(errorNew).getText();

            case "C":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorConfirm));
                return driver.findElement(errorConfirm).getText();

            case "M":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorMismatching));
                return driver.findElement(errorMismatching).getText();
            case "L":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorLess));
                return driver.findElement(errorLess).getText();
            case "W":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorWrongPass));
                return driver.findElement(errorWrongPass).getText();

        }
        return  "";

    }

}
