package pages;

import org.openqa.selenium.WebDriver;

public class CompareProductsPage {
    WebDriver driver;
    public CompareProductsPage(WebDriver driver) {
        this.driver=driver;
    }

    public String Geturl()
    {
       return driver.getCurrentUrl();
    }
}
