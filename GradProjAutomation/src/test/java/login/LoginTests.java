package login;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage;
    String validEmail = "ironmedo100@gmail.com";
    String validPassword = "z016369im";
    String invalidEmailFormat = "mohamed.azizexample.com";
    String nonRegisteredEmail = "m.aziz@example.com";
    String invalidPassword = "QaTest@123456";

    private void loginSteps(String email, String password)
    {
        loginPage = homePage.clickOnLoginLink();
        loginPage.insertEmail(email);
        loginPage.insertPassword(password);
        loginPage.clickOnLoginButton();
    }

    private void logoutBeforeTest()
    {
        try {
            homePage.clickOnLogoutLink();
            System.out.println("Optional element found and clicked.");
        } catch (NoSuchElementException e) {
            System.out.println("Optional element not present. Skipping action and continuing test.");
        }
    }

    private void assertTestResult(String actualResult, String expectedResult)
    {
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test(priority = 1)
    public void testSuccessfulLogin()
    {
        logoutBeforeTest();
        loginSteps(validEmail, validPassword);

        assertTestResult(homePage.getLoggedInEmail(), validEmail);
    }

    @Test(priority = 2)
    public void testInvalidEmailFormat()
    {
        logoutBeforeTest();
        loginSteps(invalidEmailFormat, validPassword);

        String invalidEmailFormatMessageText = "Please enter a valid email address.";
        assertTestResult(loginPage.getInvalidEmailFormatMessage(), invalidEmailFormatMessageText);

    }

    @Test(priority = 3)
    public void testEmptyOrNotRegisteredEmail()
    {
        logoutBeforeTest();
        loginSteps(nonRegisteredEmail, validPassword);

        String emptyOrNotRegisteredEmailErrorMessageText = "No customer account found";
        assertTestResult(loginPage.getFailedLoginErrorMessage(), emptyOrNotRegisteredEmailErrorMessageText);
    }

    @Test(priority = 4)
    public void testEmptyOrInvalidPassword()
    {
        logoutBeforeTest();
        loginSteps(validEmail, invalidPassword);

        String emptyOrInvalidPasswordErrorMessageText = "The credentials provided are incorrect";
        assertTestResult(loginPage.getFailedLoginErrorMessage(), emptyOrInvalidPasswordErrorMessageText);
    }
}
