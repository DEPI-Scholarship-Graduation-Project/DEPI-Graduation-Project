package homeTest;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class HomeTest extends
        BaseTest {
    private final Logger logger = LoggerFactory.getLogger(HomeTest.class);
    @Test
    public void VerifyWebsiteLogoDisplayedTest() {

        Assert.assertTrue(homePage.getWebsiteLogoElement());
        logger.info("Website Logo is Displayed!");
    }

    @Test
    public void VerifyLoginPageDisplayedTest() {
        LoginPage loginPage = homePage.clickOnLoginLink();
        Assert.assertTrue(loginPage.getPageTitleElement().contains("Welcome, Please Sign In!"));
    }
}
