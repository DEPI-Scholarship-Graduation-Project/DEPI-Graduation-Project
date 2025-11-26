
package pages;

import components.HeaderBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.ElementWaitUtility;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage {
    WebDriver driver;
    HeaderBar headerBar;
    ElementWaitUtility elementWaitUtility;

    private final Logger logger = LoggerFactory.getLogger(CheckoutPage.class);
    private final By pageTitle = By.cssSelector(".page-title h1");
    private final By continueButton = By.cssSelector("li.active input[value='Continue']"); // 5 inputs
    private final By confirmButton = By.xpath("//input[@value='Confirm']");



    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        headerBar = new HeaderBar(driver);
        elementWaitUtility = new ElementWaitUtility(driver);
    }

    public void clickOnContinueButton() {
        for (int i = 0; i < 5; i++) {
            elementWaitUtility.click(continueButton);
            // needed to enhance
        }
    }


    // get the cart page title
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
    public WebElement getPageTitleElement() {
        return driver.findElement(pageTitle);
    }
    public CompletePage clickOnConfirmButton() {
        elementWaitUtility.click(confirmButton);
        return new CompletePage(driver);
    }

    public HeaderBar getHeaderBar() {
        return headerBar;
    }
}

