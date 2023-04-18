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
        waitHelper=new WaitHelper(driver);
        waitHelper.waitForElement(driver,new AccountVerification(driver).TextLoginPage,10);
        accountVerification=new AccountVerification(driver);
    }
    @Test(priority = 1)
    public void Check_Version_Application_Test(){
        accountVerification.Check_Version_Application();
    }


    @Test(priority = 4)
    public void Login_to_Application_Test() throws IOException, ParseException {
        String Unity_Username=new ReadJsonData().ReadJSONData("unityFhdUsername");
        String Unity_Password=new  ReadJsonData().ReadJSONData("unityFhdPassword");
        accountVerification.Login_to_Application(Unity_Username,Unity_Password);
    }
    @Test(priority = 5)
    public void Logout_from_Application_Test(){
        accountVerification.Logout_from_Application();
        waitHelper.waitForElement(driver,accountVerification.TextLoginPage,10);
    }
    @AfterClass
    public void Close_Browser_Test(){
        driver.quit();
    }

}
