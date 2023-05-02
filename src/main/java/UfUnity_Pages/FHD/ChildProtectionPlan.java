package UfUnity_Pages.FHD;

import BaseClass.TestBase;
import Intake_Setup.IntakeSetup;
import Utility.ReadJsonData;
import helper.Pages.Calendar;
import helper.Pages.Drop_Down;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ChildProtectionPlan extends TestBase {

    WaitHelper waitHelper;

    public ChildProtectionPlan(WebDriver driver){
        this.driver=driver;
        waitHelper=new WaitHelper(driver,10);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='main-navigation']/fuse-nav-vertical-group[2]/div/div[2]/fuse-nav-vertical-item[1]/div/a/span")
    WebElement Child_Protection_Plan_Tab;

    @FindBy(xpath = "//span[contains(text(),' Child Protection Plan Claim Intake ')]")
    WebElement Child_Protection_Plan_Claim_Intake;

    @FindBy(xpath = "//input[starts-with(@class,'mat-input-element')]")
    public WebElement Input_Data;

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    public WebElement NextButton;

    public void Go_to_Child_Protection_Tab(){
        Child_Protection_Plan_Tab.click();
        waitHelper.waitForElement(Child_Protection_Plan_Claim_Intake);
        Child_Protection_Plan_Claim_Intake.click();
        waitHelper.waitForElement(NextButton);
    }

    public void Insert_Data(String Test){
        Input_Data.sendKeys(Test);
    }
    public void Wait_For_Next_Button(){
        waitHelper.waitForElement(NextButton);
    }
    public void Click_Next_Button(){
        NextButton.click();
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

    public void Click_Drop_Down(String value) throws InterruptedException {
        new Drop_Down(driver).Pick_Drop_Down(value);
    }

    public void InsertNumber(String number){
        Input_Data.sendKeys(number);
        NextButton.click();
        waitHelper.waitForElement(NextButton);
    }





}
