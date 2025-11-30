package pages.AccountManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Addresses {
    public WebDriver driver;
    WebDriverWait wait;

    public Addresses(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By saveBtn = By.cssSelector(".button-1.save-address-button");
    private final By edtBtn = By.cssSelector(".button-2.edit-address-button");
    private final By deleteBtn = By.cssSelector(".button-2.delete-address-button");
    private final By address_item = By.cssSelector(".section.address-item");

    private final By firstName =By.id("Address_FirstName");
    private final By lastName = By.id("Address_LastName");
    private final By city = By.id("Address_City");
    private final By country = By.id("Address_CountryId");
    private final By postal = By.id("Address_ZipPostalCode");
    private final By num = By.id("Address_PhoneNumber");
    private final By address = By.id("Address_Address1");
    private final By email = By.id("Address_Email");

    private final By errorFname= By.xpath("//*[text()='First name is required.']");
    private final By errorLname= By.xpath("//*[text()='Last name is required.']");
    private final By errorEmail= By.xpath("//*[text()='Email is required.']");
    private final By errorPostal= By.xpath("//*[text()='Zip / postal code is required']");
    private final By errorCountry= By.xpath("//*[text()='Country is required.']");
    private final By errorPhone= By.xpath("//*[text()='Phone is required']");
    private final By errorCity= By.xpath("//*[text()='City is required']");
    private final By errorAdd= By.xpath("//*[text()='Street address is required']");
    private final By addressItems = By.cssSelector("div.section.address-item");



    // methods

    public void setFirstName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys(name);

    }

    public void  setLastName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        driver.findElement(lastName).sendKeys(name);

    }

    public void  setEmail(String e){
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(email).sendKeys(e);

    }

    public void  setNum(String phone){
        wait.until(ExpectedConditions.visibilityOfElementLocated(num));
        driver.findElement(num).sendKeys(phone);

    }

    public void  setCity(String c){
        wait.until(ExpectedConditions.visibilityOfElementLocated(city));
        driver.findElement(city).sendKeys(c);

    }

    public void setCountry(String c){
        WebElement countryDropdown = driver.findElement(country);

        Select select = new Select(countryDropdown);
        select.selectByVisibleText(c);


    }

    public void  setPostal(String pos){
        wait.until(ExpectedConditions.visibilityOfElementLocated(postal));
        driver.findElement(postal).sendKeys(pos);

    }

    public void  setAdd(String add){
        wait.until(ExpectedConditions.visibilityOfElementLocated(address));
        driver.findElement(address).sendKeys(add);

    }

    public void newAdd() {
        driver.findElement(By.cssSelector(".button-1.add-address-button")).click();
    }
    public void save() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
        driver.findElement(saveBtn).click();
    }

    public boolean addItemDisplayed () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(address_item));
       return driver.findElement(address_item).isDisplayed();
    }

    public int deleteAdd () {
        int beforeCount = driver.findElements(addressItems).size();
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteBtn));
        driver.findElement(deleteBtn).click();
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressItems));
        int after = driver.findElements(addressItems).size();
        return beforeCount - after;
    }


    public String getErrorMsg(String field) {
        switch (field){
            case "F":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorFname));
                return driver.findElement(errorFname).getText();


            case "L":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorLname));
                return driver.findElement(errorLname).getText();

            case "E":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorEmail));
                return driver.findElement(errorEmail).getText();
            case "Country":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorCountry));
                return driver.findElement(errorCountry).getText();
            case "City":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorCity));
                return driver.findElement(errorCity).getText();
            case "Num":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorPhone));
                return driver.findElement(errorPhone).getText();
            case "P":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorPostal));
                return driver.findElement(errorPostal).getText();
            case "Add":
                wait.until(ExpectedConditions.visibilityOfElementLocated(errorAdd));
                return driver.findElement(errorAdd).getText();

        }
        return  "";

    }


}
