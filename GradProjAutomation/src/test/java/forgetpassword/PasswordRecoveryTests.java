package forgetpassword;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PasswordRecoveryPage;

public class PasswordRecoveryTests extends BaseTest {

    @Test
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
