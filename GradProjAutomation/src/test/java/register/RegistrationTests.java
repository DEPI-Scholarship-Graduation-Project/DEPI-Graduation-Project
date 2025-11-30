package register;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.RegisterPage;
import pages.RegistrationCompletionPage;

public class RegistrationTests extends BaseTest {
    RegisterPage registerPage;
    RegistrationCompletionPage registrationCompletionPage;
    String firstName = "Mohamed";
    String lastName = "Abdulaziz";
    String validEmail = "mohamed123.aziz@test1.com";
    String registeredEmail = "ironmedo100@gmail.com";
    String validPassword = "QaTest@123";
    String invalidEmailFormat = "mohamed.aziz@example";
    String shortPassword = "123";
    String gender = "Male";

    private void registrationSteps(String gender, String firstName, String lastName, String email, String password, String confirmPassword)
    {
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

    @Test(priority = 1)
    public void testSuccessfulRegistration()
    {
        logoutBeforeTest();
        registrationSteps(gender, firstName, lastName, validEmail, validPassword, validPassword);

        String registrationCompletionMessageText = "Your registration completed";
        assertTestResult(registrationCompletionPage.getCompletionMessage(), registrationCompletionMessageText);
        registrationCompletionPage.clickOnContinueButton();
    }

    @Test(priority = 4)
    public void testEmptyFirstName()
    {
        logoutBeforeTest();
        registrationSteps(gender, "", lastName, validEmail, validPassword, validPassword);

        String emptyFirstNameErrorMessageText = "First name is required.";
        assertTestResult(registerPage.getFirstNameErrorMessage(), emptyFirstNameErrorMessageText);
    }

    @Test(priority = 4)
    public void testEmptyLastName()
    {
        logoutBeforeTest();
        registrationSteps(gender, firstName, "", validEmail, validPassword, validPassword);

        String emptyLastNameErrorMessageText = "Last name is required.";
        assertTestResult(registerPage.getLastNameErrorMessage(), emptyLastNameErrorMessageText);
    }

    @Test(priority = 4)
    public void testEmptyEmail()
    {
        logoutBeforeTest();
        registrationSteps(gender, firstName, lastName, "", validPassword, validPassword);

        String emptyEmailErrorMessageText = "Email is required.";
        assertTestResult(registerPage.getEmailErrorMessage(), emptyEmailErrorMessageText);
    }

    @Test(priority = 4)
    public void testEmptyPassword()
    {
        logoutBeforeTest();
        registrationSteps(gender, firstName, lastName, validEmail, "", validPassword);

        String emptyPasswordErrorMessageText = "Password is required.";
        assertTestResult(registerPage.getPasswordErrorMessage(), emptyPasswordErrorMessageText);
    }

    @Test(priority = 4)
    public void testEmptyConfirmPassword()
    {
        logoutBeforeTest();
        registrationSteps(gender, firstName, lastName, validEmail, validPassword, "");

        String emptyConfirmPasswordErrorMessageText = "Password is required.";
        assertTestResult(registerPage.getConfirmPasswordErrorMessage(), emptyConfirmPasswordErrorMessageText);
    }

    @Test(priority = 2)
    public void testInvalidEmailFormat()
    {
        logoutBeforeTest();
        registrationSteps(gender, firstName, lastName, invalidEmailFormat, validPassword, validPassword);

        String invalidEmailFormatErrorMessageText = "Wrong email";
        assertTestResult(registerPage.getEmailErrorMessage(), invalidEmailFormatErrorMessageText);

    }

    @Test(priority = 2)
    public void testMismatchingPasswords()
    {
        logoutBeforeTest();
        registrationSteps(gender, firstName, lastName, validEmail, validPassword, validPassword.concat(validPassword));

        String mismatchingConfirmPasswordErrorMessageText = "The password and confirmation password do not match.";
        assertTestResult(registerPage.getConfirmPasswordErrorMessage(), mismatchingConfirmPasswordErrorMessageText);
    }

    @Test(priority = 3)
    public void testShortPassword()
    {
        logoutBeforeTest();
        registrationSteps(gender, firstName, lastName, validEmail, shortPassword, shortPassword);

        String shortPasswordErrorMessageText = "The password should have at least 6 characters.";
        assertTestResult(registerPage.getPasswordErrorMessage(), shortPasswordErrorMessageText);
    }

    @Test(priority = 2)
    public void testAlreadyRegisteredEmail()
    {
        logoutBeforeTest();
        registrationSteps(gender, firstName, lastName, registeredEmail, validPassword, validPassword);

        String registeredEmailErrorMessageText = "The specified email already exists";
        assertTestResult(registerPage.getExistingEmailErrorMessage(), registeredEmailErrorMessageText);
    }

    @Test(priority = 5)
    public void testNotSelectingGender()
    {
        logoutBeforeTest();
        registrationSteps("", firstName, lastName, validEmail, validPassword, validPassword);

        String notSelectedGenderErrorMessageText = "Gender is required.";
        assertTestResult(registerPage.getGenderNotSelectedErrorMessage(), notSelectedGenderErrorMessageText);
    }
}
