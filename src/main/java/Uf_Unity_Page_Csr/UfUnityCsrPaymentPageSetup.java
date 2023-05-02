package Uf_Unity_Page_Csr;

import BaseClass.TestBase;
import helper.Verification.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UfUnityCsrPaymentPageSetup extends TestBase {
    WaitHelper waitHelper;

    public UfUnityCsrPaymentPageSetup(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,10);
    }

    @FindBy(xpath = "//span[normalize-space()='Payment Review']")
    WebElement PaymentReviewStatusVerification;
    @FindBy(xpath = "//div[normalize-space()='PAYMENT']")
    WebElement PaymentButtonXpath;
    @FindBy(xpath = "/html/body/fuse-root/fuse-main/mat-sidenav-container/mat-sidenav-content/div/div/div/fuse-content/fuse-caseloads-caseload-payout-dialog/div[1]/div/div[2]/div[3]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell[4]/div/span[1]")
    WebElement AmountVerificationXpath;
    @FindBy(xpath = "/html/body/fuse-root/fuse-main/mat-sidenav-container/mat-sidenav-content/div/div/div/fuse-content/fuse-caseloads-caseload-payout-dialog/div[1]/div/div[1]/div[3]/div/div/div/div[1]/div[2]")
    WebElement BenefitAmountXpath;
    @FindBy(xpath = "//div[normalize-space()='APPROVE']")
    WebElement ApproveXpath;
    @FindBy(xpath = "//span[normalize-space()='CONFIRM']")
    WebElement ConfirmButtonXpath;
    @FindBy(xpath = "//div[normalize-space()='PAYEES']")
    WebElement PayessXpath;
    @FindBy(xpath = "//span[normalize-space()='Ready To Pay']")
    WebElement ReadyToPayStatusXpath;


    public void PaymentReviewStatus(){
        waitHelper.waitForElement(PaymentReviewStatusVerification);
        String PaymentReviewStatus = PaymentReviewStatusVerification.getText();
        //Assert.assertEquals(PaymentReviewStatus,"Payment Review","Payment Review Status is no updated");
        waitHelper.waitForElement(PaymentButtonXpath);
        PaymentButtonXpath.click();
        String Amount = AmountVerificationXpath.getText();
        String BenefitAmount = BenefitAmountXpath.getText();
        //Assert.assertEquals(BenefitAmount,Amount,"Benefit Amount is not correct");
        waitHelper.waitForElement(ApproveXpath);
        ApproveXpath.click();
        waitHelper.waitForElement(ConfirmButtonXpath);
        ConfirmButtonXpath.click();
    }
    public void ReadyToPayStatus(){
        waitHelper.waitForElement(ReadyToPayStatusXpath);

    }
}
