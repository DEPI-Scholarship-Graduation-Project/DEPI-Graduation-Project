package pages;

import components.HeaderBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.ElementWaitUtility;


public class ViewProductPage {
    WebDriver driver ;
    HeaderBar headerBar ;
    ElementWaitUtility elementWaitUtility ;


    private final By lastBreadcrumb = By.cssSelector(".breadcrumb li:last-child strong");
    private final By productTitle = By.cssSelector(".product-name h1");
    private final By quantityInput = By.cssSelector(".qty-input");
    private final By addToCartButton = By.cssSelector(".add-to-cart-button");
    // toast
    private final By toast = By.cssSelector("p.content");
    private final By toastCartLink = By.cssSelector("p.content a[href='/cart']");

    private final Logger logger = LoggerFactory.getLogger(ViewProductPage.class);


    public ViewProductPage(WebDriver driver) {
        this.driver = driver;
        headerBar = new HeaderBar(driver);
        elementWaitUtility = new ElementWaitUtility(driver);
    }

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    // create changeQuantity
    public void changeQuantity(int quantity) {
        driver.findElement(quantityInput).clear();
        elementWaitUtility.enterInt(quantityInput, quantity);
    }
    // click on addToCartButton
    public String clickOnAddToCartButton() {
        elementWaitUtility.click(addToCartButton);
        return elementWaitUtility.getText(productTitle) ;
    }

    public String getToastText() {
       return elementWaitUtility.getText(toast) ;
    }
    // inside the toast text there is an a tag, i want to get it to click
    public CartPage clickOnToastLink() {
        elementWaitUtility.click(toastCartLink);
        return new CartPage(driver);
    }
    // bool fun to check if toastCartLink visible
    public boolean isToastCartLinkVisible() {
        return elementWaitUtility.waitForElementToBeVisible(toastCartLink).isDisplayed();
    }



    public HeaderBar getHeaderBar() {
        return headerBar;
    }
}
