import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utility.DataGenerator;

import java.util.ArrayList;
import java.util.List;


public class PlaceOrderE2ETest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(PlaceOrderE2ETest.class);



    @Test
    public void addProductToCart(){
        //login
        LoginPage loginPage = homePage.getHederBar().clickOnLoginLink();
        loginPage.enterUserEmail("testaffaires8@gmail.com");
        loginPage.enterPassword("Demo-shop-1234");
        homePage = loginPage.clickLoginButton() ;

        // create list of products title
        List<String> productsTitle = new ArrayList<String>();
        productsTitle.add("Build your own cheap computer");
        productsTitle.add("notFound");
        productsTitle.add("14.1-inch Laptop");
        productsTitle.add("Build your own expensive computer");

        // search about products and add to cart [if found]
        SearchPage searchPage ;
        ViewProductPage viewProductPage = null ;

        for (String productTitle : productsTitle) {
            searchPage = homePage.getHederBar().searchProduct(productTitle);
            List<String> searchResultProductsTitle = searchPage.getSearchResultProducts() ;
            if(searchPage.verifyIfFound(searchResultProductsTitle, productTitle)){

                viewProductPage =  searchPage.clickOnProductTitle(productTitle) ;
                // change quantity  of product randomly
                viewProductPage.changeQuantity(DataGenerator.randomInt(1, 4));
                viewProductPage.clickOnAddToCartButton();
            }
        }

        //open cart & validate
        if (viewProductPage != null) {
            // buy cart & place an order
            CartPage cartPage = viewProductPage.clickOnToastLink();
            cartPage.clickOnTermsOfService();
            CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();
            checkoutPage.clickOnContinueButton();
            CompletePage completePage = checkoutPage.clickOnConfirmButton() ;


            // Assert through order number

            //get order number from href vale
            String href = completePage.getOrderContainer() ;
            String expectedOrderNumber = completePage.getOrderNumber(href);

            //click on order link
            OrderDetails orderDetails = completePage.clickOnOrderLink();
            String actualOrderNumber = orderDetails.getOrderNumber();

            //assert order number found in profile order details page
            Assert.assertTrue(actualOrderNumber.contains(expectedOrderNumber));

            //logout
            homePage = orderDetails.getHeaderBar().clickOnLogOutLink();
        }
    }


}

