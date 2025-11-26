package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        scrollTo(locator);
        waitForElementToBeClickable(locator).click();
    }

    public void enterText(By locator, String text){
        waitForElementToBeVisible(locator).sendKeys(text);
    }
    public void enterInt(By locator, int number){
        waitForElementToBeVisible(locator).sendKeys(String.valueOf(number));
    }
    // getText
    public String getText(By locator){
        return waitForElementToBeVisible(locator).getText();
    }
    public String getAttribute(By locator, String attr){
        return waitForElementToBeVisible(locator).getAttribute(attr);
    }

    public void selectOptionFromDropDown(By locator, String visibleText) {
        WebElement dropdown = waitForElementToBeVisible(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    public void scrollTo(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

}
