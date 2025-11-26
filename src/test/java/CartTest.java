import base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
import pages.*;
import utility.DataGenerator;
import utility.JsonReader;

import java.util.List;

public class CartTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(CartTest.class);




    @DataProvider(name = "productsData")
    public Object[][] productDataProvider() {
        return JsonReader.getJsonData(
                "src/test/resources/testdata/productsData.json",
                "productTests"
        );
    }


    @Test(dataProvider = "productsData")
    public void addToCartTest(JsonNode data) {
        String expectedProductTitle = data.get("productTitle").asText();
        String expectedProductResult = data.get("result").asText();

        SearchPage searchPage = homePage.getHederBar().searchProduct(expectedProductTitle);

        List<String> searchResultProductsTitle = searchPage.getSearchResultProducts();

        SoftAssert softAssert = new SoftAssert();
        boolean isFound = searchPage.verifyIfFound(searchResultProductsTitle, expectedProductTitle) ;

        if(expectedProductResult.equalsIgnoreCase("empty")){
            Assert.assertTrue(searchResultProductsTitle.isEmpty());
        }else if(isFound && expectedProductResult.equalsIgnoreCase("found")){

            // expected product title
            String searchResultProductTitle = searchResultProductsTitle.get(0);
            ViewProductPage viewProduct = searchPage.clickOnProductTitle(searchResultProductTitle);
            String actualProductTitle = viewProduct.getProductTitle();
            Assert.assertTrue(actualProductTitle.contains(searchResultProductTitle));

            // click on add to cart button
            viewProduct.changeQuantity(DataGenerator.randomInt(1, 4));
            viewProduct.clickOnAddToCartButton();
            Assert.assertTrue(viewProduct.isToastCartLinkVisible());

//            CartPage cartPage = viewProduct.clickOnToastLink();
//            Assert.assertTrue(cartPage.getPageTitleElement().isDisplayed());
//
//            // assert the cart items list contains the last add item
//            List<String> cartProductsTitle = cartPage.getCartProductsTitle();
//            Assert.assertTrue(cartProductsTitle.contains(actualProductTitle));


        }else if(!isFound && expectedProductResult.equalsIgnoreCase("found")){
            Assert.assertFalse(searchResultProductsTitle.isEmpty());
        }else{
            Assert.assertTrue(searchResultProductsTitle.isEmpty());
        }
        softAssert.assertAll();
    }



    // add test cases with priority 2 to open cart from header link
    @Test(priority = 2)
    public void openCartFromHeaderLinkTest() {
        CartPage cartPage = homePage.getHederBar().clickOnCartLink();
        Assert.assertTrue(cartPage.getPageTitleElement().isDisplayed());
    }

}


