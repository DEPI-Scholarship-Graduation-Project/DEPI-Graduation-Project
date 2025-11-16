package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementWaitUtility {
    WebDriver driver;

    public ElementWaitUtility(WebDriver driver){
        this.driver = driver;
    }

    public WebElement waitForElementToBeVisible(By element, int waitSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitForElementToBeClickable(By element, int waitSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitForElementToBeSelected(By element, int waitSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        return wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public Boolean waitForElementToBeInvisible(By element, int waitSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void click(By locator, int waitSeconds){
        waitForElementToBeClickable(locator, waitSeconds).click();
    }

    public void enterText(By locator, int waitSeconds, String text){
        waitForElementToBeVisible(locator, waitSeconds).sendKeys(text);
    }

    public void selectOptionFromDropDown(By locator, int waitSeconds, String visibleText) {
        WebElement dropdown = waitForElementToBeVisible(locator, waitSeconds);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }
}
