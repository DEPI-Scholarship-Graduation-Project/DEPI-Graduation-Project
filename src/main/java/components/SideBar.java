package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ComputersPage;


public class SideBar {
    private WebDriver driver;
    private final By computersSideLink = By.xpath("//div[@class='listbox']//a[contains(@href, '/computers')]");

    public SideBar(WebDriver driver) {
        this.driver = driver;
    }
    public ComputersPage clickOnComputersSideLink(){
        driver.findElement(computersSideLink).click();
        return new ComputersPage(driver);
    }
}
