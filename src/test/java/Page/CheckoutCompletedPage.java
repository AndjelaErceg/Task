package Page;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutCompletedPage extends BaseTest {

    @FindBy (xpath = "//h2[contains(text(),\"THANK YOU FOR YOUR ORDER\")]")
    WebElement displayedMessageElement;

    public CheckoutCompletedPage(){PageFactory.initElements(driver,this);}

    public boolean successfulDisplayedMessage(){
        wdWait.until(ExpectedConditions.visibilityOf(displayedMessageElement));
        return displayedMessageElement.isDisplayed();
    }

 public String orderMessageGetText (){
        wdWait.until(ExpectedConditions.visibilityOf(displayedMessageElement));
        return displayedMessageElement.getText();
    }
}
