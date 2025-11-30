package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By maleRadioButton = By.xpath("//input[@value='M']");
    private final By femaleRadioButton = By.xpath("//input[@value='F']");
    private final By firstNameBox = By.xpath("//input[@id='FirstName']");
    private final By lastNameBox = By.xpath("//input[@id='LastName']");
    private final By emailBox = By.xpath("//input[@id='Email']");
    private final By passwordBox = By.xpath("//input[@id='Password']");
    private final By confirmPasswordBox = By.xpath("//input[@id='ConfirmPassword']");
    private final By registerButton = By.xpath("//input[@id='register-button']");
    private final By genderNotSelectedErrorMessage = By.xpath("//span[@data-valmsg-for='Gender']");
    private final By firstNameErrorMessage = By.xpath("//span[@data-valmsg-for='FirstName']");
    private final By lastNameErrorMessage = By.xpath("//span[@data-valmsg-for='LastName']");
    private final By emailErrorMessage = By.xpath("//span[@data-valmsg-for='Email']");
    private final By passwordErrorMessage = By.xpath("//span[@data-valmsg-for='Password']");
    private final By confirmPasswordErrorMessage = By.xpath("//span[@data-valmsg-for='ConfirmPassword']");
    private final By emailAlreadyExistErrorMessage = By.xpath("//div[@class='validation-summary-errors']");


    //Actions
    public void selectMaleGender()
    {
        driver.findElement(maleRadioButton).click();
    }
    public void selectFemaleGender()
    {
        driver.findElement(femaleRadioButton).click();
    }
    public void insertFirstName(String firstName)
    {
        driver.findElement(firstNameBox).sendKeys(firstName);
    }
    public void insertLasName(String lastName)
    {
        driver.findElement(lastNameBox).sendKeys(lastName);
    }
    public void insertEmail(String email)
    {
        driver.findElement(emailBox).sendKeys(email);
    }
    public void insertPassword(String password)
    {
        driver.findElement(passwordBox).sendKeys(password);
    }
    public void insertConfirmPassword(String confirmPassword)
    {
        driver.findElement(confirmPasswordBox).sendKeys(confirmPassword);
    }
    public RegistrationCompletionPage clickOnRegisterButton()
    {
        driver.findElement(registerButton).click();
        return new RegistrationCompletionPage(driver);
    }
    public String getGenderNotSelectedErrorMessage()
    {
        try{
            return driver.findElement(genderNotSelectedErrorMessage).getText();
        } catch (NoSuchElementException e) {
            return "Error message locator doesn't exist";
        }
    }
    public String getFirstNameErrorMessage()
    {
        return driver.findElement(firstNameErrorMessage).getText();
    }
    public String getLastNameErrorMessage()
    {
        return driver.findElement(lastNameErrorMessage).getText();
    }
    public String getEmailErrorMessage()
    {
        return driver.findElement(emailErrorMessage).getText();
    }
    public String getPasswordErrorMessage()
    {
        return driver.findElement(passwordErrorMessage).getText();
    }
    public String getConfirmPasswordErrorMessage()
    {
        return driver.findElement(confirmPasswordErrorMessage).getText();
    }
    public String getExistingEmailErrorMessage()
    {
        return driver.findElement(emailAlreadyExistErrorMessage).getText();
    }
}
