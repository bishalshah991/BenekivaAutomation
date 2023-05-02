package UfUnity_Testcase.Fhd;

import BaseClass.TestBase;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends TestBase {
    WaitHelper waitHelper;
    AccountVerification accountVerification;

    @BeforeClass
    public void setup() throws IOException, ParseException {
        LaunchBrowser(new ReadJsonData().ReadJSONData("browser_name"));
        driver.get(new ReadJsonData().ReadJSONData("website"));
        waitHelper=new WaitHelper(driver,10);
        waitHelper.waitForElement(new AccountVerification(driver).TextLoginPage);
        accountVerification=new AccountVerification(driver);
    }
    @Test(priority = 1,testName = "Check Browser Version")
    public void Check_Version_Application_Test(){
        accountVerification.Check_Version_Application();
    }


    @Test(priority = 4,testName = "Login to Application Test")
    public void Login_to_Application_Test() throws IOException, ParseException {
        String Unity_Username=new ReadJsonData().ReadJSONData("unityFhdUsername");
        String Unity_Password=new  ReadJsonData().ReadJSONData("unityFhdPassword");
        accountVerification.Login_to_Application(Unity_Username,Unity_Password);
    }
    @Test(priority = 5)
    public void Logout_from_Application_Test() throws InterruptedException {
        accountVerification.Logout_from_Application();
        waitHelper.waitForElement(accountVerification.TextLoginPage);
    }
    @AfterClass
    public void Close_Browser_Test(){
        driver.quit();
    }

}
