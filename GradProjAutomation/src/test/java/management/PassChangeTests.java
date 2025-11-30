package management;

import base.BaseTest;
import login.LoginTests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountManagement.Addresses;
import pages.AccountManagement.ChangePassword;
import pages.AccountManagement.Manage;
import pages.LoginPage;

public class PassChangeTests extends BaseTest {

    LoginPage loginPage;
    Manage manage;
    ChangePassword pass;

    String error;

    @BeforeMethod
    private void setManageSteps()
    {
        loginPage = homePage.clickOnLoginLink();
        loginPage.insertEmail("Nxxx@gmail.com");
        loginPage.insertPassword("Nxxx@gmail.com");
        loginPage.clickOnLoginButton();

        manage= homePage.navToAccountManagement();

        pass = manage.navToChangePassword();

    }

    @AfterMethod
    private void closure()
    {
        homePage.clickOnLogoutLink();
    }


    @Test
    public void successfulChangePassword(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */
        
        pass.setNewPassword("Nxxx@gmail.com");
        pass.setOldPassword("Nxxx@gmail.com");
        pass.setConfirm("Nxxx@gmail.com");
        pass.submit();

        homePage.clickOnLogoutLink();
        homePage.clickOnLoginLink();


        loginPage.insertEmail("Nxxx@gmail.com");
        loginPage.insertPassword("Nxxx@gmail.com");
        loginPage.clickOnLoginButton();

        Assert.assertTrue(homePage.getLoggedInEmail().contains("Nxxx@gmail.com"));


    }

    @Test
    public void ChangePassWithoutLOldPass(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */


        pass.setNewPassword("Nxxx@gmail.com");
        pass.setConfirm("Nxxx@gmail.com");
        pass.submit();

        error = pass.getErrorMsg("O");





        Assert.assertTrue(error.contains("Old password is required."));

    }

    @Test
    public void ChangePassWithoutLNewPass(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */


        pass.setOldPassword("Nxxx@gmail.com");
        pass.setConfirm("Nxxx@gmail.com");
        pass.submit();

        error = pass.getErrorMsg("N");





        Assert.assertTrue(error.contains("New password is required."));

    }
    @Test
    public void ChangePassWithoutConfirmPass(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */


        pass.setNewPassword("Nxxx@gmail.com");
        pass.setOldPassword("Nxxx@gmail.com");
        pass.submit();

        error = pass.getErrorMsg("C");



        Assert.assertTrue(error.contains("Password is required."));

    }

    @Test
    public void newPassMismatchingWithConfirmPass(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */


        pass.setNewPassword("Nxxx@gmail.com");
        pass.setOldPassword("Nxxx@gmail.com");
        pass.setConfirm("Nxxx@gmail");
        pass.submit();

        error = pass.getErrorMsg("M");


        Assert.assertTrue(error.contains("The new password and confirmation password do not match."));

    }

    @Test
    public void newPassWithLengthLessThan6(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */


        pass.setOldPassword("Nxxx@gmail.com");
        pass.setNewPassword("Nxxx");
        pass.setConfirm("Nxxx");
        pass.submit();

        error = pass.getErrorMsg("L");


        Assert.assertTrue(error.contains("The password should have at least 6 characters."));

    }
    @Test
    public void wrongOldPass(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */


        pass.setOldPassword("Nxxxxx");
        pass.setNewPassword("Nxxx@gmail.com");
        pass.setConfirm("Nxxx@gmail.com");
        pass.submit();

        error = pass.getErrorMsg("W");


        Assert.assertTrue(error.contains("Old password doesn't match"));

    }

}
