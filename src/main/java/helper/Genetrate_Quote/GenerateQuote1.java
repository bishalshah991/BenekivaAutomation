package helper.Genetrate_Quote;

import BaseClass.TestBase;
import Utility.ReadJsonData;
import helper.Verification.Wait_Helper_Page;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class GenerateQuote1 extends TestBase {
    Wait_Helper_Page waitHelperPage;

    public GenerateQuote1(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelperPage=new Wait_Helper_Page(driver,10);
    }

    @FindBy(xpath = "//div[contains(text(),'GENERATE QUOTE')]")
    WebElement GenerateQuote_Tab;

    @FindBy(xpath = "//span[contains(text(),'GENERATE QUOTE')]")
    WebElement Generate_Quote_Button;

    /*
        Cause of Death
     */

    @FindBy(xpath = "//span[contains(text(),'[None Selected]')]")
    WebElement Cause_Of_Death_Drop_Down;

    @FindBy(xpath = "//div[@id='causeOfDeath-panel']/mat-option/span")
    List<WebElement>dropDownList;

    @FindBy(xpath = "//span[contains(text(),'PENDING')]")
    WebElement TextPending;

    /*
        Select Radio Button
     */

    @FindBy(xpath = "//mat-radio-group[starts-with(@class,'mat-radio-group')]/mat-radio-button[1]/label/span[1]/span[1]")
    WebElement Radio_Yes;

    /*
        Bill Amount
     */

    @FindBy(xpath = "//input[@id='funeralAmount']")
    WebElement Text_Bill_Amount;

    /*
        Date of Death
     */

    @FindBy(xpath = "//input[@id='v_datDeath']")
    WebElement Text_Date_of_Death;

    /*
        Generate Quote Button
     */

    @FindBy(xpath = "//span[contains(text(),'GENERATE QUOTE')]")
    WebElement GenerateQuoteButton;

    /*
        Start Claim
     */

    @FindBy(xpath = "//span[contains(text(),'START CLAIM')]")
    WebElement StartClaimButton;

    public void Wait_For_Generate_Quote(){
        waitHelperPage.Go_to_Wait_for_Element(GenerateQuote_Tab);
        GenerateQuote_Tab.click();
        waitHelperPage.Go_to_Wait_for_Element(Generate_Quote_Button);
    }

    public void Click_Cause_Death() throws InterruptedException {
        Cause_Of_Death_Drop_Down.click();
        waitHelperPage.Go_to_Wait_for_Element(TextPending);
        int count=dropDownList.size();
        System.out.println("Total Number:-"+count);

        for (int i=0;i<dropDownList.size();i++){
            System.out.println(dropDownList.get(i).getText());
            if (dropDownList.get(i).getText().contains(TextPending.getText())){
                dropDownList.get(i).click();
                break;
            }

        }
        Thread.sleep(2000);
    }

    public void Go_to_Radio_Button(){
        try {
            waitHelperPage.Go_to_Wait_for_Element(Radio_Yes);
            Radio_Yes.isDisplayed();
            Radio_Yes.click();
        }
        catch (Exception e){
            System.out.println("Radio Button is not Displayed:"+e);
        }
    }

    public void Enter_Bill_Amount(String bill_amt) throws InterruptedException {

        try {
            Text_Bill_Amount.isDisplayed();
            Text_Bill_Amount.click();
            Thread.sleep(2000);
            Text_Bill_Amount.sendKeys(bill_amt);
        }
        catch (Exception exception)
        {
            System.out.println("Element is not Displayed");
        }

    }

    public void Enter_Date_of_Death() throws IOException, ParseException {
        Text_Date_of_Death.sendKeys(new ReadJsonData().ReadJSONData("Date-of-Death"));
    }

    public void Click_Generate_Button(){
        GenerateQuoteButton.click();
        waitHelperPage.Go_to_Wait_for_Element(StartClaimButton);
    }

    public void Go_to_Start_Claim(){
        try {
            StartClaimButton.isDisplayed();
            StartClaimButton.click();
        }
        catch (Exception e)
        {
            System.out.println("Element is not Displayed:-"+e);
        }

    }

}
