package Benekiva.HLC.FHD;

import BaseClass.TestBase;
import helper.Verification.AssertionHelper;
import helper.Verification.Wait_Helper_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Dashboard extends TestBase {
    Wait_Helper_Page waitHelperPage;

    public Dashboard(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelperPage=new Wait_Helper_Page(driver,10);
    }

    @FindBy(xpath = "//span[starts-with(@class,'remember-me')]")
    WebElement Application_Version;

    @FindBy(xpath = "//h1[contains(text(),'LOGIN TO YOUR ACCOUNT')]")
    public WebElement LoginPage;

    @FindBy(xpath = "//div[contains(text(),'Payment Overview')]")
    public WebElement TextPaymentOverview;

    @FindBy(xpath = "//div[starts-with(@class,'total-value')]")
    public WebElement DollarValue;


    public void LoginPageIsDisplayed(){
        waitHelperPage.Go_to_Wait_for_Element(LoginPage);
        AssertionHelper.verifyElementPresent(LoginPage);
        AssertionHelper.verifyTextEquals(new Dashboard(driver).LoginPage,"LOGIN TO YOUR ACCOUNT");
    }

    public String Hlc_Version_Application(){
        waitHelperPage.Go_to_Wait_for_Element(Application_Version);
        return Application_Version.getText();
    }
    public String PaymentOverview(){
        return TextPaymentOverview.getText();
    }

    public String CheckDollar(){
        waitHelperPage.Go_to_Wait_for_Element(DollarValue);
        AssertionHelper.verifyElementPresent(DollarValue);
        return DollarValue.getText();

    }
}
