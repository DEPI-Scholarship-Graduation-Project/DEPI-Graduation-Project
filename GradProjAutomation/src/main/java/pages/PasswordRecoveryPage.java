package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    WebDriver driver;
    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By emailBox = By.xpath("//input[@id='Email']");
    private By recoverButton = By.xpath("//input[@value='Recover']");
    private By resultMessage = By.cssSelector(".result");

    //Actions
    public void insertEmail(String email)
    {
        driver.findElement(emailBox).sendKeys(email);
    }
    public void clickOnRecoverButton()
    {
        driver.findElement(recoverButton).click();
    }
    public String getResultMessage()
    {
        return driver.findElement(resultMessage).getText();
    }
}
