package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutCompletePage extends BasePage{

    //WebDriver driver;

    public CheckOutCompletePage(WebDriver driver){

        super(driver);
    }


    @FindBy(xpath="//button[@id='back-to-products']") WebElement btn_BackHome;
    @FindBy(xpath="//h2[normalize-space()='Thank you for your order!']") WebElement thankYouForYourOrder;


    public boolean isThankYouIconDisplayed(){

        try{
            return thankYouForYourOrder.isDisplayed();
        }
        catch (Exception e){
            return  false;
        }


    }

}
