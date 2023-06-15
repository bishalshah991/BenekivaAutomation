package TestCase.HLC.CSR;

import BaseClass.TestBase;
import Benekiva.HLC.CSR.Hlc_CSR_End_to_End;
import Benekiva.HLC.FHD.Dashboard;
import Benekiva.HLC.FHD.Hlc_Fhd_Generate_Quote;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Policy_Search.PolicySearch1;
import helper.Verification.AssertionHelper;
import helper.Verification.Wait_Helper_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class HLC_Csr_End_to_End_Test extends TestBase {

    Wait_Helper_Page waitHelperPage;
    @BeforeClass
    public void setup() throws IOException, ParseException {
        //LaunchBrowser(new ReadJsonData().ReadJSONData("browser_name"));
        driver.get(new ReadJsonData().ReadJSONData("websiteHlc"));
        waitHelperPage=new Wait_Helper_Page(driver,10);
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
    }
    @Test(priority = 3)
    public void Login_To_Application() throws IOException, ParseException {
        String u_username=new ReadJsonData().ReadJSONData("hlcCsrUsername");
        String  p_password=new ReadJsonData().ReadJSONData("hlcFhdPassword");
        new AccountVerification(driver).Login_to_Application(u_username,p_password);
        new Hlc_CSR_End_to_End(driver).Wait_For_Dashboard();
    }
    @Test(priority = 4)
    public void Search_the_Policy_Test() throws IOException, ParseException, InterruptedException {
        new Hlc_CSR_End_to_End(driver).Search_the_Policy();
    }

    @Test(priority = 5)
    public void Go_To_Generate_Quote_test() throws IOException, ParseException, InterruptedException {
        new Hlc_CSR_End_to_End(driver).Go_To_Generate_Quote();
    }
    @Test(priority = 6)
    public void Enter_Claim_Information_Test() throws InterruptedException {
        new Hlc_CSR_End_to_End(driver).Enter_Claim_Information();
    }

    @Test(priority = 7)
    public void UploadDocument_test() throws InterruptedException {
        new Hlc_CSR_End_to_End(driver).UploadDocument();
        new Hlc_CSR_End_to_End(driver).Go_to_Match_This();
    }

    @Test(priority = 8)
    public void Go_to_Payment() throws InterruptedException {
        new Hlc_CSR_End_to_End(driver).Go_to_Assign_to_Me();
        new Hlc_CSR_End_to_End(driver).Click_Approve();
        new Hlc_CSR_End_to_End(driver).Click_Payment();
        new Hlc_CSR_End_to_End(driver).Go_to_Payment_tab();
    }

    @Test(priority = 9)
    public void Terminate_And_Pay() throws InterruptedException {
        new Hlc_CSR_End_to_End(driver).Go_to_Terminate_and_Pay();
    }

    @Test(priority = 10)
    public void Go_to_Policy() throws IOException, ParseException, InterruptedException {
        new PolicySearch1(driver).Go_to_Policy_Search_Tab();
        new PolicySearch1(driver).Search_Text_Box();
        new PolicySearch1(driver).Enter_Policy_Number(new ReadJsonData().ReadJSONData("hlcCsrPolicySearch"));
    }
}
