package computers;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComputersPage;

public class ComputersTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(ComputersTest.class);

    @Test
    public void VerifyComputersPageDisplayedTest(){
        ComputersPage computersPage = homePage.getSideBar().clickOnComputersSideLink() ;
        Assert.assertTrue(computersPage.getPageTitleElement().contains("Computers"));
    }
}
