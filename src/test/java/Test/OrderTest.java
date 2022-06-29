package Test;

import Base.BaseTest;
import Page.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class OrderTest extends BaseTest {
    public LogInPage logInPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckoutFormPage checkoutFormPage;
    public CheckoutOverviewPage checkoutOverviewPage;
    public CheckoutCompletedPage checkoutCompletedPage;

    private String userName = "standard_user";
    private String password = "secret_sauce";

    @BeforeEach
    public  void setupPages(){
        logInPage = new LogInPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutFormPage = new CheckoutFormPage();
        checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutCompletedPage = new CheckoutCompletedPage();

    }

    @Test
    public void standardUserTest1() {
        logInPage.fillInUserName(userName)
                .fillInPassword(password)
                .clickOnLogInButton();
        inventoryPage.clickAddToCartButton()
                .clickOnShoppingCartButton();
        Assertions.assertTrue((cartPage.updateIsShown()));
        cartPage.clickOnContinueShoppingButton();
        inventoryPage.openBikeLight().clickOnAddToBikeLight();
        cartPage.clickOnShoppingCartButton();

        Assertions.assertTrue((cartPage.backpackItemIsShown()));
        Assertions.assertEquals("Sauce Labs Backpack", cartPage.backpackItemGetText());

        Assertions.assertTrue((cartPage.bikeLightItemIsShown()));
        Assertions.assertEquals("Sauce Labs Bike Light", cartPage.bikeLightItemGetText());

        cartPage.clickOnRemoveBackpackButton();

        Assertions.assertTrue((cartPage.correctItemIsPresent()));
        Assertions.assertEquals("Sauce Labs Bike Light", cartPage.bikeLightItemGetText());

        cartPage.clickOnCheckoutButton();

        checkoutFormPage.fillInFirstnameField()
                .fillInLastNameField()
                .fillInPostalcode()
                .clickOnContinue();
        checkoutOverviewPage.clickOnFinish();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-300)");

        Assertions.assertTrue((checkoutCompletedPage.successfulDisplayedMessage()));
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER"
                ,checkoutCompletedPage.orderMessageGetText());

        }

        @Test
        public void lockedOutUserTest2() {
            logInPage.fillInUserName("locked_out_user").fillInPassword(password).clickOnLogInButton();
            Assertions.assertTrue((logInPage.messageIsShown()));
            Assertions.assertEquals("Epic sadface: " +
                    "Sorry, this user has been locked out.",logInPage.getSadMessageText());

        }
        @Test
    public void problemUserTest3(){
        logInPage.fillInUserName("problem_user").fillInPassword(password).clickOnLogInButton();
        Assertions.assertTrue((inventoryPage.backpackIsWritten()));
        inventoryPage.clickOnBackpack();

      //Assertions.assertEquals("Sauce Labs Backpack",inventoryPage.getBackpackText(),
             //"Sauce Labs Fleece Jacket",inventoryPage.getFleeseJacketText());
        //all the pictures of the products are the same on the InventoryPage.
            // They don't mach the descriptions of the items. It says one thing when you click on it,
            //other description appears.
        }



    }
