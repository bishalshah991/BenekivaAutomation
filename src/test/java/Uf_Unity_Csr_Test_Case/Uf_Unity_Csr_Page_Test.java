package Uf_Unity_Csr_Test_Case;

import BaseClass.TestBase;
import Uf_Unity_Csr.Uf_Unity_Csr_Page;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Assign_to_me.Assign_to_me;
import helper.Beneficiaries.Beneficiaries_Setup;
import helper.Genetrate_Quote.GenerateQuote;
import helper.Inbox.InboxSetup;
import helper.Pages.MatchThis;
import helper.Pages.Upload;
import helper.Policy_Search.PolicySearch;
import helper.ReadyPay.Ready_Pay_Setup;
import helper.Verification.AssertionHelper;
import helper.Verification.WaitHelper;
import helper.Verification.Wait_Helper_Page;
import helper.Verify_Text.VerifyText;
import helper.NeedsRequirement.Needs_Requirement;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Uf_Unity_Csr_Page_Test extends TestBase {

    WaitHelper waitHelper;
    Wait_Helper_Page waitHelperPage;
    Uf_Unity_Csr_Page ufUnityCsrPage;

    @BeforeClass
    public void setup() throws IOException, ParseException {
        LaunchBrowser(new ReadJsonData().ReadJSONData("browser_name"));
        driver.get(new ReadJsonData().ReadJSONData("website"));
        waitHelper = new WaitHelper(driver);
        waitHelperPage=new Wait_Helper_Page(driver,10);
        waitHelper.waitForElement(driver, new AccountVerification(driver).TextLoginPage, 10);
        ufUnityCsrPage=new Uf_Unity_Csr_Page(driver);
    }

    @Test(priority = 1)
    public void LoginToApplication() throws IOException, ParseException {
        String uname=new ReadJsonData().ReadJSONData("unityCsrUsername");
        String password=new ReadJsonData().ReadJSONData("unityCsrPassword");
        new AccountVerification(driver).Login_to_Application(uname,password);
        waitHelper.waitForElement(driver, ufUnityCsrPage.TextClaimActivity,10);
    }

    @Test(priority = 2)
    public void SearchPolicy() throws IOException, ParseException, InterruptedException {
        new PolicySearch(driver).Go_to_Policy_Search_Tab();
        String policy_no=new ReadJsonData().ReadJSONData("unityCsrPolicySearch1");
        System.out.println(policy_no);
        new PolicySearch(driver).Go_to_Policy_Search_Text_Box(policy_no);
        new PolicySearch(driver).Go_to_Active_Policy();
    }

    @Test(priority = 3)
    public void Goto_GenerateQuote_Tab() throws IOException, ParseException, InterruptedException {
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

    @Test(priority = 6)
    public void Go_to_View() throws InterruptedException {
        new Needs_Requirement(driver).Wait_for_View_Page();
        new Needs_Requirement(driver).ClickView();
        new Needs_Requirement(driver).Check_Texas_Recon();
        Thread.sleep(10000);
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
    }

    @Test(priority = 9)
    public void Policy_SearchTab() throws IOException, ParseException, InterruptedException {
        new PolicySearch(driver).Go_to_Policy_Search_Tab();
        new PolicySearch(driver).Go_to_Policy_Search_Text_Box(new ReadJsonData().ReadJSONData("unityCsrPolicySearch1"));
        AssertionHelper.verifyElementPresent(new VerifyText(driver).TextPayment_Review);
        Thread.sleep(5000);
    }
    @Test(priority = 10)
    public void LogOutFromTheApplication(){
        new AccountVerification(driver).Logout_from_Application();
    }

    @AfterClass
    public void CloseBrowSer(){
        driver.quit();
    }








}
