package stepsdef;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegistrationCompletionPage;

public class RegisterSteps {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    RegisterPage registerPage;
    RegistrationCompletionPage registrationCompletionPage;

    private void registrationBasicSteps(String gender, String firstName, String lastName, String email, String password, String confirmPassword) {
        registerPage = homePage.clickOnRegisterLink();
        gender = gender.toLowerCase();
        if (gender.equals("male") || gender.equals("m"))
            registerPage.selectMaleGender();
        else if (gender.equals("female") || gender.equals("f"))
            registerPage.selectFemaleGender();
        // else System.out.println("Please Choose any variation of Male or Female");
        registerPage.insertFirstName(firstName);
        registerPage.insertLasName(lastName);
        registerPage.insertEmail(email);
        registerPage.insertPassword(password);
        registerPage.insertConfirmPassword(confirmPassword);
        registrationCompletionPage = registerPage.clickOnRegisterButton();
    }

    @Given("User opens Home page and clicks on register link")
    public void userOpensHomePageAndClicksOnRegisterLink()
    {
        registerPage = homePage.clickOnRegisterLink();
    }

    @When("User selects {string} and enters valid {string}, {string}, {string}, {string}, and {string} and press on register button")
    public void userSelectsAndEntersValidAndAndPressOnRegisterButton(String gender, String firstName, String lastName, String email, String password, String confirmPassword) {
        registrationBasicSteps(gender, firstName, lastName, email, password, confirmPassword);
    }

    @Then("Registration Completion page opens successfully and success message {string} appears")
    public void registrationCompletionPageOpensSuccessfullyAndSuccessMessageAppears(String message) {
        Hooks.assertTestResult(registrationCompletionPage.getCompletionMessage(), message);
    }

    @Then("The error message for registered email {string} appears")
    public void theErrorMessageForRegisteredEmailAppears(String errorMessage) {
        Hooks.assertTestResult(registerPage.getExistingEmailErrorMessage(), errorMessage);
    }

    @When("User selects {string} and enters valid {string}, {string}, {string}, {string} and registered {string} and press on register button")
    public void userSelectsAndEntersValidAndRegisteredAndPressOnRegisterButton(String gender, String firstName, String lastName, String password, String confirmPassword, String email) {
        registrationBasicSteps(gender, firstName, lastName, email, password, confirmPassword);
    }

    @When("User selects {string} and enters valid {string}, {string}, {string}, {string} and invalid {string} format and press on register button")
    public void userSelectsAndEntersValidAndInvalidFormatAndPressOnRegisterButton(String gender, String firstName, String lastName, String password, String confirmPassword, String email) {
        registrationBasicSteps(gender, firstName, lastName, email, password, confirmPassword);
    }

    @When("User selects {string} and enters valid {string}, {string}, {string}, and mismatch {string} and {string} and press on register button")
    public void userSelectsAndEntersValidAndMismatchAndAndPressOnRegisterButton(String gender, String firstName, String lastName, String email, String password, String confirmPassword) {
        registrationBasicSteps(gender, firstName, lastName, email, password, confirmPassword);
    }

    @When("User selects {string} and enters valid {string}, {string}, {string}, and short {string} and {string} and press on register button")
    public void userSelectsAndEntersValidAndShortAndAndPressOnRegisterButton(String gender, String firstName, String lastName, String email, String password, String confirmPassword) {
        registrationBasicSteps(gender, firstName, lastName, email, password, confirmPassword);
    }

    @When("User doesn't select {string} and enters valid {string}, {string}, {string}, {string}, and {string} and press on register button")
    public void userDoesnTSelectAndEntersValidAndAndPressOnRegisterButton(String gender, String firstName, String lastName, String email, String password, String confirmPassword) {
        registrationBasicSteps(gender, firstName, lastName, email, password, confirmPassword);
    }

    @When("User selects {string} and enters valid {string}, {string}, {string}, and {string} and leave {string} empty and press on register button")
    public void userSelectsAndEntersValidAndAndLeaveEmptyAndPressOnRegisterButton(String gender, String firstName, String email, String password, String confirmPassword, String lastName) {
        registrationBasicSteps(gender, firstName, lastName, email, password, confirmPassword);
    }

    @Then("The error message for {string} format appears")
    public void theErrorMessageForFormatAppears(String errorMessage) {
        Hooks.assertTestResult(registerPage.getEmailErrorMessage(), errorMessage);
    }

    @Then("The error message for mismatching passwords {string} appears")
    public void theErrorMessageForMismatchingPasswordsAppears(String errorMessage) {
        Hooks.assertTestResult(registerPage.getConfirmPasswordErrorMessage(), errorMessage);
    }

    @Then("The error message for missing gender {string} appears")
    public void theErrorMessageForMissingGenderAppears(String errorMessage) {
        Hooks.assertTestResult(registerPage.getGenderNotSelectedErrorMessage(), errorMessage);
    }

    @Then("The error message for missing first name {string} appears")
    public void theErrorMessageForMissingFirstNameAppears(String errorMessage) {
        Hooks.assertTestResult(registerPage.getFirstNameErrorMessage(), errorMessage);
    }

    @Then("The error message for missing last name {string} appears")
    public void theErrorMessageForMissingLastNameAppears(String errorMessage) {
        Hooks.assertTestResult(registerPage.getLastNameErrorMessage(), errorMessage);
    }

    @Then("The error message for short passwords {string} appears")
    public void theErrorMessageForShortPasswordsAppears(String errorMessage) {
        Hooks.assertTestResult(registerPage.getPasswordErrorMessage(), errorMessage);
    }

    @When("User selects {string}, leave {string} empty and enters valid {string}, {string}, {string}, and {string} and press on register button")
    public void userSelectsLeaveEmptyAndEntersValidAndAndPressOnRegisterButton(String gender, String firstName, String lastName, String email, String password, String confirmPassword) {
        registrationBasicSteps(gender, firstName, lastName, email, password, confirmPassword);
    }
}
