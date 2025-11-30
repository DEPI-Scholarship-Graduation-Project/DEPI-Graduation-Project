package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationCompletionPage {
    WebDriver driver;
    public RegistrationCompletionPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By completionMessage = By.cssSelector(".result");
    private By continueButton = By.xpath("//input[@value='Continue']");

    //Actions
    public String getCompletionMessage()
    {
        return driver.findElement(completionMessage).getText();
    }
    public HomePage clickOnContinueButton()
    {
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }
}
