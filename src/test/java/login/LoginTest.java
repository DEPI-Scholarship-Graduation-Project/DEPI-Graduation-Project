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

        HomePage homePage = loginPage.clickLoginButton();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            logger.info("No alert present after login.");
        }

        if(result.equalsIgnoreCase("success")){
            Assert.assertTrue(homePage.getHederBar().getWebsiteLogoElement());
            logger.info("User Login Successful!");
        }else {
            loginPage.clickLoginButton();
            String expected = "Login was unsuccessful" ;
            Assert.assertTrue(loginPage.getMessageErrorText().contains(expected));
            logger.info("Login Failed!");
        }

    }
}
