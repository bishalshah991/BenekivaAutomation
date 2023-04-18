package UfUnity_Testcase.Fhd;

import BaseClass.TestBase;
import Intake_Setup.IntakeSetup;
import UfUnity_Pages.FHD.ChildProtectionPlan;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ChildProtectionPlanTest extends TestBase {
    ChildProtectionPlan childProtectionPlan;
    ReadJsonData readJsonData;
    WaitHelper waitHelper;
    IntakeSetup intakeInitialization;
    int increment  = 1;

    @BeforeClass
    public void Setup() throws IOException, ParseException {
        LaunchBrowser(new ReadJsonData().ReadJSONData("browser_name"));
        driver.get(new ReadJsonData().ReadJSONData("website"));
        new WaitHelper(driver).waitForElement(driver,new AccountVerification(driver).TextLoginPage,10);
        new AccountVerification(driver).Login_to_Application(new ReadJsonData().ReadJSONData("unityFhdUsername"),new ReadJsonData().ReadJSONData("unityFhdPassword"));
        childProtectionPlan=new ChildProtectionPlan(driver);
        readJsonData=new ReadJsonData();

    }
    @Test
    public void Go_to_Child_Protection_Tab_Test() throws IOException, ParseException, InterruptedException {
        childProtectionPlan.Go_to_Child_Protection_Tab();
        childProtectionPlan.Begin_Participant(readJsonData.Read_JSON_Data("CHILD_PROTECTION_PLAN"));
    }

}
