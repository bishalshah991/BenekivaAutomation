package Benekiva.HLC.CSR;

import BaseClass.TestBase;
import Utility.ReadJsonData;
import helper.Assign_to_me.Assign_to_me;
import helper.Beneficiaries.Beneficiaries_Setup;
import helper.ClaimInformation.Claim_Information_Page;
import helper.Genetrate_Quote.GenerateQuote;
import helper.Genetrate_Quote.GenerateQuote1;
import helper.Inbox.InboxSetup;
import helper.Pages.MatchThis;
import helper.Pages.Upload;
import helper.Payment.PaymentSetup;
import helper.Policy_Search.PolicySearch;
import helper.Policy_Search.PolicySearch1;
import helper.ReadyPay.Ready_Pay_Setup;
import helper.Verification.AssertionHelper;
import helper.Verification.Wait_Helper_Page;
import helper.Verify_Text.VerifyText;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Hlc_CSR_End_to_End extends TestBase {
    Wait_Helper_Page waitHelperPage;
    PolicySearch1 policy_Search;
    GenerateQuote1 generateQuote1;
    Claim_Information_Page claimInformationPage;

    public Hlc_CSR_End_to_End(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelperPage=new Wait_Helper_Page(driver,10);
        policy_Search=new PolicySearch1(driver);
        generateQuote1=new GenerateQuote1(driver);
        claimInformationPage=new Claim_Information_Page(driver);
    }
    @FindBy(xpath = "//div[contains(text(),' Claim Activity')]")
    WebElement TextClaimActivity;
    public void Wait_For_Dashboard(){
        waitHelperPage.Go_to_Wait_for_Element(TextClaimActivity);
        AssertionHelper.Verify_the_an_Element(TextClaimActivity);

    }


    public void Search_the_Policy() throws IOException, ParseException, InterruptedException {
        policy_Search.Go_to_Policy_Search_Tab();
        policy_Search.Search_Text_Box();
        String policyNum=new ReadJsonData().ReadJSONData("hlcCsrPolicySearch");
        policy_Search.Enter_Policy_Number(policyNum);
        policy_Search.Click_Action();
        policy_Search.Click_Begin_Claim();
    }

    public void Go_To_Generate_Quote() throws IOException, ParseException, InterruptedException {
        generateQuote1.Wait_For_Generate_Quote();
        generateQuote1.Click_Cause_Death();
        generateQuote1.Go_to_Radio_Button();
        generateQuote1.Enter_Bill_Amount("11.11");
        generateQuote1.Enter_Date_of_Death();
        generateQuote1.Click_Generate_Button();
        generateQuote1.Go_to_Start_Claim();
    }

    public void Enter_Claim_Information() throws InterruptedException {
        claimInformationPage.Wait_Claim_Type();
        claimInformationPage.Spoke_With();
        claimInformationPage.Click_relationship();
        claimInformationPage.Enter_Phone_Number();
        claimInformationPage.Enter_Insured_Dob();
        claimInformationPage.Submit_Claim();
    }

    public void UploadDocument() throws InterruptedException {
        new Upload(driver).addUploadDocument();
    }

    public void Go_to_Match_This() throws InterruptedException {
        new MatchThis(driver).Wait_For_Save();
        new MatchThis(driver).Click_Match_This_Each_Box();
        new MatchThis(driver).Click_Save_Button();
        new MatchThis(driver).Click_View_Button();
        new VerifyText(driver).Check_Payment_Review();
    }

    public void CheckPaymentStatus_Test(){
        new PaymentSetup(driver).Check_Payment_Review_Status();
    }

    public void Go_to_Assign_to_Me(){
        new PaymentSetup(driver).Go_to_Assign_me_tab();

    }

    public void Click_Approve() throws InterruptedException {
        new PaymentSetup(driver).Go_to_Approve_tab();
    }

    public void Click_Payment() throws InterruptedException {
        new PaymentSetup(driver).Check_status_Ready_to_pay();
    }

    public void Go_to_Payment_tab(){
        new PaymentSetup(driver).Go_to_Payment();
    }

    public void Go_to_Terminate_and_Pay() throws InterruptedException {
        new PaymentSetup(driver).Go_to_Terminate_and_Pay();
    }

    public void Enter_Add_Internal_Notes() throws InterruptedException {
        new PaymentSetup(driver).Add_Internal_Notes();
    }



}
