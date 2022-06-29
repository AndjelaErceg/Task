package Page;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutFormPage extends BaseTest {

    @FindBy (id = "first-name")
    WebElement firstNameFieldElement;

    @FindBy (name = "lastName")
    WebElement lastNameFieldElement;

    @FindBy (name = "postalCode")
    WebElement postalCodeElement;

    @FindBy (id = "continue")
    WebElement continueButtonElement;


    public CheckoutFormPage(){PageFactory.initElements(driver,this);}

    public CheckoutFormPage fillInFirstnameField(){
        wdWait.until(ExpectedConditions.visibilityOf(firstNameFieldElement));
        firstNameFieldElement.clear();
        firstNameFieldElement.sendKeys("Aa 3#?");
        return this;
    }
    public CheckoutFormPage fillInLastNameField(){
        wdWait.until(ExpectedConditions.visibilityOf(lastNameFieldElement));
        lastNameFieldElement.clear();
        lastNameFieldElement.sendKeys("prezime");
        return this;
    }

    public CheckoutFormPage fillInPostalcode (){
        wdWait.until(ExpectedConditions.visibilityOf(postalCodeElement));
        postalCodeElement.clear();
        postalCodeElement.sendKeys("2@ Ad/");
        return this;
    }

    public void clickOnContinue(){
        wdWait.until(ExpectedConditions.visibilityOf(continueButtonElement));
        continueButtonElement.click();
    }


}
