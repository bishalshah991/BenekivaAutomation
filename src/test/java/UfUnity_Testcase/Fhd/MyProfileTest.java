package UfUnity_Testcase.Fhd;

import BaseClass.TestBase;
import UfUnity_Pages.FHD.MyProfile;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyProfileTest extends TestBase {

    WaitHelper waitHelper;
    MyProfile myProfile;

    @BeforeClass
    public void Setup() throws IOException, ParseException {
        LaunchBrowser(new ReadJsonData().ReadJSONData("browser_name"));
        driver.get(new ReadJsonData().ReadJSONData("website"));
        waitHelper=new WaitHelper(driver);
        waitHelper.waitForElement(driver,new AccountVerification(driver).TextLoginPage,10);
        new AccountVerification(driver).Login_to_Application(new ReadJsonData().ReadJSONData("unityFhdUsername"),new ReadJsonData().ReadJSONData("unityFhdPassword"));
        myProfile=new MyProfile(driver);
    }

    @Test(priority = 1)
    public void Go_To_My_Profile_Test(){
        new AccountVerification(driver).LogoutArrow.click();
        waitHelper.waitForElement(driver,new AccountVerification(driver).Sign_out_text,10);
    }

    @Test(priority = 2)
    public void Go_To_MyProfile_Test(){
        myProfile.Go_To_MyProfile();
    }

    @Test(priority = 3)
    public void Go_To_MyProfile_Info_Test() throws IOException, ParseException {
        String First_Name=new ReadJsonData().ReadJSONData("First_name");
        String Last_Name=new ReadJsonData().ReadJSONData("Last_name");
        String Title=new ReadJsonData().ReadJSONData("Title_User");
        myProfile.Go_To_MyProfile_Info(First_Name,Last_Name,Title);
    }

    public void LogoutFromApplication()
    {
        new AccountVerification(driver).Logout_from_Application();
        waitHelper.waitForElement(driver,new AccountVerification(driver).TextLoginPage,10);
    }
    @AfterClass
    public void AfterClass(){
        driver.quit();
    }
}
