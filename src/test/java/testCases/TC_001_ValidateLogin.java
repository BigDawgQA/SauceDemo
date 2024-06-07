package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import testBase.TestBase;

public class TC_001_ValidateLogin extends TestBase {


    @Test(groups = {"sanity", "master"})
    public void validLogin(){

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
//        logger.info("*** Starting Test ***");

        LoginPage lp = new LoginPage(driver);

        logger.info("*** Inputting username ***");
        lp.setTxt_username(p.getProperty("username"));

        logger.info("*** Inputting Password ***");
        lp.setTxt_password(p.getProperty("password"));

        logger.info("*** Clicking Login Button ***");
        lp.clickLoginButton();

        logger.info("*** Validating Login ***");
        Assert.assertTrue(lp.isProductLogoDisplayed());

        logger.info("*** Complete Login ***");
    }




}
