package helper.Payment;

import BaseClass.TestBase;
import helper.Inbox.InboxSetup;
import helper.Verification.AssertionHelper;
import helper.Verification.Wait_Helper_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentSetup extends TestBase {
    static String errorImage;

    Wait_Helper_Page waitHelperPage;
    public PaymentSetup(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelperPage=new Wait_Helper_Page(driver,10);
    }


    @FindBy(xpath = "//span[contains(text(),'Pending Review')]")
    WebElement PaymentReviewText;

    /*
        Assign to me
     */

    @FindBy(xpath = "//div[contains(text(),'ASSIGN TO ME')]")
    public WebElement Assign_to_me_tab;

    @FindBy(xpath = "//span[contains(text(),'CONFIRM')]")
    WebElement ConfirmButton;

    /*
        Approve
     */

    @FindBy(xpath = "//div[contains(text(),'APPROVE')]")
    WebElement Approve_Tab;

    @FindBy(xpath = "//span[contains(text(),'Ready To Pay')]")
    WebElement Check_status_Ready_to_Pay;

    /*
        Payment
     */
    @FindBy(xpath = "//div[contains(text(),'PAYMENT')]")
    WebElement Payment_tab;

    /*
        Terminate and Pay
     */
    @FindBy(xpath = "//div[contains(text(),'TERMINATE & PAY')]")
    WebElement TerminatePay;

    @FindBy(xpath = "//div[contains(text(),'MARK SETTLED')]")
    WebElement MarkSettled;

    /*
        Error
     */
    @FindBy(xpath = "//div[starts-with(@id,'cdk-overlay')]/mat-dialog-container/fuse-app-error-dialog/mat-dialog-content")
    WebElement Error;

    @FindBy(xpath = "//span[contains(text(),'CLOSE')]")
    WebElement CLose_Button;

    /*
        Settled
     */

    @FindBy(xpath = "(//span[contains(text(),'Settled')])[2]")
    WebElement Settled_Text;

    /*
        Add New Internal Note
     */

    @FindBy(xpath = "//*[@id='edit']/div[2]/div/div")
    WebElement Add_New_Internal_note;

    @FindBy(xpath = "//span[starts-with(@class,'fr-placeholder')]")
    WebElement TextNote;

    @FindBy(xpath = "//*[@id='forms']/div[2]/button")
    WebElement Submit_button;




    public void Check_Payment_Review_Status(){
        waitHelperPage.Go_to_Wait_for_Element(PaymentReviewText);
        AssertionHelper.verifyElementPresent(PaymentReviewText);
        AssertionHelper.verifyTextEquals(PaymentReviewText,"Pending Review");
    }

    public void Go_to_Assign_me_tab(){
        waitHelperPage.Go_to_Wait_for_Element(Assign_to_me_tab);
        Assign_to_me_tab.click();
        waitHelperPage.Go_to_Wait_for_Element(ConfirmButton);
        ConfirmButton.click();
        waitHelperPage.Go_to_Wait_for_Element(new InboxSetup(driver).Text_Inbox_Tab);
        waitHelperPage.Go_to_Wait_for_Element(Approve_Tab);
    }

    public void Go_to_Approve_tab(){
        Approve_Tab.click();
        waitHelperPage.Go_to_Wait_for_Element(ConfirmButton);
        ConfirmButton.click();
    }

    public void Check_status_Ready_to_pay(){
        waitHelperPage.Go_to_Wait_for_Element(Check_status_Ready_to_Pay);
        AssertionHelper.Verify_the_an_Element(Check_status_Ready_to_Pay);
        AssertionHelper.verifyTextEquals(Check_status_Ready_to_Pay,"Ready To Pay");
    }

    public void Go_to_Payment(){
        waitHelperPage.Go_to_Wait_for_Element(Payment_tab);
        Payment_tab.click();
        waitHelperPage.Go_to_Wait_for_Element(TerminatePay);
        AssertionHelper.verifyElementPresent(TerminatePay);
        waitHelperPage.Go_to_Wait_for_Element(MarkSettled);
        AssertionHelper.verifyElementPresent(MarkSettled);
    }

    public void Go_to_Terminate_and_Pay() throws InterruptedException {
        waitHelperPage.Go_to_Wait_for_Element(TerminatePay);
        AssertionHelper.verifyElementPresent(TerminatePay);
        TerminatePay.click();

        try {
            waitHelperPage.Go_to_Wait_for_Element(Error);
            Error.isDisplayed();
            TestBase.captureScreenshot(errorImage);
            Thread.sleep(2000);
            CLose_Button.click();
            Thread.sleep(2000);
        }
        catch (Exception e){
            System.out.println("Element is not Displayed:-"+e);
            ConfirmButton.click();
            waitHelperPage.Go_to_Wait_for_Element(Payment_tab);
            waitHelperPage.Go_to_Wait_for_Element(new InboxSetup(driver).Text_Inbox_Tab);
            waitHelperPage.Go_to_Wait_for_Element(Settled_Text);
            AssertionHelper.verifyElementPresent(Settled_Text);
            AssertionHelper.verifyTextEquals(Settled_Text,"Settled");
        }
    }

    public void Add_Internal_Notes() throws InterruptedException {

        try {
            waitHelperPage.Go_to_Wait_for_Element(Add_New_Internal_note);
            Add_New_Internal_note.click();
            waitHelperPage.Go_to_Wait_for_Element(Submit_button);
            TextNote.sendKeys("This is a test internal Note");
            Submit_button.click();
            Thread.sleep(5000);
        }
        catch (Exception e) {
            System.out.println("Element is not Displayed:"+e);
        }
    }

}
