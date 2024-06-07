package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutInfoPage extends BasePage{

    WebDriver driver;

    public CheckOutInfoPage(WebDriver driver){

        super(driver);

    }

    @FindBy(xpath="//input[@id='first-name']") WebElement input_firstName;
    @FindBy(xpath="//input[@id='last-name']") WebElement input_lastName;
    @FindBy(xpath="//input[@id='postal-code']") WebElement input_PostalCode;
    @FindBy(xpath="//input[@id='continue']") WebElement btn_continue;
    @FindBy(xpath="//button[@id='cancel']") WebElement btn_cancel;


    public void setFirstName(String firstName){
        input_firstName.sendKeys(firstName);

    }
    public void setLastName(String lastName){
        input_lastName.sendKeys(lastName);

    }
    public void setPostcode(String postcode){
        input_PostalCode.sendKeys(postcode);

    }
    public void clickContinueButton(){
        btn_continue.click();

    }

}
