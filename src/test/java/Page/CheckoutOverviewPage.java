package Page;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutOverviewPage extends BaseTest {

    @FindBy (id = "finish")
    WebElement finishButtonElement;

    public CheckoutOverviewPage(){PageFactory.initElements(driver, this);}

    public void clickOnFinish(){
        wdWait.until(ExpectedConditions.visibilityOf(finishButtonElement));
        finishButtonElement.click();
    }
}
