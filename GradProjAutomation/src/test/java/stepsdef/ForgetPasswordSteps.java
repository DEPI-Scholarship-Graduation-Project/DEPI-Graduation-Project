package stepsdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.PasswordRecoveryPage;

public class ForgetPasswordSteps {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage;
    PasswordRecoveryPage passwordRecoveryPage;

    @Given("User opens Home page and clicks on login link and clicks on forget password link")
    public void userOpensHomePageAndClicksOnLoginLinkAndClicksOnForgetPasswordLink() {
        loginPage = homePage.clickOnLoginLink();
        passwordRecoveryPage = loginPage.clickOnForgotPasswordLink();
    }

    @When("User enters registered email {string} and press on recover button")
    public void userEntersRegisteredEmailAndPressOnRecoverButton(String email) {
        passwordRecoveryPage.insertEmail(email);
        passwordRecoveryPage.clickOnRecoverButton();
    }

    @Then("The message message {string} appears")
    public void theMessageMessageAppears(String message) {
        Hooks.assertTestResult(passwordRecoveryPage.getResultMessage(), message);
    }

    @When("User enters non-registered email {string} and press on recover button")
    public void userEntersNonRegisteredEmailAndPressOnRecoverButton(String email) {
        passwordRecoveryPage.insertEmail(email);
        passwordRecoveryPage.clickOnRecoverButton();
    }
}
