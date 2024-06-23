package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends BasePage{

    //WebDriver driver;

    public ProductPage(WebDriver driver) {

        super(driver);
    }


    @FindBy(xpath = "//div[@class='inventory_item']//button[text()='Add to cart']")
    List<WebElement> itemsAddToCartButton;

    @FindBy(xpath = "//div[@class='inventory_item']//button[text()='Remove']")
    List<WebElement> itemRemoveButton;

    @FindBy(xpath = ("//select[@class='product_sort_container']")) WebElement filterButton;  //select element

    @FindBy(xpath = "//div/a[@class='shopping_cart_link']/span[text()='6']") WebElement cartIconNumber;

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a") WebElement cartIcon;


    public void sortProductsItems(){

        Select select = new Select(filterButton);
        select.selectByIndex(3);
    }

    public void addSixItems(){

//        for(int i=0; i<3; i++){
//
//            itemsAddToCartButton.get(i).click();
//        }
        for(var e: itemsAddToCartButton){

            e.click();
        }


    }

    public boolean checkSixItemsAddedToCart(){

        int sizeOfRemoveButton = itemRemoveButton.size();

        String addCartItems = cartIconNumber.getText();
        int intCartIconsNumber = Integer.parseInt(addCartItems);

        return (sizeOfRemoveButton == intCartIconsNumber);
    }

    public void clickFilterButton(){

        cartIcon.click();
    }

}
