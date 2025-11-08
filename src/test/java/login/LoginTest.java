package login;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void VerifyLoginPageDisplayedTest() {
        LoginPage loginPage = homePage.clickOnLoginLink();
        Assert.assertTrue(loginPage.getPageTitleElement().contains("Welcome, Please Sign In!"));
    }

    @Test
    public void VerifyUserLoginSuccessfulTest() {
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.enterUserName("testaffaires8@gmail.com");
        loginPage.enterPassword("Demo-shop-1234");
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertTrue(homePage.getWebsiteLogoElement());
        logger.info("User Login Successful!");
    }
}
