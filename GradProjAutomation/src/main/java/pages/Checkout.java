package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Checkout {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public Checkout(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

   private final By checkBox = By.id("termsofservice");
   private final By checkBtn = By.id("checkout");
    private final By allContinueBtns = By.cssSelector("input.button-1[value='Continue']");

    private final By cnfBtn = By.xpath("//input[@value='Confirm' and contains(@class,'confirm-order-next-step-button')]");

   private final By successMsg = By.xpath("//strong[text()='Your order has been successfully processed!']");
   private final By orderNumber = By.cssSelector("ul.details li:first-child");
    private  final By orderNo = By.cssSelector("div.section.order-item div.title strong");
    private final By addToCartBtn = By.cssSelector("input.button-2.product-box-add-to-cart-button");
    private final By pickUpInStore = By.id("PickUpInStore");
    private final By option0 = By.id("shippingoption_0");
    private final By option1 = By.id("shippingoption_1");
   private final By option2 = By.id("shippingoption_2");

    private final By payO = By.id("paymentmethod_0");
    private final By pay1 = By.id("paymentmethod_1");
    private final By pay2 = By.id("paymentmethod_2");
    private final By pay3 = By.id("paymentmethod_3");


   private final By alert = By.id("ui-id-2");


    public void setCheckBox() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBox));
        driver.findElement(checkBox).click();
    }

    public void setCheckBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBtn));
        driver.findElement(checkBtn).click();
    }

    public String getTermsAlert() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
       return  driver.findElement(alert).getText();

    }

    public void clickContinue() {
        List<WebElement> buttons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allContinueBtns));

        for (WebElement btn : buttons) {
            if (btn.isDisplayed() && btn.isEnabled()) {
                btn.click();
            }
        }

    }

    public void shipping(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pickUpInStore));
        driver.findElement(pickUpInStore).click();
        clickContinue();

    }

    public void billing(){
        clickContinue();
    }

    public void shippingMethod(String option) throws InterruptedException {
        switch (option){
            case "G":
                wait.until(ExpectedConditions.visibilityOfElementLocated(option0));
                driver.findElement(option0).click();
                break;
            case "N":
                wait.until(ExpectedConditions.visibilityOfElementLocated(option1));
                driver.findElement(option1).click();
                break;
            case "S":
                wait.until(ExpectedConditions.visibilityOfElementLocated(option2));
                driver.findElement(option2).click();
                break;

        }
        Thread.sleep(5000);
        clickContinue();
    }

    public void paymentMethod(String option) throws InterruptedException {
        switch (option){
            case "COD":
                wait.until(ExpectedConditions.visibilityOfElementLocated(payO));
                driver.findElement(payO).click();
                break;
            case "M":
                wait.until(ExpectedConditions.visibilityOfElementLocated(pay1));
                driver.findElement(pay1).click();
                break;
            case "CC":
                wait.until(ExpectedConditions.visibilityOfElementLocated(pay2));
                driver.findElement(pay2).click();
                break;

            case "PO":
                wait.until(ExpectedConditions.visibilityOfElementLocated(pay3));
                driver.findElement(pay3).click();
                break;

        }
        Thread.sleep(5000);
        clickContinue();
    }



    public void payInfo(String p){
        if(p.contains("COD")){

        }else if(p.contains("PO")){

        }
        clickContinue();
    }

    public void cnf(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cnfBtn));
        driver.findElement(cnfBtn).click();

    }

    public String getSuccessMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
        return driver.findElement(successMsg).getText();

    }

    public String getOrderNumber(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumber));
        return driver.findElement(orderNumber).getText();

    }

    public String getOrderNoInList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderNo));
        return driver.findElement(orderNo).getText();

    }

/*    public void addToCart() {
    //    wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
        driver.findElement(By.xpath("//input[@value='Add to cart']")).click();

    }*/






}
