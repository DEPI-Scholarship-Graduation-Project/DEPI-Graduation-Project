package products;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BooksPage;
import pages.CompareProductsPage;
import pages.ProductPage;
import pages.Reviewpage;

public class AddProductToCartWithoutLogin extends BaseTest {
    ProductPage productPage;
    BooksPage booksPage;
    Reviewpage reviewpage;
    CompareProductsPage compareProductsPage;
    @Test
    public void AddQuantitylessthan10000() throws InterruptedException {
       booksPage = homePage.selectBookproducts();
       productPage = booksPage.ClickOnProduct();
       productPage.InsertQuantity(10);
       productPage.ClickAddtoCart();
       Thread.sleep(2000);
       String ActualResult = productPage.getaddtocartMessage();
       String ExpectedResult = "The product has been added to your ";
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
    }
    @Test
    public void AddquantityGreaterthan10000() throws InterruptedException {
        booksPage = homePage.selectBookproducts();
        productPage = booksPage.ClickOnProduct();
        productPage.InsertQuantity(15000);
        productPage.ClickAddtoCart();
        Thread.sleep(2000);
        String Actualresult = productPage.getaddtocartMessage();
        String Expectedresult= "The maximum quantity allowed for purchase is 10000.";
        Assert.assertTrue(Actualresult.contains(Expectedresult));
    }
    @Test
    public void Notallowtoguestaddreview() throws InterruptedException {
        booksPage = homePage.selectBookproducts();
        productPage =booksPage.ClickOnProduct();
        reviewpage = productPage.Clickonaddreview();
        Thread.sleep(4000);
        boolean textisdisabled = reviewpage.Titleforreviewdisabled();
        Assert.assertFalse(textisdisabled);
    }
    @Test
    public void Guestaddproducttocompare()
    {
      booksPage=  homePage.selectBookproducts();
      productPage =booksPage.ClickOnProduct();
      compareProductsPage = productPage.CLickonComparebutton();
      Assert.assertEquals(compareProductsPage.Geturl(),"https://demowebshop.tricentis.com/compareproducts");



    }




}
