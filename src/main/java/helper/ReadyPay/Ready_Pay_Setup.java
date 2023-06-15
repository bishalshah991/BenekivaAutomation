package helper.ReadyPay;

import BaseClass.TestBase;
import helper.Beneficiaries.Beneficiaries_Setup;
import helper.Pages.DropDown;
import helper.Verification.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ready_Pay_Setup extends TestBase {
    WaitHelper waitHelper;
    public Ready_Pay_Setup(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'APPROVE')]")
    public WebElement ApproveTab;

    @FindBy(xpath = "//span[contains(text(),'CONFIRM')]")
    public WebElement ConfirmButton;

    @FindBy(xpath = "//div[contains(text(),'PAYMENT')]")
    public WebElement PaymentTab;

    @FindBy(xpath = "//div[contains(text(),'PAYEES')]")
    WebElement PayeesTab;

    @FindBy(xpath = "//div[@id='forms']/mat-tab-group/div/mat-tab-body[1]/div/div/mat-table/mat-row[1]/mat-cell[7]/button[2]/span[1]")
    WebElement ActionTick;

    /*
        Remarks
     */
    @FindBy(xpath = "//div[contains(text(),'REMARKS')]")
    WebElement RemarksTab;

    @FindBy(xpath = "//input[@placeholder='Pick or type a reason']")
    WebElement PickTypeReason;

    @FindBy(xpath = "//span[contains(text(),'Select a category')]")
    WebElement SelectCategory;

    @FindBy(xpath = "//div[contains(text(),'TERMINATE & PAY')]")
    public WebElement Terminate_And_Pay;

    @FindBy(xpath = "//div[contains(text(),'MARK SETTLED')]")
    WebElement MarkSettled;

    @FindBy(xpath = "//textarea[@id='reason']")
    WebElement Mark_Settled_Reason;

    @FindBy(xpath = "//*[@id='caseload']/fuse-action-panel/div/div/div[2]/button[5]/span[1]/mat-icon")
    WebElement Export_Claim_Packet;

    @FindBy(xpath = "//textarea[@placeholder='Enter Note']")
    WebElement EnterNote;

    public void Wait_for_Approve_Tab(){
        waitHelper.waitForElement(driver,ApproveTab,10);

    }
    public void Click_Approve() throws InterruptedException {
        waitHelper.waitForElement(driver,ApproveTab,10);
        ApproveTab.click();
        Thread.sleep(3000);
        waitHelper.waitForElement(driver,ConfirmButton,10);
        ConfirmButton.click();
        Thread.sleep(3000);
        waitHelper.waitForElement(driver,PaymentTab,10);
    }

    public void Click_Payment_Tab() throws InterruptedException {
        PaymentTab.click();
        Thread.sleep(3000);
        waitHelper.waitForElement(driver,ApproveTab,10);
    }

    public void Go_to_Payees() throws InterruptedException {
        waitHelper.waitForElement(driver,PayeesTab,10);
        PayeesTab.click();
        Thread.sleep(3000);
        waitHelper.waitForElement(driver,new Beneficiaries_Setup(driver).Beneficiaries_Box,10);
        ActionTick.click();
        Thread.sleep(3000);
        waitHelper.waitForElement(driver,PayeesTab,10);
    }

    public void Go_to_Remarks() throws InterruptedException {
        RemarksTab.click();
        Thread.sleep(3000);
        waitHelper.waitForElement(driver,PickTypeReason,10);
        new DropDown(driver).Handling_Drop_Down(2,"CLEAN");

        SelectCategory.click();
        Thread.sleep(3000);
        new DropDown(driver).Handling_Drop_Down(2,"Procedural");

        ConfirmButton.click();
        Thread.sleep(3000);
        waitHelper.waitForElement(driver,PayeesTab,10);
    }

    public void Wait_for_Terminate_And_Pay(){
        waitHelper.waitForElement(driver,Terminate_And_Pay,10);
    }

    public void Click_Confirm_of_Terminate_Pay() throws InterruptedException {
        waitHelper.waitForElement(driver,Terminate_And_Pay,10);
        Terminate_And_Pay.click();
        Thread.sleep(3000);
        waitHelper.waitForElement(driver,ConfirmButton,10);
        ConfirmButton.click();
        Thread.sleep(3000);
    }

    public void Wait_for_Mark_Settled(){
        waitHelper.waitForElement(driver,MarkSettled,10);
    }

    public void Click_Mark_Settle() throws InterruptedException {
        MarkSettled.click();
        Thread.sleep(3000);
        waitHelper.waitForElement(driver,ConfirmButton,10);
        Thread.sleep(3000);
    }

    public void Enter_Mark_Settled_of_Reason() throws InterruptedException {
        Mark_Settled_Reason.sendKeys("Test Reason");
        ConfirmButton.click();
        Thread.sleep(3000);
        waitHelper.waitForElement(driver,PayeesTab,10);
        Thread.sleep(3000);
    }

    public void Wait_Export_Claim_Packet(){
        waitHelper.waitForElement(driver,Export_Claim_Packet,10);
    }






}
