package Uf_Unity_Clm_Test_Case;

import BaseClass.TestBase;
import Uf_Unity_Csr.Uf_Unity_Csr_Page;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Assign_to_me.Assign_to_me;
import helper.Genetrate_Quote.GenerateQuote;
import helper.NeedsRequirement.Needs_Requirement;
import helper.Pages.MatchThis;
import helper.Pages.Upload;
import helper.Policy_Search.PolicySearch;
import helper.ReadyPay.Ready_Pay_Setup;
import helper.Texas_Recon.Texas_Recon_Setup;
import helper.Verification.AssertionHelper;
import helper.Verification.Wait_Helper_Page;
import helper.Verify_Text.VerifyText;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class Uf_Clm_End_to_End extends TestBase {

    Wait_Helper_Page waitHelperPage;
    Uf_Unity_Csr_Page ufUnityCsrPage;

    @BeforeClass
    public void setup() throws IOException, ParseException, org.json.simple.parser.ParseException {
        LaunchBrowser(new ReadJsonData().ReadJSONData("browser_name"));
        driver.get(new ReadJsonData().ReadJSONData("website"));
        waitHelperPage=new Wait_Helper_Page(driver,10);
        ufUnityCsrPage=new Uf_Unity_Csr_Page(driver);
        waitHelperPage.Go_to_Wait_for_Element(new AccountVerification(driver).TextLoginPage );
    }

    @Test(priority = 1)
    public void LoginToApplication() throws IOException, ParseException, org.json.simple.parser.ParseException {
        String uname=new ReadJsonData().ReadJSONData("unityClmUsername");
        String password=new ReadJsonData().ReadJSONData("unityClmPassword");
        new AccountVerification(driver).Login_to_Application(uname,password);
        waitHelperPage.Go_to_Wait_for_Element(ufUnityCsrPage.TextClaimActivity);
    }

    @Test(priority = 2)
    public void SearchPolicy() throws IOException, ParseException, org.json.simple.parser.ParseException {
        new PolicySearch(driver).Go_to_Policy_Search_Tab();
        String policy_no=new ReadJsonData().ReadJSONData("unityClmPolicySearch");
        System.out.println(policy_no);
        new PolicySearch(driver).Go_to_Policy_Search_Text_Box(policy_no);
        new PolicySearch(driver).Go_to_Active_Policy();
    }
    @Test(priority = 3)
    public void Goto_GenerateQuote_Tab() throws IOException, org.json.simple.parser.ParseException, InterruptedException {
        new GenerateQuote(driver).Go_to_Generate_Quote_tab();
        String date_of_year=new ReadJsonData().ReadJSONData("Year");
        String date_of_month=new ReadJsonData().ReadJSONData("Month");
        String date_of_day=new ReadJsonData().ReadJSONData("Day");
        new GenerateQuote(driver).Enter_Date_of_Death(date_of_year,date_of_month,date_of_day);
        new GenerateQuote(driver).Enter_Cause_of_Death();
        new GenerateQuote(driver).Enter_Bill_Amount(new ReadJsonData().ReadJSONData("Bill_Amount"));
        new GenerateQuote(driver).Click_Generate_Quote_Button();
        new GenerateQuote(driver).Click_Start_Claim_Button();
        new VerifyText(driver).Check_Needs_Requirement();
    }

    @Test(priority = 4)
    public void Texas_Recon() throws InterruptedException {
        new Texas_Recon_Setup(driver).Wait_Texas_Recon();
        new Texas_Recon_Setup(driver).Go_to_Texas_Recon();
        new Texas_Recon_Setup(driver).Go_to_texas_Recon_Approve();
    }

    @Test(priority = 4)
    public void UploadDocument() throws InterruptedException {
        new Upload(driver).addUploadDocument();
        waitHelperPage.Go_to_Wait_for_Element(new MatchThis(driver).Match_this);
        AssertionHelper.verifyElementPresent(new MatchThis(driver).Match_this);
        waitHelperPage.Go_to_Wait_for_Element(new MatchThis(driver).SaveButton);
        AssertionHelper.verifyElementPresent(new MatchThis(driver).SaveButton);
    }

    @Test(priority = 5)
    public void Go_to_Match_This() throws InterruptedException {
        new MatchThis(driver).Click_Match_This_Each_Box();
        new MatchThis(driver).Click_Save_Button();
    }

    @Test(priority = 7)
    public void Go_to_Assign_to_me_Test() throws InterruptedException {
        new Assign_to_me(driver).Go_to_Assign_to_me();
        new Assign_to_me(driver).Click_Confirm_Button();
        new VerifyText(driver).Check_Pending_Review();
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void Go_to_Approve() throws InterruptedException {
        new Ready_Pay_Setup(driver).Wait_for_Approve_Tab();
        new Ready_Pay_Setup(driver).Click_Approve();
        new Ready_Pay_Setup(driver).Click_Payment_Tab();
        new Ready_Pay_Setup(driver).Go_to_Payees();
        new Ready_Pay_Setup(driver).ApproveTab.click();
        Thread.sleep(3000);
        new Ready_Pay_Setup(driver).ConfirmButton.click();
    }

    @Test(priority = 9)
    public void Go_to_Mark_Settle() throws InterruptedException {
        new Ready_Pay_Setup(driver).Wait_for_Mark_Settled();
        new Ready_Pay_Setup(driver).Click_Mark_Settle();
        new Ready_Pay_Setup(driver).Enter_Mark_Settled_of_Reason();
    }

    @Test(priority = 10)
    public void Wait_Export_Claim_packet(){
        new Ready_Pay_Setup(driver).Wait_Export_Claim_Packet();
    }
    @Test(priority = 11)
    public void LogOutFromApplication(){
        new AccountVerification(driver).Logout_from_Application();
    }

    @AfterClass
    public void AfterClass(){
        driver.quit();
    }



}
