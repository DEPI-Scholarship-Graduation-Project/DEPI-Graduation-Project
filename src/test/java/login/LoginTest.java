package login;

import base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utility.JsonReader;

public class LoginTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(LoginTest.class);


    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        return JsonReader.getJsonData(
                "src/test/resources/testdata/loginData.json",
                "loginTests"
        );
    }

    @Test
    public void VerifyLoginPageDisplayedTest() {
        LoginPage loginPage = homePage.getHederBar().clickOnLoginLink();
        Assert.assertTrue(loginPage.getPageTitleElement().contains("Welcome, Please Sign In!"));
    }

    @Test(dataProvider = "loginData")
    public void VerifyUserLoginSuccessfulTest(JsonNode data) {

        LoginPage loginPage = homePage.getHederBar().clickOnLoginLink();
        String email = data.get("email").asText() ;
        String password = data.get("password").asText();
        String result = data.get("result").asText();

        loginPage.enterUserEmail(email);
        loginPage.enterPassword(password);

        homePage = loginPage.clickLoginButton();
        driver.switchTo().alert().accept();

        if(result.equalsIgnoreCase("success")){
            homePage = loginPage.clickLoginButton();
            Assert.assertTrue(homePage.getHederBar().isUserLoggedIn());
            logger.info("User Login Successful!");
        }else {
            Assert.assertFalse(loginPage.getHederBar().isUserLoggedIn());
            logger.info("Login Failed!");
        }

    }
}
