package checkout;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountManagement.Addresses;
import pages.AccountManagement.Manage;
import pages.Checkout;
import pages.LoginPage;

public class CheckoutTests extends BaseTest {

    LoginPage loginPage;
    Checkout process;
    String error;



    @BeforeMethod
    private void setManageSteps()
    {
        loginPage = homePage.clickOnLoginLink();
        loginPage.insertEmail("Nxxx@gmail.com");
        loginPage.insertPassword("Nxxx@gmail.com");
        loginPage.clickOnLoginButton();
        process = homePage.navToCart();





    }

    @AfterMethod
    private void closure()
    {
        homePage.clickOnLogoutLink();
    }

    @Test
    public void uncheckedTerms(){
        /*
        * log in
        * go to cart
        * uncheck the checkbox
        * start the process
        * */


        process.setCheckBtn();
        error = process.getTermsAlert();

        Assert.assertEquals(error, "Terms of service");

    }

    @Test
    public void successfulCheckout() throws InterruptedException{
        /*
         * go to cart
         * check the checkbox
         * start the process
         * complete the full process
         * checkout
         *
         * */

        process.setCheckBox();
        process.setCheckBtn();

        process.billing();
        process.shipping();
        process.shippingMethod("");
        process.paymentMethod("COD");
        process.payInfo("");
        process.cnf();
        error= process.getSuccessMsg();

        Assert.assertEquals(error, "Your order has been successfully processed!");

    }
}
