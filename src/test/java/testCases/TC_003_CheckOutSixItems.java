package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.*;
import testBase.TestBase;

public class TC_003_CheckOutSixItems extends TestBase {

    @Test(groups = {"master"})
    public void checkOutSixItems(){

        //LoginPage
        LoginPage lp3 = new LoginPage(driver);
        lp3.setTxt_username(p.getProperty("username"));
        lp3.setTxt_password(p.getProperty("password"));
        lp3.clickLoginButton();


        ProductPage pp2 = new ProductPage(driver);
        pp2.sortProductsItems();
        pp2.addSixItems();
        Assert.assertTrue(pp2.checkSixItemsAddedToCart());
        pp2.clickFilterButton();


        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.clickCheckOutButton();

        CheckOutInfoPage checkOutInfoPage = new CheckOutInfoPage(driver);
        checkOutInfoPage.setFirstName(p.getProperty("customerFirstName"));
        checkOutInfoPage.setLastName(p.getProperty("customerLastName"));
        checkOutInfoPage.setPostcode(p.getProperty("postcode"));
        checkOutInfoPage.clickContinueButton();

        CheckOverviewPage checkOverviewPage = new CheckOverviewPage(driver);
        checkOverviewPage.clickFinishButton();


        CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage(driver);
        boolean isThankYouIconDisplayed = (checkOutCompletePage.isThankYouIconDisplayed());
        if(isThankYouIconDisplayed){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }


    }


}
