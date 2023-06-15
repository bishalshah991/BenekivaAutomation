package helper.Verify_Text;

import BaseClass.TestBase;
import helper.Verification.AssertionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyText extends TestBase {
    public VerifyText(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Pending Review')]")
    public WebElement TextPayment_Review;

    @FindBy(xpath = "//span[contains(text(),'Ready To Pay')]")
    WebElement TextReadyPay;

    @FindBy(xpath = "(//span[contains(text(),'Needs Requirement')])[2]")
    WebElement TextNeedsRequirement;

    @FindBy(xpath = "//span[contains(text(),' Pending Review')]")
    WebElement TextPendingReview;

    public void Check_Pending_Review() throws InterruptedException {
        AssertionHelper.verifyElementPresent(TextPendingReview);
        AssertionHelper.verifyTextEquals(TextPendingReview,TextPendingReview.getText());
        Thread.sleep(3000);
    }


    public void Check_Payment_Review() throws InterruptedException {
        AssertionHelper.verifyElementPresent(TextPayment_Review);
        AssertionHelper.verifyTextEquals(TextPayment_Review,TextPayment_Review.getText());
        Thread.sleep(3000);
    }

    public void Check_Ready_to_pay() throws InterruptedException {

        AssertionHelper.verifyTextEquals(TextReadyPay,TextReadyPay.getText());
        Thread.sleep(3000);
    }

    public void Check_Needs_Requirement() throws InterruptedException {
        AssertionHelper.verifyElementPresent(TextNeedsRequirement);
        AssertionHelper.verifyTextEquals(TextNeedsRequirement,TextNeedsRequirement.getText());
        Thread.sleep(3000);
    }



}
