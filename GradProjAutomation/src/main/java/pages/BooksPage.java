package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksPage {
    WebDriver driver;
    public BooksPage(WebDriver driver) {
        this.driver=driver;
    }
    //locators
    private final By Selectproduct = By.cssSelector("a[title=\"Show details for Computing and Internet\"]");

    //Actions
    public ProductPage ClickOnProduct()
    {
        driver.findElement(Selectproduct).click();
        return new ProductPage(driver);
    }
}
