package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputersPage {
    WebDriver driver;
    public ComputersPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By computersCategoryPageTitle = By.xpath("//h1[contains(text(), \"Computers\")]");

    public String getPageTitleElement() {
        return driver.findElement(computersCategoryPageTitle).getText();
    }



}
