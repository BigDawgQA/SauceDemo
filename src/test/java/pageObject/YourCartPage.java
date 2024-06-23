package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage{

    //WebDriver driver;

    public YourCartPage(WebDriver driver){

        super(driver);

    }


    @FindBy(xpath="//button[@id='continue-shopping']") WebElement continueShoppingButton;
    @FindBy(xpath="//button[@id='checkout']") WebElement checkoutButton;


    public void clickCheckOutButton(){
        checkoutButton.click();

    }

}
