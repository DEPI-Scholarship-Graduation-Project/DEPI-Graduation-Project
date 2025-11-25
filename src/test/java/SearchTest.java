import base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SearchPage;
import utility.JsonReader;

import java.util.List;

public class SearchTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(SearchTest.class);



    @DataProvider(name = "productsData")
    public Object[][] productDataProvider() {
        return JsonReader.getJsonData(
                "src/test/resources/testdata/productsData.json",
                "productTests"
        );
    }


    @Test(dataProvider = "productsData")
    public void searchProductTest(JsonNode data) {
        String expectedProductTitle = data.get("productTitle").asText();
        String expectedProductResult = data.get("result").asText();
        SearchPage searchPage = homePage.getHederBar().searchProduct(expectedProductTitle);

        List<String> searchResultProductsTitle = searchPage.getSearchResultProducts();

        SoftAssert softAssert = new SoftAssert();
        boolean isFound = searchPage.verifyIfFound(searchResultProductsTitle, expectedProductTitle) ;

        if(expectedProductResult.equalsIgnoreCase("empty")){
            Assert.assertTrue(searchResultProductsTitle.isEmpty());
        }else if(expectedProductResult.equalsIgnoreCase("found")) {
            softAssert.assertTrue(isFound, "Expected product not found in search results: " + expectedProductTitle);
        }else if(!isFound && expectedProductResult.equalsIgnoreCase("found")){
            Assert.assertFalse(searchResultProductsTitle.isEmpty());
        }else{
            Assert.assertTrue(searchResultProductsTitle.isEmpty());
        }
        softAssert.assertAll();
    }
}

