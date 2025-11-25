package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationCompletionPage {
    WebDriver driver;
    public RegistrationCompletionPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By completionMessage = By.cssSelector(".result");
    private final By continueButton = By.xpath("//input[@value='Continue']");

    //Actions
    public String getCompletionMessage() {
        return driver.findElement(completionMessage).getText();
    }

    public void clickOnContinueButton()
    {
        driver.findElement(continueButton).click();
    }
}
