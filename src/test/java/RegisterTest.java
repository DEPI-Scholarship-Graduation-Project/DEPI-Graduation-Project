
import base.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConfirmRegister;
import pages.HomePage;
import pages.RegisterPage;
import utility.DataGenerator;

import java.util.HashMap;
import java.util.Map;

public class RegisterTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(RegisterTest.class);


    @Test(invocationCount = 5)
    public void VerifyUserLoginSuccessfulTest() {

        RegisterPage registerPage = homePage.getHederBar().clickOnRegisterLink();

        Map<String, String> data = new HashMap<>();
        data.put("gender", DataGenerator.randomGender());
        data.put("firstName", DataGenerator.randomFirstName());
        data.put("lastName", DataGenerator.randomLastName());
        data.put("email", DataGenerator.randomEmail());

        String password = DataGenerator.randomPassword() ;
        data.put("password", password);
        data.put("confirmPassword",password);

        registerPage.enterRegisterFormData(data);

        ConfirmRegister confirmRegister = registerPage.clickRegisterButton();

        homePage = confirmRegister.clickOnContinueButton();

        Assert.assertTrue(homePage.getHederBar().isUserLoggedIn());
        homePage.getHederBar().clickOnLogOutLink() ;
        logger.info("User Login Successful!");

    }
}

