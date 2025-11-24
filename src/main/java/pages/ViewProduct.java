package pages;

import components.HeaderBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.ElementWaitUtility;

import java.util.ArrayList;
import java.util.List;


public class ViewProduct {
    WebDriver driver ;
    HeaderBar headerBar ;
    ElementWaitUtility elementWaitUtility ;


    private final By lastBreadcrumb = By.cssSelector(".breadcrumb li:last-child strong");

    private final Logger logger = LoggerFactory.getLogger(ViewProduct.class);


    public ViewProduct(WebDriver driver) {
        this.driver = driver;
        headerBar = new HeaderBar(driver);
        elementWaitUtility = new ElementWaitUtility(driver);
    }

    public String getLastBreadcrumbText() {
        return driver.findElement(lastBreadcrumb).getText();
    }


    public HeaderBar getHeaderBar() {
        return headerBar;
    }
}
