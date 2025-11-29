package pages.AccountManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Orders {

    public WebDriver driver;
    WebDriverWait wait;

    public Orders(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By addToCartBtn = By.cssSelector("input.button-2.product-box-add-to-cart-button");



    public void addToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
        driver.findElement(addToCartBtn).click();
    }

}
