package TestCase.HLC.FHD;

import BaseClass.TestBase;
import Benekiva.HLC.FHD.Dashboard;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Verification.AssertionHelper;
import helper.Verification.WaitHelper;
import helper.Verification.Wait_Helper_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DashboardTest extends TestBase {

    Wait_Helper_Page waitHelperPage;


    @BeforeClass
    public void setup() throws IOException, ParseException {
        driver.get(new ReadJsonData().ReadJSONData("websiteHlc"));
        waitHelperPage=new Wait_Helper_Page(driver,10);
    }


    @Test(priority = 1)
    public void LoginPageIsDisplayed_Test(){
        new Dashboard(driver).LoginPageIsDisplayed();
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
    public void PaymentOverview_Test(){
        String Text=new Dashboard(driver).PaymentOverview();
        System.out.println("Payment Value:-"+Text);
    }

    @Test(priority = 5)
    public void CheckDollar_Test(){
        String Text=new Dashboard(driver).CheckDollar();
        System.out.println("Dollar Value:-"+Text);
    }
    @Test(priority = 6)
    public void LogoutFromApplication(){
        new AccountVerification(driver).Logout_from_Application();
    }
}
