package Benekiva.HLC.FHD;

import BaseClass.TestBase;
import Utility.ReadJsonData;
import helper.Genetrate_Quote.GenerateQuote;
import helper.Policy_Search.PolicySearch;
import helper.Verification.AssertionHelper;
import helper.Verification.Wait_Helper_Page;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Hlc_Fhd_Generate_Quote extends TestBase {
    Wait_Helper_Page waitHelperPage;
    String errorImage;

    public Hlc_Fhd_Generate_Quote(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelperPage=new Wait_Helper_Page(driver,10);
    }

    @FindBy(xpath = "//input[@id='funeralAmount']")
    public WebElement TextFuneralBillAmount;



    /*
        Generate Quote
     */
    @FindBy(xpath = "//span[contains(text(),'[None Selected]')]")
    WebElement Cause;
    @FindBy(xpath = "//mat-option[@role='option']/span[contains(text(),'ACCIDENTAL')]")
    WebElement Text_Accidental;

    /*
        Date of Birth
     */

    @FindBy(xpath = "//div[starts-with(@class,'content ng-tns')]/form/div[4]/fuse-input-date-control/mat-datepicker-toggle/button/span[1]/*[name()='svg']")
    WebElement CalendarIcon;

    @FindBy(xpath = "//*[@id='wrapper']/div/fuse-content/fuse-policy-quote/div/div[2]/fuse-quote-screen-sidenav/div/div/div/form/div[3]/fuse-input-date-control/mat-datepicker-toggle/button/span[1]")
    WebElement YearIcon;

    @FindBy(xpath = "//tbody[starts-with(@class,'mat-calendar-body')]/tr[2]/td[4]")
    WebElement YearList;

    @FindBy(xpath = "//div[starts-with(@class,'mat-datepicker-content')]/mat-calendar/div/mat-year-view/table/tbody/tr[2]/td[2]")
    WebElement Month;

    @FindBy(xpath = "//tbody[starts-with(@class,'mat-calendar-body')]/tr[3]/td[3]/div")
    WebElement Day;

    @FindBy(xpath = "//input[@id='v_datDeath']")
    WebElement Date_of_Death;

    @FindBy(xpath = "//input[@id='userProvidedDOB']")
    WebElement DOB;

    @FindBy(xpath = "//input[@id='contractNumber']")
    WebElement TextContactNumber;

    @FindBy(xpath = "//span[contains(text(),'GENERATE QUOTE')]")
    WebElement Generate_Quote_Button;

    @FindBy(xpath = "//input[@id='funeralAmount']")
    WebElement Text_Bill_Amount;

    /*
        Error
     */

    @FindBy(xpath = "//mat-dialog-container[starts-with(@class,'mat-dialog-container ng-tns-c27-32 ng-trigger ng-trigger-dialogContainer')]/fuse-app-error-dialog/mat-dialog-content/p")
    WebElement Error_Generate;

    @FindBy(xpath = "//span[contains(text(),'CLOSE')]")
    WebElement CloseButton;



    public void Click_Begin_Claim(){
        new PolicySearch(driver).Begin_Claim.click();
        waitHelperPage.Go_to_Wait_for_Element(Cause);
        AssertionHelper.Verify_the_an_Element(Cause);
    }


    public void Click_Cause_of_Death(){
        Cause.click();
        String text= Text_Accidental.getText();
        System.out.println(text);
        Text_Accidental.click();
    }

    public void Enter_Bill_Amount(){
        boolean isDisplayed=true;

        try {
            isDisplayed=Text_Bill_Amount.isDisplayed();
            System.out.println("Element is Displayed");
            Text_Bill_Amount.click();
            Text_Bill_Amount.sendKeys("11.11");
        }
        catch (Exception ex){
            System.out.println("Element is not Found:-"+ex);
        }

    }

    public void Enter_Date_of_Death() throws IOException, ParseException {
        Date_of_Death.sendKeys(new ReadJsonData().ReadJSONData("Date-of-Death"));
    }

    public void Enter_Date_of_Birth() throws IOException, ParseException, InterruptedException {
       DOB.sendKeys(new ReadJsonData().ReadJSONData("DOB"));
    }

    public void Contact_Number() throws IOException, ParseException {
        TextContactNumber.sendKeys(new ReadJsonData().ReadJSONData("Phone"));
    }

    public void Click_Generate_Quote_Button(){
        Generate_Quote_Button.click();
        waitHelperPage.Go_to_Wait_for_Element(CloseButton);

        try {
            Error_Generate.isDisplayed();
            TestBase.captureScreenshot(errorImage);
            CloseButton.click();
            Thread.sleep(3000);
        }
        catch (Exception ex)
        {
            System.out.println("Element is not Displayed");
        }

        /*if (Error_Generate.isDisplayed()){
            TestBase.captureScreenshot(errorImage);
            CloseButton.click();
        }
        else {
            System.out.println("Element is not Displayed");
        }*/


    }

}
