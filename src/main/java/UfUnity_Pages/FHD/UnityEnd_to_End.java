package UfUnity_Pages.FHD;

import BaseClass.TestBase;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import Utility.TakeScreenshot;
import helper.Pages.DropDown;
import helper.Pages.JavaScriptHelper;
import helper.Pages.Signature;
import helper.Pages.Upload;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class UnityEnd_to_End extends TestBase {

    WaitHelper waitHelper;
    DropDown objDropDownHelper;
    ReadJsonData readJsonData;
    Upload uploadHelper;
    JavaScriptHelper javaScriptHelper;
    Signature signatureHelper;
    public UnityEnd_to_End(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,10);
        readJsonData=new ReadJsonData();
        uploadHelper=new Upload(driver);
        javaScriptHelper=new JavaScriptHelper(driver);
    }

    @FindBy(xpath = "//input[@data-placeholder='How much is the funeral bill amount?']")
    WebElement Funeral_Bill_Amount;

    @FindBy(xpath = "//span[contains(text(),' GENERATE QUOTE ')]")
    WebElement GenetrateButton;


    @FindBy(xpath = "//font[@face='Arial']")
    WebElement DisclaimerXpath;

    @FindBy(xpath = "//button[@aria-label='Start Claim']")
    WebElement StartClaimXpath;

    @FindBy(xpath = "//span[contains(text(),'CLOSE')]")
    WebElement Close;



    public void Enter_Bill_Amount(String bill){
        waitHelper.waitForElement(GenetrateButton);
        Funeral_Bill_Amount.click();
        Funeral_Bill_Amount.sendKeys(bill);
        GenetrateButton.click();

        boolean isDisplayed=true;

        try {
            new WaitHelper(driver,10).waitForElement(Close);
            Close.isDisplayed();

            new TakeScreenshot().captureScreenshot("Error.jpg");
            Close.click();
            new AccountVerification(driver).Logout_from_Application();
        }
        catch (Exception e){
            System.out.println("Element is not found:-"+e);

        }

    }

    public void Error(){
        boolean isDisplayed=true;

        try {
            new WaitHelper(driver,10).waitForElement(Close);
            Close.isDisplayed();
            new TakeScreenshot().captureScreenshot("Error");
            Close.click();
            waitHelper.waitForElement(new AccountVerification(driver).LogoutArrow);
        }
        catch (Exception e){
            System.out.println("Element is not found:-"+e);

        }
    }




}
