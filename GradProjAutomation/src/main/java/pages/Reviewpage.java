package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Reviewpage {
    WebDriver driver;
    public Reviewpage(WebDriver driver) {
        this.driver=driver;
    }
    //Locators
    private By titleforreview = By.cssSelector("input[class=\"review-title\"]");

    //Actions
    public boolean Titleforreviewdisabled()
    {
        driver.findElement(titleforreview);
        return false;
    }
}
