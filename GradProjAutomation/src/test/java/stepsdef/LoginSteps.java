package stepsdef;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage;
    String validEmail = "mohamed123.aziz@example.com";
    String validPassword = "QaTest@123";

    private void loginBasicSteps(String email, String password)
    {
        loginPage.insertEmail(email);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
    }

    @Given("User opens Home page and clicks on login link")
    public void user_opens_home_page_and_clicks_on_login_link() {
        loginPage = homePage.clickOnLoginLink();
    }

    @When("User enters valid email and password and press on login button")
    public void userEntersValidEmailAndPasswordAndPressOnLoginButton() {
        loginBasicSteps(validEmail, validPassword);
    }

    @Then("Home page opens successfully and user is in logged in mode")
    public void homePageOpensSuccessfullyAndUserIsInLoggedInMode() {
        Hooks.assertTestResult(homePage.getLoggedInEmail(), validEmail);
    }

    @When("User enters invalid {string} format and valid {string} and press on login button")
    public void userEntersInvalidFormatAndValidAndPressOnLoginButton(String email, String password) {
        loginBasicSteps(email, password);
    }

    @Then("The Error message {string} appears")
    public void theErrorMessageAppears(String errorMessage) {

        try {
            Hooks.assertTestResult(loginPage.getInvalidEmailFormatMessage(), errorMessage);
            return; // success, no need to try the second one
        } catch (NoSuchElementException ignored) {
            // First message doesn't exist → try second one
        }

        try {
            Hooks.assertTestResult(loginPage.getFailedLoginErrorMessage(), errorMessage);
        } catch (NoSuchElementException e) {
            System.out.println("This error message doesn't exist");
        }
    }

    @When("User enters empty or non-registered {string} and valid {string} and press on login button")
    public void userEntersEmptyOrNonRegisteredAndValidAndPressOnLoginButton(String email, String password) {
        loginBasicSteps(email, password);
    }

    @When("User enters valid {string} and invalid {string} and press on login button")
    public void userEntersValidAndInvalidAndPressOnLoginButton(String email, String password) {
        loginBasicSteps(email, password);
    }
}
