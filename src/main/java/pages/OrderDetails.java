
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

public class OrderDetails {
    WebDriver driver;
    HeaderBar headerBar;
    ElementWaitUtility elementWaitUtility;

    private final Logger logger = LoggerFactory.getLogger(OrderDetails.class);
    private final By pageTitle = By.cssSelector(".page-title h1"); // 5
    private final By orderNumber = By.cssSelector(".order-number strong");



    public OrderDetails(WebDriver driver) {
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


    // get order number
    public String getOrderNumber() {
        return driver.findElement(orderNumber).getText();
    }

    public HeaderBar getHeaderBar() {
        return headerBar;
    }
}

