package management;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountManagement.Addresses;
import pages.AccountManagement.Manage;
import pages.LoginPage;

public class AddTests extends BaseTest {

    LoginPage loginPage;
    Manage manage;
    Addresses add;

    String error;



    @BeforeMethod
    private void setManageSteps()
    {
        loginPage = homePage.clickOnLoginLink();
        loginPage.insertEmail("Nxxx@gmail.com");
        loginPage.insertPassword("WJrb$vLE8Gjib");
        loginPage.clickOnLoginButton();

        manage= homePage.navToAccountManagement();

        add = manage.navToAddresses();

    }

    @AfterMethod
    private void closure()
    {
        homePage.clickOnLogoutLink();
    }


    @Test
    public void successfulAddAddress(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */

        add.newAdd();
        add.setFirstName("Nour");
        add.setLastName("Alabgar");
        add.setEmail("Nxxx@gmail.com");
        add.setCountry("Egypt");
        add.setCity("Cairo");
        add.setAdd("Cairo");
        add.setPostal("0000");
        add.setNum("00000000");
        add.save();

        homePage.clickOnLogoutLink();
        homePage.clickOnLoginLink();

        loginPage.insertEmail("Nxxx@gmail.com");
        loginPage.insertPassword("WJrb$vLE8Gjib");
        loginPage.clickOnLoginButton();

        manage = homePage.navToAccountManagement();
        manage.navToAddresses();





        Assert.assertEquals(add.addItemDisplayed(), true);

    }

    @Test
    public void addAddressWithoutEmail(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */

        add.newAdd();
        add.setFirstName("Nour");
        add.setLastName("Alabgar");
        add.setCountry("Egypt");
        add.setCity("Cairo");
        add.setAdd("Cairo");
        add.setPostal("0000");
        add.setNum("00000000");
        add.save();

       error = add.getErrorMsg("E");


        Assert.assertTrue(error.contains("Email is required."));

    }

    @Test
    public void addAddressWithoutFName(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */

        add.newAdd();
        add.setLastName("Alabgar");
        add.setEmail("Nxxx@gmail.com");
        add.setCountry("Egypt");
        add.setCity("Cairo");
        add.setAdd("Cairo");
        add.setPostal("0000");
        add.setNum("00000000");
        add.save();

       error = add.getErrorMsg("F");





        Assert.assertTrue(error.contains("First name is required."));

    }

    @Test
    public void addAddressWithoutLName(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */

        add.newAdd();
        add.setFirstName("Nour");
        add.setEmail("Nxxx@gmail.com");
        add.setCountry("Egypt");
        add.setCity("Cairo");
        add.setAdd("Cairo");
        add.setPostal("0000");
        add.setNum("00000000");
        add.save();

        error = add.getErrorMsg("L");





        Assert.assertTrue(error.contains("Last name is required"));

    }

    @Test
    public void addAddressWithoutCountry(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */

        add.newAdd();
        add.setFirstName("Nour");
        add.setLastName("Alabgar");
        add.setEmail("Nxxx@gmail.com");
        add.setCity("Cairo");
        add.setAdd("Cairo");
        add.setPostal("0000");
        add.setNum("00000000");
        add.save();
         error = add.getErrorMsg("Country");





        Assert.assertTrue(error.contains("Country is required."));


    }

    @Test
    public void addAddressWithoutPhone(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */

        add.newAdd();
        add.setFirstName("Nour");
        add.setLastName("Alabgar");
        add.setEmail("Nxxx@gmail.com");
        add.setCountry("Egypt");
        add.setCity("Cairo");
        add.setAdd("Cairo");
        add.setPostal("0000");
        add.save();

       error = add.getErrorMsg("Num");




        Assert.assertTrue(error.contains("Phone is required"));

    }

    @Test
    public void addAddressWithoutPostal(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */

        add.newAdd();
        add.setFirstName("Nour");
        add.setLastName("Alabgar");
        add.setEmail("Nxxx@gmail.com");
        add.setCountry("Egypt");
        add.setCity("Cairo");
        add.setAdd("Cairo");
        add.setNum("00000000");
        add.save();




       error = add.getErrorMsg("P");

        Assert.assertTrue(error.contains("Zip / postal code is required"));

    }


    @Test
    public void addAddressWithoutAddress(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */

        add.newAdd();
        add.setFirstName("Nour");
        add.setLastName("Alabgar");
        add.setEmail("Nxxx@gmail.com");
        add.setCountry("Egypt");
        add.setCity("Cairo");
        add.setPostal("0000");
        add.setNum("00000000");
        add.save();


        error = add.getErrorMsg("Add");


        Assert.assertTrue(error.contains("Street address is required"));


    }

    @Test

    public void addAddressWithoutCity(){

        /*
         * Navigate to account management
         * Navigate to Addresses
         * Click on add btn
         * fill fields
         * submit
         * assert
         * */

        add.newAdd();
        add.setFirstName("Nour");
        add.setLastName("Alabgar");
        add.setEmail("Nxxx@gmail.com");
        add.setCountry("Egypt");
        add.setAdd("Cairo");
        add.setPostal("0000");
        add.setNum("00000000");
        add.save();

        error = add.getErrorMsg("City");


        Assert.assertTrue(error.contains("City is required"));

    }





}
