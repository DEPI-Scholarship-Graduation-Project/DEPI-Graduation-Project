package pages;

import components.HeaderBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.ElementWaitUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CartPage {
    WebDriver driver;
    HeaderBar headerBar;
    ElementWaitUtility elementWaitUtility;

    private final Logger logger = LoggerFactory.getLogger(CartPage.class);
    private final By pageTitle = By.cssSelector(".page-title h1");
    private final By cartProductsTitle = By.cssSelector(".product .product-name");
    private final By cartProductsQty = By.cssSelector(".qty input");
    private final By cartItems = By.cssSelector(".cart-item-row"); // list of cart items
    private final By termsOfService = By.cssSelector("input#termsofservice");
    //button#checkout
    private final By checkoutButton = By.cssSelector("button#checkout");


    ///  Checkout page
    //input[@value='Continue'] // 5 inputs
    private final By continueButton = By.cssSelector("input[@value='Continue']"); // 5 inputs
     //input[@value='Confirm']
    private final By confirmButton = By.cssSelector("input[@value='Confirm']");



    public CartPage(WebDriver driver) {
        this.driver = driver;
        headerBar = new HeaderBar(driver);
        elementWaitUtility = new ElementWaitUtility(driver);
    }


    // get list of cart items title
    public List<String> getCartProductsTitle() {
        return driver.findElements(cartProductsTitle).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // sout cart items
    public void printCartProductsTitle() {
        List<String> cartProductsTitle = getCartProductsTitle();
        for (String cartProductTitle : cartProductsTitle) {
            logger.info(cartProductTitle);
        }
    }

    // get list of cart items title and quantity
    public List<Map<String, Integer>> getCartProductsInfo() {
        List<WebElement> items = driver.findElements(cartItems); // return cart items
        List<Map<String, Integer>> cartInfo = new ArrayList<>();

        for (WebElement item : items) {
            String title = item.findElement(cartProductsTitle).getText();
            int quantity = Integer.parseInt(item.findElement(cartProductsQty).getDomAttribute("value"));

            Map<String, Integer> map = new HashMap<>();
            map.put(title, quantity);

            cartInfo.add(map);
        }

        return cartInfo;
    }

    // bool fun to check if item inside list of items
    public boolean verifyIfFound(List<String> list, String item){

        return list.contains(item);
    }

    // get the cart page title
    public String getPageTitle() {

        return driver.findElement(pageTitle).getText();
    }

    public WebElement getPageTitleElement() {

        return driver.findElement(pageTitle);
    }

    // click on termsOfService
    public void clickOnTermsOfService() {

        elementWaitUtility.click(termsOfService);
    }

    public CheckoutPage clickOnCheckoutButton() {

        elementWaitUtility.click(checkoutButton);
        return new CheckoutPage(driver);
    }

    public HeaderBar getHeaderBar() {

        return headerBar;
    }
}
