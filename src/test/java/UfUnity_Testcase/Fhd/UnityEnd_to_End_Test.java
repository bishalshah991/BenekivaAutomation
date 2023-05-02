package UfUnity_Testcase.Fhd;

import BaseClass.TestBase;
import UfUnity_Pages.FHD.UnityEnd_to_End;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Pages.Calendar;
import helper.Pages.Drop_Down;
import helper.Pages.PolicySearch;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class UnityEnd_to_End_Test extends TestBase {
    PolicySearch policySearch;
    Calendar calendar;

    @BeforeClass
    public void Setup() throws IOException, ParseException {
        LaunchBrowser(new ReadJsonData().ReadJSONData("browser_name"));
        driver.get(new ReadJsonData().ReadJSONData("website"));
        new WaitHelper(driver, 10).waitForElement(new AccountVerification(driver).TextLoginPage);
        new AccountVerification(driver).Login_to_Application(new ReadJsonData().ReadJSONData("unityFhdUsername"), new ReadJsonData().ReadJSONData("unityFhdPassword"));
        policySearch=new PolicySearch(driver);
        calendar=new Calendar(driver);
    }

    @Test(priority = 1)
    public void Go_to_Policy_Search_Tab_Test() throws IOException, ParseException {
        policySearch.Go_to_Policy_Search_Tab();
        policySearch.Enter_Policy_Number(new ReadJsonData().ReadJSONData("unityPolicySearch"));
        policySearch.Click_Action();
        policySearch.Click_Begin_Claim();
    }

    @Test(priority = 2)
    public void Enter_Detail_of_Genetrate_Quote() throws IOException, ParseException {
        new WaitHelper(driver,10).waitForElement(calendar.calendar);
        calendar.Click_Calendar(new ReadJsonData().ReadJSONData("Year"),new ReadJsonData().ReadJSONData("Month"),new ReadJsonData().ReadJSONData("Day"));
    }

    @Test(priority = 3)
    public void Cause_of_Death() throws InterruptedException {
        new Drop_Down(driver).Pick_Drop_Down("Natural");
    }

    @Test(priority = 4)
    public void Enter_Bill_Amount_Test(){
        new UnityEnd_to_End(driver).Enter_Bill_Amount("1245");
    }


    @Test(priority = 5)
    public void Logout() throws InterruptedException {
        new PolicySearch(driver).Go_to_Policy_Search_Tab();
        new AccountVerification(driver).Logout_from_Application();
    }
    @AfterClass
    public void CloseBrowser(){
        driver.quit();
    }

}
