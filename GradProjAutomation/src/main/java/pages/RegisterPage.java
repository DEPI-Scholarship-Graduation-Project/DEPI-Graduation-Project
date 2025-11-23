package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By maleRadioButton = By.xpath("//input[@value='M']");
    private By femaleRadioButton = By.xpath("//input[@value='F']");
    private By firstNameBox = By.xpath("//input[@id='FirstName']");
    private By lastNameBox = By.xpath("//input[@id='LastName']");
    private By emailBox = By.xpath("//input[@id='Email']");
    private By passwordBox = By.xpath("//input[@id='Password']");
    private By confirmPasswordBox = By.xpath("//input[@id='ConfirmPassword']");
    private By registerButton = By.xpath("//input[@id='register-button']");

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
}
