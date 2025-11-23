package pages.AccountManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Addresses {
    public WebDriver driver;
    WebDriverWait wait;

    public Addresses(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By addBtn =By.className("button-1 add-address-button");
    private final By saveBtn =By.className("button-1 save-address-button");

    private final By firstName =By.id("Address_FirstName");
    private final By lastName = By.id("Address_LastName");
    private final By city = By.id("Address_City");
    private final By postal = By.id("Address_ZipPostalCode");
    private final By num = By.name("Address_PhoneNumber");
    private final By address = By.name("Address_Address1");
    private final By email = By.name("Address_Email");



    // methods

    public void setFirstName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys("Nour");

    }

    public void  setLastName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        driver.findElement(firstName).sendKeys("Elsaid");

    }

    public void  setEmail(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(firstName).sendKeys("Nxxx@gmail.com");

    }

    public void  setNum(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(num));
        driver.findElement(num).sendKeys("0111111111");

    }

    public void  setCity(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(city));
        driver.findElement(city).sendKeys("Cairo");

    }

    public void  setPostal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(postal));
        driver.findElement(postal).sendKeys("00000");

    }

    public void  setAdd(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(address));
        driver.findElement(address).sendKeys("Cairo");

    }

    public void newAdd() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addBtn));
        driver.findElement(addBtn).click();
    }
    public void save() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
        driver.findElement(saveBtn).click();
    }



}
