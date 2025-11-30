package pages.AccountManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerInfo {


    public WebDriver driver;
    WebDriverWait wait;

    public CustomerInfo(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //locators
    private final By firstName =By.id("FirstName");
    private final By lastName = By.name("LastName");
    private final By gender = By.id("gender-female");
    private final By email = By.id("Email");
    private final By btn = By.name("save-info-button");

   private final By errorFname= By.xpath("//*[text()='First name is required.']");
   private final By errorLname= By.xpath("//*[text()='Last name is required.']");
   private final By errorEmail= By.xpath("//*[text()='Email is required.']");


    // methods

    public void clearFields(){
        driver.findElement(firstName).clear();
        driver.findElement(lastName).clear();
        driver.findElement(email).clear();

    }

    public void setFirstName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys(name);

    }


    public void  setLastName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
        driver.findElement(lastName).sendKeys(name);

    }

    public String  getLastName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName));
         return  driver.findElement(lastName).getAttribute("value");

    }

    public void  setEmail(String e){
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(email).sendKeys(e);

    }



    public void setGender() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(gender));
        driver.findElement(gender).click();
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

        }
        return  "";

    }


    public void submit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn));
        driver.findElement(btn).click();
    }
}
