package Intake_Setup;

import BaseClass.TestBase;
import UfUnity_Pages.FHD.ChildProtectionPlan;
import Utility.ReadJsonData;
import helper.Pages.*;
import helper.Verification.WaitHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class IntakeSetup extends TestBase {
    String dataJson;
    int increment  = 1;
    public static JSONArray jsonArr;
    public boolean multiQuestion;
    public boolean uploadDoc;
    public boolean checkBox;
    Signature objsignature;
    Upload objupload;
    CheckBox objcheckbox;
    ReadJsonData readJsonData;


    @FindBy(xpath = "//button[@role='button']")
    WebElement Child_Protection_Plan_Intake;

    @FindBy(xpath = "//input")
    WebElement answer;

    @FindBy(xpath = "//input[@type='number']")
    WebElement numberAnswer;

    @FindBy(xpath = "//div[@class='label-container ng-star-inserted']/span")
    WebElement ProgressBarXpath;

    @FindBy(xpath = "//span[normalize-space()='Complete Request']")
    WebElement CompleteXpath;

    @FindBy(xpath = "//span[normalize-space()='Next']")
    WebElement nextXpath;

    DropDown objDropDownHelper = new DropDown(driver);
    Calendar calendar=new Calendar(driver);

    public IntakeSetup(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        objsignature=new Signature(driver);
        objupload=new Upload(driver);
        objcheckbox=new CheckBox(driver);
        readJsonData=new ReadJsonData();
    }

    private void Read_JSON_Data(String path) throws IOException, ParseException {
        Reader reader = new FileReader(path);
        JSONParser parser = new JSONParser();
        jsonArr = (JSONArray) parser.parse(reader);
        System.out.println(jsonArr);
    }

    public void Begin_Participant(){
        Child_Protection_Plan_Intake.click();
        new WaitHelper(driver).waitForElement(driver,new ChildProtectionPlan(driver).NextButton,10);
    }

    public void Participant_Flow(String path) throws IOException, ParseException, InterruptedException {
        IntakeSetup intakeSetup=new IntakeSetup(driver);
        intakeSetup.Read_JSON_Data(path);
        Begin_Participant();
        Start_Flow(increment);
    }

    private void next() throws InterruptedException, ParseException, IOException {
        Thread.sleep(20);
        nextXpath.click();
        Thread.sleep(1000);
        increment = increment +2;
        Start_Flow(increment );
    }

    public void Start_Flow(int n) throws IOException, ParseException, InterruptedException {
        String xpath = "/html/body/fuse-root/fuse-main/mat-sidenav-container/mat-sidenav-content/div/div/div/fuse-content/fuse-fc-new/div[1]/div/div/mat-horizontal-stepper/div[2]/div/div[2]/div/div/div/div["+n+"]/div/div/button";
        System.out.println(xpath);
        driver.findElement(By.xpath(xpath)).getText();
        String questionAsked =   driver.findElement(By.xpath(xpath)).getText();
        multiQuestion = false;
        uploadDoc = false;
        checkBox = false;
        System.out.println( driver.findElement(By.xpath(xpath)).getText());
        for (Object obj : jsonArr) {
            JSONObject jo = (JSONObject) obj;
            if(jo.get("question").equals(questionAsked) ) {
                if (jo.get("answer") != null ) {
                    String ans = jo.get("answer").toString();
                    {
                        if (answer.getAttribute("type").equals("text")){
                            answer.sendKeys(ans);
                        }
                        else{
                            numberAnswer.sendKeys(ans);
                            break;
                        }
                    }
                } else if (jo.get("action") != null) {
                    if(jo.get("action").equals("CALANDER_ACTION")){
                        Calendar Calendar = new Calendar(driver);
//                          String year = jo.get("Year").toString();
//                          String month = jo.get("Month").toString();
//                          String day = jo.get("Day").toString();
//                        Calendar.PickDateFromCalender(year,month,day);

                        calendar.PickDateFromCalender(readJsonData.ReadJSONData("Year"),readJsonData.ReadJSONData("Month"),readJsonData.ReadJSONData("Day"));


                    } else if (jo.get("action").equals("DROPDOWN_ACTION")) {
                        objDropDownHelper = new DropDown(driver);
                        String valueForDropdown = jo.get("value").toString();
                        objDropDownHelper.BootStrapDropDown(valueForDropdown);
                    } else if (jo.get("action").equals("SIGNATURE_ACTION")) {
                        objsignature.SignatureHelperClass();
                    } else if (jo.get("action").equals("UPLOADDOCUMENT_ACTION")) {
                        objupload.addUploadDocument();
                        uploadDoc = true;
                        increment = increment +2;
                    } else if (jo.get("action").equals("PREFILLED_DATA")) {
                        break;
                    } else if (jo.get("action").equals("MULTI_QUESTION")) {
                        multiQuestion = true;
                        increment = increment +1;
                        Thread.sleep(2000);
                        break;
                    } else if (jo.get("action").equals("CHECK_BOX")) {
                        checkBox = true;
                        objcheckbox.Click_Check_Box();
//                        nextXpath.git();
                    } else
                    {
                        multiQuestion = false;
                        System.out.println("Nothing is of this type");
                    }
                }

            }
        }
        System.out.println("progess bar");
        System.out.println(ProgressBarXpath.getText().equals("100%"));
        System.out.println("progess bar");
        if (ProgressBarXpath.getText().equals("100%")){
            CompleteXpath.click();
        }
        else {
            System.out.println(!multiQuestion||!uploadDoc );
            System.out.println(!multiQuestion);
            System.out.println(!multiQuestion);
            if (!multiQuestion ){
                if(!uploadDoc){
                    next();
                }
                else {
                    Start_Flow(increment);
                }
            }
            else{
                Start_Flow(increment);
            }
        }

    }
}
