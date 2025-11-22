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
    int waitSeconds = Integer.parseInt(ConfigReader.get("explicitWait"));

    public ElementWaitUtility(WebDriver driver){
        this.driver = driver;
    }

    public WebElement waitForElementToBeVisible(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitForElementToBeClickable(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitForElementToBeSelected(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        return wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public Boolean waitForElementToBeInvisible(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void click(By locator){
        waitForElementToBeClickable(locator).click();
    }

    public void enterText(By locator, String text){
        waitForElementToBeVisible(locator).sendKeys(text);
    }

    public void selectOptionFromDropDown(By locator, String visibleText) {
        WebElement dropdown = waitForElementToBeVisible(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }
}
