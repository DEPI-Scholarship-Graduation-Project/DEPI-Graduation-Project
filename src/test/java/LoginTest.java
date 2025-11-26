import base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.openqa.selenium.NoAlertPresentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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


    @Test(dataProvider = "loginData")
    public void VerifyUserLoginSuccessfulTest(JsonNode data) {

        LoginPage loginPage = homePage.getHederBar().clickOnLoginLink();

        String email = data.get("email").asText() ;
        String password = data.get("password").asText();
        String result = data.get("result").asText();

        loginPage.enterUserEmail(email);
        loginPage.enterPassword(password);

        homePage = loginPage.clickLoginButton();

        if(result.equalsIgnoreCase("success")){

            Assert.assertTrue(homePage.getHederBar().isUserLoggedIn());
            homePage.getHederBar().clickOnLogOutLink() ;
            logger.info("User Login Successful!");
        }else {
            Assert.assertTrue(homePage.getHederBar().isUserNotLoggedIn());
            logger.info("Login Failed!");
        }

    }
}
