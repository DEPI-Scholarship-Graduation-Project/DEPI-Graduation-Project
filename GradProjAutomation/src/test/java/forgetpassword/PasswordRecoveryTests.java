package forgetpassword;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PasswordRecoveryPage;

public class PasswordRecoveryTests extends BaseTest {

    @Test(priority = 1)
    public void testRegisteredEmail()
    {
        LoginPage loginPage = homePage.clickOnLoginLink();
        PasswordRecoveryPage passwordRecoveryPage = loginPage.clickOnForgotPasswordLink();
        passwordRecoveryPage.insertEmail("mohamed123.aziz@example.com");
        passwordRecoveryPage.clickOnRecoverButton();

        String emailNotFoundErrorMessageText = "Email with instructions has been sent to you.";
        assertTestResult(passwordRecoveryPage.getResultMessage(), emailNotFoundErrorMessageText);
    }

    @Test(priority = 2)
    public void testNotRegisteredEmail()
    {
        LoginPage loginPage = homePage.clickOnLoginLink();
        PasswordRecoveryPage passwordRecoveryPage = loginPage.clickOnForgotPasswordLink();
        passwordRecoveryPage.insertEmail("not.registered@email.com");
        passwordRecoveryPage.clickOnRecoverButton();

        String emailNotFoundErrorMessageText = "Email not found.";
        assertTestResult(passwordRecoveryPage.getResultMessage(), emailNotFoundErrorMessageText);
    }
}
