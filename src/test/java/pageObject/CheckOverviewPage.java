package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOverviewPage extends BasePage{

    WebDriver driver;

    public CheckOverviewPage(WebDriver driver){

        super(driver);

    }


    @FindBy(xpath="//button[@id='finish']") WebElement btn_finish;
    @FindBy(xpath="//button[@id='cancel']") WebElement btn_cancel;


    public void clickFinishButton(){
        btn_finish.click();

    }
    public void clickCancelButton(){
        btn_cancel.click();

    }

}
