package pages;

import components.HeaderBar;
import components.SideBar;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    private SideBar sideBar;
    private HeaderBar headerBar;


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        sideBar = new SideBar(driver);
        headerBar = new HeaderBar(driver);
    }

    public SideBar getSideBar() {
        return sideBar;
    }
    public HeaderBar getHederBar() {
        return headerBar;
    }

}