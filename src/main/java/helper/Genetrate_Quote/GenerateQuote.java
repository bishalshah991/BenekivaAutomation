package helper.Genetrate_Quote;

import BaseClass.TestBase;
import Utility.ReadJsonData;
import helper.Pages.Calendar;
import helper.Pages.DropDown;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class GenerateQuote extends TestBase {
    WaitHelper waitHelper;

    public GenerateQuote(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'GENERATE QUOTE')]")
    WebElement Generate_Quote;

    @FindBy(xpath = "//span[contains(text(),'GENERATE QUOTE')]")
    WebElement Generate_Quote_Button;

    @FindBy(xpath = "//*[@id='fb_amt']")
    WebElement Bill_Amount;


    /*
        Start Claim
     */

    @FindBy(xpath = "//span[contains(text(),'START CLAIM')]")
    WebElement Start_Claim;

    @FindBy(xpath = "(//span[contains(text(),'Needs Requirement')])[2]")
    WebElement Text_Needs_Requirement;

    @FindBy(xpath = "//div[contains(text(),'INBOX')]")
    WebElement Text_Inbox;

    @FindBy(xpath = "//div[starts-with(@class,'checklists ng-tns')]/div[1]")
    WebElement Box;

    @FindBy(xpath = "//div[starts-with(@class,'checklists ng-tns')]/div[1]/div/div[3]/button/span[1]/span")
    WebElement StartButton;




    public void Go_to_Generate_Quote_tab(){
        waitHelper.waitForElement(driver,Generate_Quote,10);
        Generate_Quote.click();
        waitHelper.waitForElement(driver,Generate_Quote_Button,10);
    }

    public void Enter_Date_of_Death(String year,String month,String day){
        new Calendar(driver).PickDateFromCalender(year,month,day);
    }

    public void Enter_Cause_of_Death() throws IOException, ParseException {
        String cause=new ReadJsonData().ReadJSONData("Cause_of_Death");
        new DropDown(driver).Handling_Drop_Down(2,cause);
    }

    public void Enter_Bill_Amount(String amount){
        Bill_Amount.click();
        Bill_Amount.sendKeys(amount);
    }

    public void Click_Generate_Quote_Button(){
        Generate_Quote_Button.click();
    }

    public void Click_Start_Claim_Button(){
        waitHelper.waitForElement(driver,Start_Claim,10);
        Start_Claim.click();
        waitHelper.waitForElement(driver,Text_Needs_Requirement,10);
        waitHelper.waitForElement(driver,Text_Inbox,10);
        waitHelper.waitForElement(driver,Box,10);
        waitHelper.waitForElement(driver,StartButton,10);
    }


}
