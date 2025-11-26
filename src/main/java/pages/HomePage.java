package pages;

import components.HeaderBar;
import components.SideBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.ElementWaitUtility;

public class HomePage {
    WebDriver driver;
    private ElementWaitUtility elementWaitUtility;
    private SideBar sideBar;
    private HeaderBar headerBar;


    private final By welcomeMsg = By.cssSelector(".topic-html-content-title");
    private final By registerLink = By.cssSelector(".header-links a[href='/register']");



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
    // verify if the page title is displayed
    public boolean verifyIfPageTitleDisplayed() {
        return driver.findElement(welcomeMsg).isDisplayed();
    }

    public RegisterPage clickOnRegisterLink() {
        elementWaitUtility.click(registerLink);
        return new RegisterPage(driver);
    }

}