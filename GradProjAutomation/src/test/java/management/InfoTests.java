package management;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountManagement.Addresses;
import pages.AccountManagement.CustomerInfo;
import pages.AccountManagement.Manage;
import pages.LoginPage;

public class InfoTests  extends BaseTest {

    LoginPage loginPage;
    Manage manage;
    CustomerInfo info;
    String error;




    @BeforeMethod
    private void setManageSteps()
    {
        loginPage = homePage.clickOnLoginLink();
        loginPage.insertEmail("Nxxx@gmail.com");
        loginPage.insertPassword("WJrb$vLE8Gjib");
        loginPage.clickOnLoginButton();

        manage = homePage.navToAccountManagement();
        info = manage.navToInfo();

    }

    @AfterMethod
    private void closure()
    {
        homePage.clickOnLogoutLink();
    }


    @Test
    public void successfulInfoModification(){

        /*
         * Navigate to account management
         * Navigate to Info
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */

        info.clearFields();

        info.setFirstName("Nour");
        info.setLastName("Alabgar");
        info.setEmail("Nxxx@gmail.com");
        info.submit();

        homePage.clickOnLogoutLink();
        homePage.clickOnLoginLink();

        loginPage.insertEmail("Nxxx@gmail.com");
        loginPage.insertPassword("WJrb$vLE8Gjib");
        loginPage.clickOnLoginButton();

        manage = homePage.navToAccountManagement();

        info = manage.navToInfo();

        Assert.assertEquals(info.getLastName(), "Alabgar");
    }

    @Test
    public void EditInfoWithoutEmail(){

        /*
         * Navigate to account management
         * Navigate to Info
         * Click on add btn
         * fill fields
         * leave email field empty
         * submit
         * assert
         * */

        info.clearFields();

        info.setFirstName("Nour");
        info.setLastName("Alabgar");
        info.submit();

        error =info.getErrorMsg("E");



        Assert.assertTrue(error.contains("Email is required."));
    }

    @Test
    public void EditInfoWithoutFirstName(){

        /*
         * Navigate to account management
         * Navigate to Info
         * Click on add btn
         * fill fields
         * leave first name field empty
         * submit
         * assert
         * */
        info.clearFields();
        info.setLastName("Alabgar");
        info.setEmail("Nxxx@gmail.com");
        info.submit();

        error =info.getErrorMsg("F");



        Assert.assertTrue(error.contains("First name is required."));
    }

    @Test
    public void EditInfoWithoutLastName(){

        /*
         * Navigate to account management
         * Navigate to Info
         * Click on add btn
         * fill fields
         * leave last name field empty
         * submit
         * assert
         * */

        info.clearFields();
        info.setFirstName("Nour");
        info.setEmail("Nxxx@gmail.com");
        info.submit();

        error =info.getErrorMsg("L");



        Assert.assertTrue(error.contains("Last name is required."));
    }



}
