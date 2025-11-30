package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    public ProductPage(WebDriver driver) {
        this.driver=driver;
    }
    //locators
    private final By AddQty = By.cssSelector("input[class=\"qty-input\"]");
    private final By AddToCart = By.cssSelector("input[id=\"add-to-cart-button-13\"]");
    private final By AddTocartmessage = By.cssSelector("p[class=\"content\"]");
    private By Addyourreview = By.linkText("Add your review");
    private By clinonaddtocompare = By.cssSelector("input[value=\"Add to compare list\"]");

    //Actions
    public void InsertQuantity(int Quantity)
    {
        driver.findElement(AddQty).sendKeys(Integer.toString(Quantity));
    }
    public void ClickAddtoCart()
    {
        driver.findElement(AddToCart).click();
    }
    public String getaddtocartMessage()
    {
       wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AddTocartmessage)));
        return  driver.findElement(AddTocartmessage).getText();
    }
    public Reviewpage Clickonaddreview()
    {
        driver.findElement(Addyourreview).click();
        return new Reviewpage(driver);
    }
    public CompareProductsPage CLickonComparebutton()
    {
        driver.findElement(clinonaddtocompare).click();
        return new CompareProductsPage(driver);
    }
}
