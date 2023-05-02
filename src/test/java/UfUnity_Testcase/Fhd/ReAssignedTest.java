package UfUnity_Testcase.Fhd;

import BaseClass.TestBase;
import UfUnity_Pages.FHD.ReAssigned;
import Utility.AccountVerification;
import Utility.ReadJsonData;
import helper.Pages.*;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.NoSuchElementException;


public class ReAssignedTest extends TestBase {
    ReadJsonData readJsonData;
    ReAssigned reAssigned;
    WaitHelper waitHelper;

    @BeforeClass
    public void Setup() throws IOException, ParseException {
        LaunchBrowser(new ReadJsonData().ReadJSONData("browser_name"));
        driver.get(new ReadJsonData().ReadJSONData("website"));
        new WaitHelper(driver, 10).waitForElement(new AccountVerification(driver).TextLoginPage);
        new AccountVerification(driver).Login_to_Application(new ReadJsonData().ReadJSONData("unityFhdUsername"), new ReadJsonData().ReadJSONData("unityFhdPassword"));
        reAssigned = new ReAssigned(driver);
        waitHelper = new WaitHelper(driver, 10);
    }

    @Test(priority = 1)
    public void Go_To_As_ReAssigned_Tab_Test() throws IOException, ParseException, InterruptedException {
        reAssigned.Go_To_As_Re_Assigned_Tab();
    }

    @Test(priority = 2)
    public void Insured_Date_of_birth_Test() throws IOException, ParseException, InterruptedException {
        reAssigned.Insured_Date_of_Birth();
    }

    @Test(priority = 3)
    public void Insured_Policy_Certificate() {
        reAssigned.Reassigned_Input_Data("987654");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 4)
    public void Insured_First_Name() {
        reAssigned.Reassigned_Input_Data("Mathew");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 5)
    public void Insured_Middle_Name() {
        reAssigned.Reassigned_Input_Data("Midd");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 6)
    public void Insured_Last_Name() {
        reAssigned.Reassigned_Input_Data("Hayden");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 7)
    public void Insured_Maiden_Name() {
        reAssigned.Reassigned_Input_Data("Test maiden");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 8)
    public void Insured_Social_Security_Number() {
        reAssigned.Reassigned_Input_Data("987654123");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 9)
    public void Insured_Date_of_Death_Test() throws IOException, ParseException, InterruptedException {
        reAssigned.Insured_Date_of_Death();
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();

        new Drop_Down(driver).Pick_Drop_Down("Natural");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();

        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 10)
    public void Insured_Street_Address(){
        reAssigned.Reassigned_Input_Data("Test Address");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 11)
    public void Insured_City() throws InterruptedException {
        reAssigned.Reassigned_Input_Data("Test City");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();

        new Drop_Down(driver).Pick_Drop_Down("AL");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 12)
    public void Insured_Zip_Code() throws InterruptedException {
        reAssigned.Reassigned_Input_Data("98745");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();

        new Drop_Down(driver).Pick_Drop_Down("Yes");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 13)
    public void Insured_Bill_Amount(){
        reAssigned.Reassigned_Input_Data("7878");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();

        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();

        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 14)
    public void Insured_Home_Street_Address(){
        reAssigned.Reassigned_Input_Data("Test Address");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();

        for (int i=1;i<=3;i++){
            reAssigned.Click_Next_Button();
            reAssigned.Wait_For_Next_Button();
        }

    }


    @Test(priority = 15)
    public void Insured_Phone_Number(){
        reAssigned.Reassigned_Input_Data("98745632100");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }
    @Test(priority = 15)
    public void Insured_Fax_Number(){
        Insured_Phone_Number();
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 16)
    public void Home_Email_Address() throws InterruptedException {
        reAssigned.Reassigned_Input_Data("test_01@yopmail.com");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
        new Drop_Down(driver).Pick_Drop_Down("Check");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 17)
    public void Beneficiary_Full_Name(){
        reAssigned.Reassigned_Input_Data("Test Beneficiary Full Name");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 18)
    public void Beneficiary_Relationship(){
        reAssigned.Reassigned_Input_Data("Test Relationship");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 19)
    public void Beneficiary_Residing(){
        reAssigned.Reassigned_Input_Data("Test Resing");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 20)
    public void Insured_City_Test() throws InterruptedException {
        reAssigned.Reassigned_Input_Data("Test City");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();

        new Drop_Down(driver).Pick_Drop_Down("AL");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();

        reAssigned.Reassigned_Input_Data("78965");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();

        Insured_Social_Security_Number();
    }

    @Test(priority = 21)
    public void Insured_Email_Address() throws InterruptedException {
        reAssigned.Reassigned_Input_Data("test_u1@yopmail.com");
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();

        Insured_Phone_Number();
        new Drop_Down(driver).Pick_Drop_Down("Funeral home to deliver to the beneficiary");
        reAssigned.Wait_For_Next_Button();
        reAssigned.Click_Next_Button();
        reAssigned.Wait_For_Next_Button();
    }

    @Test(priority = 22)
    public void Insured_Director_Printed_Name() {
        reAssigned.Reassigned_Input_Data("Test Printed Name");
        reAssigned.Click_Next_Button();
    }

    @Test(priority = 23)
    public void Insured_Signature() throws InterruptedException {
        reAssigned.Goto_Signature();
        reAssigned.Wait_For_Next_Button();
        new Drop_Down(driver).Pick_Drop_Down("Yes");
        reAssigned.Click_Next_Button();
    }

    @Test(priority = 24)
    public void Insured_Beneficiary_Printed_Name() throws InterruptedException {
        reAssigned.Reassigned_Input_Data("Test Bishal");

        boolean isDispalyed = false;
        try {
            reAssigned.SaveButton.isDisplayed();
            System.out.println(reAssigned.SaveButton.getText()+"is Displayed");
            reAssigned.SaveButton.click();
        }
        catch (Exception e){
            System.out.println("Element is not Displayed:"+e);
            isDispalyed=true;
            reAssigned.NextButton.click();
        }
    }

    @Test(priority = 25)
    public void Go_to_Signature() throws InterruptedException {

        boolean isDispalyed = false;

        try
        {
            reAssigned.SaveButton.isDisplayed();
            System.out.println(reAssigned.SaveButton.getText()+"is Displayed");
            reAssigned.SaveButton.click();
        }
        catch (NoSuchElementException e)
        {
            reAssigned.NextButton.isDisplayed();
            reAssigned.NextButton.click();
            System.out.println("Element is not Displayed:"+e);
        }

        catch (Exception e)
        {
            new Signature(driver).sign.isDisplayed();
            new Signature(driver).Get_Signature_Helper();
            System.out.println("Element is not Displayed:"+e);
        }
        finally
        {
            System.out.println("The Exception is not Displayed");
        }
        reAssigned.Wait_For_Next_Button();

    }

    @Test(priority = 26)
    public void Upload_Funeral_Home_Bill() throws InterruptedException {
        if (reAssigned.Text_Upload_Document.isDisplayed())
        {
            try {
                new Upload(driver).addUploadDocument();
                reAssigned.NextButton.click();
            }
            catch (NoSuchElementException | InterruptedException e){
                new Upload(driver).addUploadDocument();
                reAssigned.SaveButton.click();
            }
            catch (Exception e){
                new Signature(driver).Get_Signature_Helper();
            }
        }



    }
    //@AfterClass
    public void AfterClass(){
        driver.quit();
    }







}


















