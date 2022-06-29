package Page;

import Base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BaseTest {
    @FindBy (css = ".shopping_cart_badge")
    WebElement shoppingCartBadgeButtonElement;

   @FindBy (id = "continue-shopping")
    WebElement continueShoppingButtonElement;

    @FindBy (id = "shopping_cart_container")
    WebElement shoppingCartButtonElement;

    @FindBy (id = "item_4_title_link")
    WebElement backpackItemElement;

    @FindBy (id = "item_0_title_link")
    WebElement bikeLightItemElement;

    @FindBy (id = "remove-sauce-labs-backpack")
    WebElement removeBackpackButtonElement;

    @FindBy (id = "checkout")
    WebElement checkoutButtonElement;

    public CartPage(){PageFactory.initElements(driver,this);}

    public boolean updateIsShown (){
        wdWait.until(ExpectedConditions.visibilityOf(shoppingCartBadgeButtonElement));
        return shoppingCartBadgeButtonElement.isDisplayed();
    }

    public void clickOnContinueShoppingButton(){
        wdWait.until(ExpectedConditions.visibilityOf(continueShoppingButtonElement));
        continueShoppingButtonElement.click();
    }

    public void clickOnShoppingCartButton(){
        wdWait.until(ExpectedConditions.visibilityOf(shoppingCartButtonElement));
        shoppingCartButtonElement.click();
    }

    public boolean backpackItemIsShown(){
        wdWait.until(ExpectedConditions.visibilityOf(backpackItemElement));
        return backpackItemElement.isDisplayed();
    }
    public String backpackItemGetText(){
        wdWait.until(ExpectedConditions.visibilityOf(backpackItemElement));
        return backpackItemElement.getText();
    }

    public boolean bikeLightItemIsShown(){
        wdWait.until(ExpectedConditions.visibilityOf(bikeLightItemElement));
        return bikeLightItemElement.isDisplayed();
    }
    public String bikeLightItemGetText(){
        wdWait.until(ExpectedConditions.visibilityOf(bikeLightItemElement));
        return bikeLightItemElement.getText();
    }

    public CartPage clickOnRemoveBackpackButton(){
        wdWait.until(ExpectedConditions.visibilityOf(removeBackpackButtonElement));
        removeBackpackButtonElement.click();
        return this;
    }
    public boolean correctItemIsPresent(){
        wdWait.until(ExpectedConditions.visibilityOf(bikeLightItemElement));
        return bikeLightItemElement.isDisplayed();
    }

    public String correctItemGetText(){
        wdWait.until(ExpectedConditions.visibilityOf(bikeLightItemElement));
        return bikeLightItemElement.getText();
    }

    public void clickOnCheckoutButton(){
        wdWait.until(ExpectedConditions.visibilityOf(checkoutButtonElement));
        checkoutButtonElement.click();
    }
}
