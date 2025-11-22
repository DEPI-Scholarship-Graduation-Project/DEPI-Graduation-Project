package pages;

import components.HeaderBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.ConfigReader;
import utility.ElementWaitUtility;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    WebDriver driver ;
    HeaderBar headerBar ;
    ElementWaitUtility elementWaitUtility ;


    private final By searchResultProductsTitle = By.cssSelector(".search-results .item-box .details .product-title a");






    private final Logger logger = LoggerFactory.getLogger(SearchPage.class);



    public SearchPage(WebDriver driver) {
        this.driver = driver;
        headerBar = new HeaderBar(driver);
        elementWaitUtility = new ElementWaitUtility(driver);
    }
    public List<String> getSearchResultProducts() {
       List <WebElement> searchResultProducts = driver.findElements(searchResultProductsTitle);
       List<String> searchResultProductsTitle = new ArrayList<String>();
       for (WebElement searchResultProduct : searchResultProducts) {
           searchResultProductsTitle.add(searchResultProduct.getText());
       }
       return searchResultProductsTitle;
    }
    public boolean verifyIfFound(List<String> searchResultProductsTitle, String expectedProductTitle) {
        boolean found = false;
        for (String actualResultProductTitle : searchResultProductsTitle) {
            expectedProductTitle = expectedProductTitle.toLowerCase();
            actualResultProductTitle = actualResultProductTitle.toLowerCase();
            if (actualResultProductTitle.contains(expectedProductTitle)) {
                found = true;
                break;
            }
        }
        return found;
    }





    public HeaderBar getHeaderBar() {
        return headerBar;
    }
}
