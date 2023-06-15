package TestCase.HLC.FHD;

import BaseClass.TestBase;
import Benekiva.HLC.FHD.Dashboard;
import Benekiva.HLC.FHD.Hlc_Fhd_Generate_Quote;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Policy_Search.PolicySearch;
import helper.Verification.AssertionHelper;
import helper.Verification.Wait_Helper_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Hlc_Fhd_Generate_Quote_Test extends TestBase {
    Wait_Helper_Page waitHelperPage;
    PolicySearch policy_Search;

    @BeforeClass
    public void setup() throws IOException, ParseException {
        driver.get(new ReadJsonData().ReadJSONData("websiteHlc"));
        waitHelperPage=new Wait_Helper_Page(driver,10);
        policy_Search=new PolicySearch(driver);
    }
    @Test(priority = 1)
    public void LoginPageIsDisplayed_Test(){
        new Dashboard(driver).LoginPageIsDisplayed();
        AssertionHelper.verifyTextEquals(new Dashboard(driver).LoginPage,"LOGIN TO YOUR ACCOUNT");
    }

    @Test(priority = 2)
    public void Hlc_Version_Application_Test(){
        String text_version=new Dashboard(driver).Hlc_Version_Application();
        System.out.println("HLC Application Version:-"+text_version);
        extentReports.setSystemInfo("HLC Version",text_version);
    }
    @Test(priority = 3)
    public void Login_To_Application() throws IOException, ParseException {
        String u_username=new ReadJsonData().ReadJSONData("hlcFhdUsername");
        String  p_password=new ReadJsonData().ReadJSONData("hlcFhdPassword");
        new AccountVerification(driver).Login_to_Application(u_username,p_password);
        waitHelperPage.Go_to_Wait_for_Element(new Dashboard(driver).TextPaymentOverview);
        AssertionHelper.verifyElementPresent(new Dashboard(driver).TextPaymentOverview);
        waitHelperPage.Go_to_Wait_for_Element(new Dashboard(driver).DollarValue);
        AssertionHelper.verifyElementPresent(new Dashboard(driver).DollarValue);
    }

    @Test(priority = 4)
    public void SearchThePolicy() throws IOException, ParseException {
        policy_Search.Go_to_Policy_Search_Tab();
        String policysearch=new ReadJsonData().ReadJSONData("hlcFhdPolicySearch");
        policy_Search.Go_to_Policy_Search_Text_Box(policysearch);
        waitHelperPage.Go_to_Wait_for_Element(policy_Search.Active_One);
        AssertionHelper.verifyElementPresent(policy_Search.Active_One);
        policy_Search.Action_Three_Dot_One.click();
        waitHelperPage.Go_to_Wait_for_Element(policy_Search.Begin_Claim);
        AssertionHelper.verifyElementPresent(policy_Search.Begin_Claim);
        new Hlc_Fhd_Generate_Quote(driver).Click_Begin_Claim();
        new Hlc_Fhd_Generate_Quote(driver).Click_Cause_of_Death();
    }

    @Test(priority = 5)
    public void Enter_Bill_Amount_test(){
        new Hlc_Fhd_Generate_Quote(driver).Enter_Bill_Amount();
    }

    @Test(priority = 6)
    public void Click_Cause_of_Death_Test() throws IOException, ParseException {
       new Hlc_Fhd_Generate_Quote(driver).Enter_Date_of_Death();
    }

    @Test(priority = 7)
    public void Enter_Date_of_Birth_Test() throws IOException, ParseException, InterruptedException {
        new Hlc_Fhd_Generate_Quote(driver).Enter_Date_of_Birth();
    }
    @Test(priority = 8)
    public void Enter_Contact_Number_Test() throws IOException, ParseException {
        new Hlc_Fhd_Generate_Quote(driver).Contact_Number();
    }
    @Test(priority = 9)
    public void Click_Generate_Quote_Button_Test(){
        new Hlc_Fhd_Generate_Quote(driver).Click_Generate_Quote_Button();
    }
    @Test(priority = 10)
    public void LogoutFromApplication(){
        new AccountVerification(driver).Logout_from_Application();
    }

}
