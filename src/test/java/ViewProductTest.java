import base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SearchPage;
import pages.ViewProductPage;
import utility.JsonReader;

import java.util.List;

public class ViewProductTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(ViewProductTest.class);



    @DataProvider(name = "productsData")
    public Object[][] productDataProvider() {
        return JsonReader.getJsonData(
                "src/test/resources/testdata/productsData.json",
                "productTests"
        );
    }


    @Test(dataProvider = "productsData")
    public void viewProductTest(JsonNode data) {
        String expectedProductTitle = data.get("productTitle").asText();
        String expectedProductResult = data.get("result").asText();

        SearchPage searchPage = homePage.getHederBar().searchProduct(expectedProductTitle);

        List<String> searchResultProductsTitle = searchPage.getSearchResultProducts();

        SoftAssert softAssert = new SoftAssert();
        boolean isFound = searchPage.verifyIfFound(searchResultProductsTitle, expectedProductTitle) ;

        if(isFound && expectedProductResult.equalsIgnoreCase("found")){
            // expected product title
            String searchResultProductTitle = searchResultProductsTitle.get(0);

            // get first product and click the title
            ViewProductPage viewProduct = searchPage.clickOnProductTitle(searchResultProductTitle);

            String actualProductTitle = viewProduct.getProductTitle();

            // assert the endpoint of the url equal to the expected product title
            Assert.assertTrue(actualProductTitle.contains(searchResultProductTitle));
        }else {
            Assert.assertTrue(searchResultProductsTitle.isEmpty());
        }

        softAssert.assertAll();
    }
}

