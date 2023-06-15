package helper.ClaimInformation;

import BaseClass.TestBase;
import helper.Assign_to_me.Assign_to_me;
import helper.Beneficiaries.Beneficiaries_Setup;
import helper.Inbox.InboxSetup;
import helper.Pages.JavaScriptHelper;
import helper.Verification.Wait_Helper_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Claim_Information_Page extends TestBase {
    Wait_Helper_Page waitHelperPage;

    public Claim_Information_Page(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelperPage=new Wait_Helper_Page(driver,10);
    }

    @FindBy(xpath = "//mat-select[@id='claim_type']")
    WebElement Claim_type_None_Select;

    @FindBy(xpath = "//div[@role='listbox']/mat-option/span")
    List<WebElement> listClaim;

    @FindBy(xpath = "//div[@role='listbox']/mat-option/span[contains(text(),'Fax')]")
    WebElement Fax;

    @FindBy(xpath = "//input[@id='spoke_with']")
    WebElement TextSpokeWith;

    /*
        Relationship
     */

    @FindBy(xpath = "//span[contains(text(),'[None Selected]')]")
    WebElement Relationship_None_Select;

    @FindBy(xpath = "//div[@role='listbox']/mat-option/span")
    List<WebElement> listRelationship;

    @FindBy(xpath = "//div[@role='listbox']/mat-option/span[contains(text(),'Attorney')]")
    WebElement Attorney;

    @FindBy(xpath = "//input[@id='phone_number']")
    WebElement TextPhoneNumber;

    @FindBy(xpath = "//input[@id='insured_date_of_birth']")
    WebElement DOB;

    @FindBy(xpath = "//input[@id='user_provided_insured_date_of_birth']")
    WebElement Insured_DOB;

    @FindBy(xpath = "//span[@class='mat-checkbox-label']")
    WebElement CheckBox;

    @FindBy(xpath = "//span[contains(text(),'ACCEPT')]")
    WebElement AcceptButton;


    /*

    Submit Claim
     */

    @FindBy(xpath = "//span[contains(text(),'SUBMIT CLAIM')]")
    WebElement Submit_Claim_Button;



    public void Wait_Claim_Type(){
        waitHelperPage.Go_to_Wait_for_Element(Claim_type_None_Select);
        Claim_type_None_Select.click();
        waitHelperPage.Go_to_Wait_for_Element(Fax);

        for (int i=0;i<=listClaim.size();i++){
            System.out.println(listClaim.get(i).getText());
            if (listClaim.get(i).getText().contains(Fax.getText()))
            {
                listClaim.get(i).click();
                break;
            }
        }
    }


    public void Spoke_With(){
        TextSpokeWith.sendKeys("Test Spoke With");
    }

    public void Click_relationship(){
        Relationship_None_Select.click();
        waitHelperPage.Go_to_Wait_for_Element(Attorney);

        for (int i=0;i<=listRelationship.size();i++){
            System.out.println(listRelationship.get(i).getText());
            if (listRelationship.get(i).getText().contains(Attorney.getText()))
            {
                listRelationship.get(i).click();
                break;
            }
        }

    }

    public void Enter_Phone_Number() throws InterruptedException {
        TextPhoneNumber.sendKeys("9803001742");
        Thread.sleep(2000);
        new JavaScriptHelper(driver).scroll_to_View(CheckBox);
    }

    public void Enter_Insured_Dob() throws InterruptedException {
        Insured_DOB.click();
        Thread.sleep(2000);
        Insured_DOB.sendKeys("05/15/2023");
        Thread.sleep(2000);
        CheckBox.click();
        AcceptButton.click();
        waitHelperPage.Go_to_Wait_for_Element(Submit_Claim_Button);
    }
    public void Submit_Claim(){
        Submit_Claim_Button.click();
        waitHelperPage.Go_to_Wait_for_Element(new InboxSetup(driver).Text_Inbox_Tab);
        waitHelperPage.Go_to_Wait_for_Element(new Beneficiaries_Setup(driver).Beneficiaries_Tab);
        waitHelperPage.Go_to_Wait_for_Element(new Assign_to_me(driver).Assign_to_me_tab);
    }



}
