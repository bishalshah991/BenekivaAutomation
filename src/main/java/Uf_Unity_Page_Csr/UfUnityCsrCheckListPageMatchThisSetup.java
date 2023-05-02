package Uf_Unity_Page_Csr;

import BaseClass.TestBase;
import helper.Pages.MatchThis;
import helper.Pages.PolicySearch;
import helper.Pages.Upload;
import helper.Verification.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UfUnityCsrCheckListPageMatchThisSetup extends TestBase {
    WaitHelper waitHelper;
    Upload uploadHelper;
    MatchThis matchThis;
    PolicySearch policySearch;

    public UfUnityCsrCheckListPageMatchThisSetup(WaitHelper waitHelper) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,10);
        uploadHelper=new Upload(driver);
        matchThis=new MatchThis(driver);
        policySearch=new PolicySearch(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Save']")
    WebElement SaveMatchthis;
    @FindBy(xpath = "//span[normalize-space()='Needs Requirement']")
    WebElement NeedsRequirementStatusXpath;
    @FindBy(xpath = "//span[normalize-space()='Pending Review']")
    WebElement PendingReviewStatusXpath;
    @FindBy(xpath = "//mat-icon[normalize-space()='edit_mode']")
    WebElement TexasReconEditXpath;
    @FindBy(xpath = "//button[@aria-label='SAVE']")
    WebElement SaveTexasReconXpath;
    @FindBy(xpath = "//button[@aria-label='Approve']")
    WebElement ApproveTexasReconXpath;
    @FindBy(xpath = "//div[normalize-space()='INBOX']")
    WebElement ActionalPanalInboxXpath;
    @FindBy(xpath = "//span[contains(text(),'Select a message to read')]")
    WebElement InboxVerificationXpath;
    @FindBy(xpath = "//div[@fxlayoutalign='start start']//div[@fxlayout='column']")
    WebElement InboxMailXpath;
    @FindBy(xpath = "//div[normalize-space()='VIEW CHECKLIST']")
    WebElement ActionPanalCheckListXpath;
    @FindBy(xpath = "//div[normalize-space()='BENEFICIARIES']")
    WebElement ActionalPanalBeneficiariesXpath;
    @FindBy(xpath = "//button[@title='Refresh Beneficiaries']")
    WebElement BeneficiariesVerificationXpath;
    @FindBy(xpath = "//button[@aria-label='Close beneficiary screen']")
    WebElement CloseBeneficiaryScreenXpath;
    @FindBy(xpath = "//div[normalize-space()='EVENT LOGS']")
    WebElement ActionPanalEventLogsXpath;
    @FindBy(xpath = "//th[normalize-space()='Log']")
    WebElement EventLogVerificationXpath;
    @FindBy(xpath = "//div[normalize-space()='LOCK OUT']")
    WebElement ActionPanalLockOutXpath;
    @FindBy(xpath = "//div[normalize-space()='CLAIM TAG']")
    WebElement ActionalPanalClaimTagXpath;
    @FindBy(xpath = "//div[normalize-space()='ASSIGN TO ME']")
    WebElement ActionalPanalAssignToMeXpath;
    @FindBy(xpath = "(//span[contains(text(),'VIEW')])[1]")
    WebElement ViewXpath;
    @FindBy(xpath = "(//mat-list-item)")
    WebElement MatchTexasReconXpath;
    @FindBy(xpath = "//div[@aria-label='action-item']")
    WebElement SaveTexasXpath;
    @FindBy(xpath = "/html/body/fuse-root/fuse-main/mat-sidenav-container/mat-sidenav-content/div/div/div/fuse-content/fuse-caseload-eventlogs/div/div/mat-tab-group/div/mat-tab-body/div/div/table/tbody/tr[1]/td[1]")
    WebElement EventLogDateXpath;
    @FindBy(xpath = "//a[normalize-space()='Click here to release lock']")
    WebElement UnlockPolicyXpath;
    @FindBy(xpath = "//button[@aria-label='CONFIRM']")
    WebElement AssigneToMeConfirmXpath;
    @FindBy(xpath = "//div[normalize-space()='UNASSIGNED']")
    WebElement AssigneToMeVerificationXpath;
    @FindBy(xpath = "//div[normalize-space()='APPROVE']")
    WebElement ApprovedXpath;


    public void Go_to_Needs_requirement() throws InterruptedException {

        if (policySearch.States().equals("TX")){
            waitHelper.waitForElement(NeedsRequirementStatusXpath);
            uploadHelper.addUploadDocument();
            matchThis.ClickMatchThis();
            SaveMatchthis.click();
            waitHelper.waitForElement(TexasReconEditXpath);
            Thread.sleep(5000);
            TexasReconEditXpath.click();
            waitHelper.waitForElement(SaveTexasReconXpath);
            SaveTexasReconXpath.click();
            Thread.sleep(5000);
            waitHelper.waitForElement(TexasReconEditXpath);
            TexasReconEditXpath.click();
            Thread.sleep(2000);
            waitHelper.waitForElement(ApproveTexasReconXpath);
            ApproveTexasReconXpath.click();
            waitHelper.waitForElement(ViewXpath);
            ViewXpath.click();
            waitHelper.waitForElement(MatchTexasReconXpath);
            MatchTexasReconXpath.click();
            SaveTexasReconXpath.click();

        }
        else {
            waitHelper.waitForElement(NeedsRequirementStatusXpath);
            uploadHelper.addUploadDocument();
            matchThis.ClickMatchThis();
            SaveMatchthis.click();
        }

    }

    public void PendingReview(){
        waitHelper.waitForElement(PendingReviewStatusXpath);
        String status =  PendingReviewStatusXpath.getText();
        Assert.assertEquals(status,"Pending Review","Status is Updates to Pending Review");
    }
    public void UfUnityCsrActionPanal() throws InterruptedException {
        Thread.sleep(2000);
        waitHelper.waitForElement(ActionalPanalInboxXpath);
        ActionalPanalInboxXpath.click();
        waitHelper.waitForElement(InboxVerificationXpath);
        String EmptyInbox = driver.findElement(By.xpath("(//div[@role='tab'])[2]")).getText();
        if (EmptyInbox.equals("Inbox")){
            String NameInEmail = driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr[2]/td/div/p[3]")).getText();
            String[] Name = NameInEmail.split(" ");
            String FullName = driver.findElement(By.xpath("//*[@id=\"inbox\"]/fuse-action-panel/div/div/div[1]/div[1]")).getText();
            String FullNameInEmail = Name[1]+Name[2]+Name[3];
            Assert.assertEquals(FullName,FullNameInEmail,"Name in Email is not correct");
        }
        else {
            System.out.println(EmptyInbox);
        }
        ActionPanalCheckListXpath.click();
        waitHelper.waitForElement(PendingReviewStatusXpath);
        ActionalPanalBeneficiariesXpath.click();
        waitHelper.waitForElement(BeneficiariesVerificationXpath);
        CloseBeneficiaryScreenXpath.click();
        ActionPanalEventLogsXpath.click();
        waitHelper.waitForElement(EventLogVerificationXpath);
        String  uploadDate = EventLogDateXpath.getText();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String[] uplDate = uploadDate.split(" ");
        Assert.assertEquals(uplDate[0],dtf.format(now),"Error in Eventlog Page");
        waitHelper.waitForElement(ActionPanalCheckListXpath);
        ActionPanalCheckListXpath.click();
        waitHelper.waitForElement(PendingReviewStatusXpath);
        ActionPanalLockOutXpath.click();
        waitHelper.waitForElement(UnlockPolicyXpath);
        UnlockPolicyXpath.click();
        waitHelper.waitForElement(ActionalPanalAssignToMeXpath);
        ActionalPanalAssignToMeXpath.click();
        waitHelper.waitForElement(AssigneToMeConfirmXpath);
        AssigneToMeConfirmXpath.click();
        waitHelper.waitForElement(AssigneToMeVerificationXpath);
        ApprovedXpath.click();
        waitHelper.waitForElement(AssigneToMeConfirmXpath);
        AssigneToMeConfirmXpath.click();
    }


}
