package TestCase.HLC.FHD;

import BaseClass.TestBase;
import Benekiva.HLC.FHD.Dashboard;
import Benekiva.HLC.FHD.MyProfile;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Verification.AssertionHelper;
import helper.Verification.Wait_Helper_Page;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyProfieTestCase extends TestBase {

    Wait_Helper_Page waitHelperPage;
    @BeforeClass
    public void setup() throws IOException, ParseException {
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
    public void Click_My_Profile_Tab_Test() throws InterruptedException {
        new MyProfile(driver).Click_My_Profile_Tab();
    }

    @Test(priority = 5)
    public void Enter_Detail_Of_My_Profile() throws IOException, ParseException {
        String First_Name=new ReadJsonData().ReadJSONData("First_name");
        String Last_Name=new ReadJsonData().ReadJSONData("Last_name");
        String Title=new ReadJsonData().ReadJSONData("Title_User");
        new UfUnity_Pages.FHD.MyProfile(driver).Go_To_MyProfile_Info(First_Name,Last_Name,Title);
    }
    @Test(priority = 6)
    public void LogoutFromApplication(){
        new AccountVerification(driver).Logout_from_Application();
    }




}
