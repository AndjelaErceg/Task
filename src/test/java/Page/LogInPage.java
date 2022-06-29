package Page;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BaseTest {

    @FindBy (id = "user-name")
    WebElement userNameElement;

    @FindBy (id = "password")
    WebElement passwordElement;

    @FindBy (id = "login-button")
    WebElement logInButtonElement;

    @FindBy (xpath = "//h3[contains(text(),\"Epic sadface: Sorry, this user has been locked out.\")]")
    WebElement sadFaceMessageElement;

    public LogInPage(){PageFactory.initElements(driver,this);}

    public LogInPage fillInUserName (String userName){
        wdWait.until(ExpectedConditions.visibilityOf(userNameElement));
        userNameElement.clear();
        userNameElement.sendKeys(userName);
        return this;
    }
    public LogInPage fillInPassword (String password){
        wdWait.until(ExpectedConditions.visibilityOf(passwordElement));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        return this;
    }
    public void clickOnLogInButton(){
        wdWait.until(ExpectedConditions.elementToBeClickable(logInButtonElement));
        logInButtonElement.click();

    }

    public boolean messageIsShown(){
        wdWait.until(ExpectedConditions.visibilityOf(sadFaceMessageElement));
        return sadFaceMessageElement.isDisplayed();
    }
    public String getSadMessageText(){
        wdWait.until(ExpectedConditions.visibilityOf(sadFaceMessageElement));
        return sadFaceMessageElement.getText();
    }

}
