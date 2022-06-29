package Page;

import Base.BaseTest;
import io.github.bonigarcia.wdm.WdmAgent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage extends BaseTest {

    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartButtonElement;

    @FindBy (id = "shopping_cart_container")
    WebElement shoppingCartButtonElement;

    @FindBy (id = "item_0_img_link")
    WebElement bikeLightElement;

    @FindBy (id= "add-to-cart-sauce-labs-bike-light")
    WebElement addBikeLightElement;

    @FindBy (id = "item_4_title_link")
    WebElement backpackElement;

    @FindBy (css = ".inventory_details_img")
    WebElement fleeseJacketElement;

    @FindBy (xpath = "//div[contains(text(),\"Sauce Labs Fleece Jacket\")]")
    WebElement fleeseTextElement;

   // @FindBy (xpath = "//div[contains(text(),\"Sauce Labs Backpack\")]")
  //  WebElement backpackTextElement;


    public InventoryPage(){PageFactory.initElements(driver,this);}

    public InventoryPage clickAddToCartButton(){
        wdWait.until(ExpectedConditions.visibilityOf(addToCartButtonElement));
        addToCartButtonElement.click();
        return this;
    }
    public void clickOnShoppingCartButton(){
        wdWait.until(ExpectedConditions.visibilityOf(shoppingCartButtonElement));
        shoppingCartButtonElement.click();
    }

    public InventoryPage openBikeLight (){
        wdWait.until(ExpectedConditions.visibilityOf(bikeLightElement));
        bikeLightElement.click();
        return this;
    }

    public InventoryPage clickOnAddToBikeLight(){
        wdWait.until(ExpectedConditions.visibilityOf(addBikeLightElement));
        addBikeLightElement.click();
        return this;
    }

    public boolean backpackIsWritten(){
        wdWait.until(ExpectedConditions.visibilityOf(backpackElement));
        return backpackElement.isDisplayed();
    }

    public InventoryPage clickOnBackpack(){
        wdWait.until(ExpectedConditions.visibilityOf(backpackElement));
        backpackElement.click();
        return this;
    }
    public String getFleeseJacketText (){
        wdWait.until(ExpectedConditions.visibilityOf(fleeseTextElement));
        return fleeseTextElement.getText();
    }
    public String getBackpackText (){
        wdWait.until(ExpectedConditions.visibilityOf(backpackElement));
        return backpackElement.getText();
    }

}
