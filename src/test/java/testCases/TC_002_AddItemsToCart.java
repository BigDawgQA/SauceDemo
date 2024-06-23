package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import pageObject.ProductPage;
import testBase.TestBase;

public class TC_002_AddItemsToCart extends TestBase {

    @Test(groups = {"sanity", "master"})
    public void addSixItemsToCart(){

        //LoginPage
        LoginPage lp2 = new LoginPage(driver);
        lp2.setTxt_username(p.getProperty("username"));
        lp2.setTxt_password(p.getProperty("password"));
        lp2.clickLoginButton();



        ProductPage pp = new ProductPage(driver);

        pp.sortProductsItems();
        pp.addSixItems();

        Assert.assertTrue(pp.checkSixItemsAddedToCart());
        pp.clickFilterButton();




    }


}
