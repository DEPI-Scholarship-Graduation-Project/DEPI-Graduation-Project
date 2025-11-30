package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountManagement.Manage;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public HomePage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
    //Only in Guest Mode
    private final By registerLink = By.linkText("Register");
    private final By loginLink = By.linkText("Log in");
    //Only in Logged-in Mode
    private final By myAccountLink = By.xpath("//a[@class='account']");
    private final By logoutLink = By.linkText("Log out");
    private final By cart = By.className("cart-label");
    //Other Locators can be added here

    //Actions
    public RegisterPage clickOnRegisterLink()
    {
        driver.findElement(registerLink).click();
        return new RegisterPage(driver);
    }

    public LoginPage clickOnLoginLink()
    {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    public String getLoggedInEmail()
    {
        return driver.findElement(myAccountLink).getText();
    }

    public void clickOnLogoutLink()
    {
        driver.findElement(logoutLink).click();
    }

    public Manage navToAccountManagement() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountLink));
        driver.findElement(myAccountLink).click();

        return new Manage(driver);
    }

    public Checkout navToCart() {
              List<WebElement> items = driver.findElements(By.cssSelector(".item-box"));

            WebElement secondItem = items.get(1);

            secondItem.findElement(By.cssSelector("input[value='Add to cart']")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(cart));
            driver.findElement(cart).click();
            return new Checkout(driver);

    }
}