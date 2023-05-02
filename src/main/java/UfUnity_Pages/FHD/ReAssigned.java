package UfUnity_Pages.FHD;

import BaseClass.TestBase;
import Intake_Setup.IntakeSetup;
import Utility.ReadJsonData;
import helper.Pages.*;
import helper.Verification.AssertionHelper;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ReAssigned extends TestBase {
    int increment = 1;
    IntakeSetup intakeSetup;
    WaitHelper waitHelper;

    public ReAssigned(WebDriver driver) {
        ReAssigned.driver=driver;
        PageFactory.initElements(driver,this);
        intakeSetup=new IntakeSetup(driver);
        waitHelper=new WaitHelper(driver,10);
    }

    @FindBy(xpath = "//span[contains(text(),'As Reassigned')]")
    public WebElement As_Reassigned_Tab;

    @FindBy(xpath = "//span[contains(text(),' Start Reassigned Claim ')]")
    WebElement Start_Re_Assigned_Claim;

    @FindBy(xpath = "//input[starts-with(@id,'mat-input')]")
    WebElement Input_Data;

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    public WebElement NextButton;

    /*
        Signature Webelement
     */
    @FindBy(xpath = "//*[@id='sigPadButton']/span[1]/span")
    WebElement Sign_Button;

    @FindBy(xpath = "//span[contains(text(),'Signature Pad Dialog')]")
    WebElement Signature_pad;

    @FindBy(xpath = "//div[starts-with(@class,'mat-dialog-content signature-pad')]/mat-accordion/mat-expansion-panel[1]/div/div/canvas")
    WebElement Canvas;

    @FindBy(xpath = "//div[starts-with(@class,'mat-dialog-content signature-pad')]/div/button[2]/span[1]")
    WebElement Submit_Button;

    /*
        Upload Document
     */

    String path="Unity_Test_Data/Image.png";

    @FindBy(xpath = "//span[contains(text(),' Click to Upload Document ')]")
    public WebElement Text_Upload_Document;

    @FindBy(xpath = "//input[starts-with(@class,'d-none ng-tns')]")
    WebElement Upload;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    public WebElement SaveButton;

    /*
        Complete Request Button
     */

    @FindBy(xpath = "//span[contains(text(),'Complete Request')]")
    WebElement CompleteRequestButton;

    /*
        Request Confirmation
     */

    @FindBy(xpath = "//span[contains(text(),'Request Confirmation')]")
    WebElement Request_Confirmation;

    /*
        Cross icon
     */

    @FindBy(xpath = "//mat-toolbar-row[starts-with(@class,'mat-toolbar-row flex flex-row')]/div[2]/button/span[1]")
    WebElement Cross_Icon;

    /*
        Policy Search
     */

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement PolicySearch;

    @FindBy(xpath = "//*[@id='chat-content']/div/div[84]/div[1]")
    public WebElement uploadText;

    public void Wait_For_Next_Button(){
        waitHelper.waitForElement(NextButton);
    }
    public void Click_Next_Button(){
        NextButton.click();
    }

    public void Wait_For_Save_Button(){
        waitHelper.waitForElement(SaveButton);
    }

    public void Click_Save_Button(){
        SaveButton.click();
    }


    public void Go_To_As_Re_Assigned_Tab() throws IOException, ParseException, InterruptedException {
        As_Reassigned_Tab.click();
        waitHelper.waitForElement(Start_Re_Assigned_Claim);
        Start_Re_Assigned_Claim.click();
        Wait_For_Next_Button();
    }

    public void Insured_Date_of_Birth() throws IOException, ParseException {
        String Year_value=new ReadJsonData().ReadJSONData("Date_of_Birth_Year");
        String Day_value=new ReadJsonData().ReadJSONData("Day");
        String Moth_value=new ReadJsonData().ReadJSONData("Date_of_Birth_Month");
        new Calendar(driver).PickDateFromCalender(Year_value,Moth_value,Day_value);
        Click_Next_Button();
        Wait_For_Next_Button();
    }

    public void Insured_Date_of_Death() throws IOException, ParseException {
        String Year_value=new ReadJsonData().ReadJSONData("Date_of_Death_Year");
        String Day_value=new ReadJsonData().ReadJSONData("Day");
        String Moth_value=new ReadJsonData().ReadJSONData("Date_of_Death_Month");
        new Calendar(driver).PickDateFromCalender(Year_value,Moth_value,Day_value);
        Click_Next_Button();
        Wait_For_Next_Button();
    }


    public void Reassigned_Input_Data(String value){
        Input_Data.clear();
        Input_Data.sendKeys(value);
    }


    public void Goto_Signature(){
        waitHelper.waitForElement(Sign_Button);
        Sign_Button.click();
        waitHelper.waitForElement(Signature_pad);

        Actions actions=new Actions(driver);
        actions.dragAndDropBy(Canvas, 200, 100).build().perform();
        actions.dragAndDropBy(Canvas, 350, 200).build().perform();
        Submit_Button.click();
    }

    public void Upload_Document(){
        Upload.sendKeys(path);
    }

    public void Complete_request(){
        waitHelper.waitForElement(CompleteRequestButton);
        CompleteRequestButton.click();
        waitHelper.waitForElement(Request_Confirmation);
        Cross_Icon.click();
        new AssertionHelper().verifyElementNotPresent(PolicySearch);
    }














}
