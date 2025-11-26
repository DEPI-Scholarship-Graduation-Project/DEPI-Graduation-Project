
package pages;

import components.HeaderBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.ElementWaitUtility;

public class CompletePage {
    WebDriver driver;
    HeaderBar headerBar;
    ElementWaitUtility elementWaitUtility;

    private final Logger logger = LoggerFactory.getLogger(CompletePage.class);
    private final By pageTitle = By.cssSelector(".page-title h1");
    private final By successMsg = By.cssSelector("div.title strong"); // 5
    private final By orderLink = By.cssSelector(".details li a"); // to get number use href

    // inputs
    private final By continueButton = By.xpath("//input[@value='Continue']");



    public CompletePage(WebDriver driver) {
        this.driver = driver;
        headerBar = new HeaderBar(driver);
        elementWaitUtility = new ElementWaitUtility(driver);
    }



    // get the cart page title
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
    public WebElement getPageTitleElement() {
        return driver.findElement(pageTitle);
    }

    public String getOrderContainer() {

        String href = elementWaitUtility.getAttribute(orderLink, "href");
        return href;
    }
    // get success Msg
    public String getSuccessMsg() {
        return driver.findElement(successMsg).getText();
    }
    public WebElement getSuccessMsgElement() {
        return driver.findElement(successMsg);
    }
    public HomePage clickOnContinueButton() {
        elementWaitUtility.click(continueButton);
        return new HomePage(driver);
    }

    public String getOrderNumber(String orderLinkHref) {
        // href="x/y/z/orderdetails/2140795
        String[] parts = orderLinkHref.split("/");
        String lastPart = parts[parts.length - 1];

        return lastPart;
    }


    public OrderDetails clickOnOrderLink() {
        elementWaitUtility.click(orderLink);
        return new OrderDetails(driver);
    }

    public HeaderBar getHeaderBar() {
        return headerBar;
    }
}

