package UfUnity_Testcase.Fhd;


import BaseClass.TestBase;
import Intake_Setup.IntakeSetup;
import UfUnity_Pages.FHD.ChildProtectionPlan;
import UfUnity_Pages.FHD.ReAssigned;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Pages.Signature;
import helper.Pages.Upload;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class ChildProtectionPlanTest extends TestBase {
    ChildProtectionPlan childProtectionPlan;
    ReadJsonData readJsonData;
    WaitHelper waitHelper;


    @BeforeClass
    public void Setup() throws IOException, ParseException {
        LaunchBrowser(new ReadJsonData().ReadJSONData("browser_name"));
        driver.get(new ReadJsonData().ReadJSONData("website"));
        waitHelper=new WaitHelper(driver,10);
        waitHelper.waitForElement(new AccountVerification(driver).TextLoginPage);
        new AccountVerification(driver).Login_to_Application(new ReadJsonData().ReadJSONData("unityFhdUsername"),new ReadJsonData().ReadJSONData("unityFhdPassword"));
        childProtectionPlan=new ChildProtectionPlan(driver);
    }

    @Test(priority = 1)
    public void Go_to_Child_Protection_Tab_Test(){
        childProtectionPlan.Go_to_Child_Protection_Tab();
    }
    @Test(priority = 2)
    public void Insert_Data_test(){
        for (int i=1;i<=4;i++){
            childProtectionPlan.Insert_Data("Test");
            childProtectionPlan.NextButton.click();
            waitHelper.waitForElement(childProtectionPlan.NextButton);
        }
    }
    @Test(priority = 3)
    public void InsertNumber(){
        for (int i=1;i<=2;i++){
            childProtectionPlan.InsertNumber("789");
        }
    }
    @Test(priority = 4)
    public void Insert_Date_of_birth() throws IOException, ParseException {
        childProtectionPlan.Insured_Date_of_Birth();
    }

    @Test(priority = 5)
    public void Insert_Date_of_death() throws IOException, ParseException {
        childProtectionPlan.Insured_Date_of_Death();
    }

    @Test(priority = 6)
    public void Select_Cause_of_Death() throws InterruptedException {
        childProtectionPlan.Click_Drop_Down("Natural");
        childProtectionPlan.Click_Next_Button();
        childProtectionPlan.Wait_For_Next_Button();
    }

    @Test(priority = 7)
    public void Pick_Gender() throws InterruptedException {
        childProtectionPlan.Click_Drop_Down("Male");
        childProtectionPlan.Click_Next_Button();
        childProtectionPlan.Wait_For_Next_Button();
    }

    @Test(priority = 8)
    public void Pick_Medicaid() throws InterruptedException {
        childProtectionPlan.Click_Drop_Down("Yes");
        childProtectionPlan.Click_Next_Button();
        childProtectionPlan.Wait_For_Next_Button();
    }

    @Test(priority = 9)
    public void Pick_State() throws InterruptedException {
        childProtectionPlan.Click_Drop_Down("AL");
        childProtectionPlan.Click_Next_Button();
        childProtectionPlan.Wait_For_Next_Button();
    }

    @Test(priority = 10)
    public void Enter_Bill_Amount(){
        childProtectionPlan.InsertNumber("789");
    }

    @Test(priority = 11)
    public void Funeral_Home_Name(){
        childProtectionPlan.Insert_Data("Test");
        childProtectionPlan.NextButton.click();
        waitHelper.waitForElement(childProtectionPlan.NextButton);
        childProtectionPlan.InsertNumber("789");
    }

    @Test(priority = 12)
    public void Home_Location() throws InterruptedException {
        for (int i=1;i<=2;i++){
            childProtectionPlan.Insert_Data("Test");
            childProtectionPlan.NextButton.click();
            waitHelper.waitForElement(childProtectionPlan.NextButton);
        }
        Pick_State();
        childProtectionPlan.InsertNumber("789");
    }

    @Test(priority = 13)
    public void Insert_PhoneNumber(){
        childProtectionPlan.InsertNumber("9876543210");
        childProtectionPlan.InsertNumber("9876543210");
    }
    @Test(priority = 14)
    public void EnterEmail(){
        childProtectionPlan.Insert_Data("tes@yopmail.com");
        childProtectionPlan.Click_Next_Button();
        childProtectionPlan.Wait_For_Next_Button();
    }

    @Test(priority = 15)
    public void Amount_Drop_Down() throws InterruptedException {
        childProtectionPlan.Click_Drop_Down("1 check to funeral home for funeral amount");
        childProtectionPlan.Click_Next_Button();
        childProtectionPlan.Wait_For_Next_Button();
    }


    @Test(priority = 15)
    public void Direction_Printed_Name(){
        childProtectionPlan.Input_Data.sendKeys("Test Direction");
        childProtectionPlan.Click_Next_Button();

    }
    @Test(priority = 17)
    public void Sign() throws InterruptedException {
        new Signature(driver).Get_Signature_Helper();
        childProtectionPlan.Click_Drop_Down("Yes");
        childProtectionPlan.Click_Next_Button();
        childProtectionPlan.Wait_For_Next_Button();
    }

    @Test(priority = 18)
    public void Beneficiary_Printed_Name() throws InterruptedException {
        childProtectionPlan.Insert_Data("Test");
//        childProtectionPlan.Click_Next_Button();
//        childProtectionPlan.Wait_For_Next_Button();
//        Thread.sleep(3000);

        boolean isDispalyed = false;
        try {
            childProtectionPlan.NextButton.isDisplayed();
            System.out.println(childProtectionPlan.NextButton.getText()+"is Displayed");
            childProtectionPlan.NextButton.click();
        }
        catch (Exception e){
            System.out.println("Element is not Displayed:"+e);
            isDispalyed=true;
            new Signature(driver).sign.click();
        }
        Thread.sleep(3000);
    }
    //@Test(priority = 19)
    public void Signature(){
        new Signature(driver).Get_Signature_Helper();
    }
    //@Test(priority = 20)
    public void UploadDocument() throws InterruptedException {
        childProtectionPlan.Wait_For_Next_Button();
        new Upload(driver).addUploadDocument();
    }

   // @Test(priority = 19)
    public void CompleteRequest(){
        new ReAssigned(driver).Complete_request();
    }
   @Test(priority = 20)
    public void Log_out_FromApplication() throws InterruptedException {
        new AccountVerification(driver).Logout_from_Application();
    }
    @AfterClass
    public void AfterClass(){
        driver.quit();
    }

}
