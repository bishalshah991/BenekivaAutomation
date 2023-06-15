package helper.Policy_Search;

import BaseClass.TestBase;
import Utility.ReadJsonData;
import com.beust.ah.A;
import helper.Genetrate_Quote.GenerateQuote;
import helper.Inbox.InboxSetup;
import helper.Verification.AssertionHelper;
import helper.Verification.WaitHelper;
import helper.Verification.Wait_Helper_Page;
import helper.View_Checklist.ViewChecklist;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class PolicySearch extends TestBase {
    Wait_Helper_Page waitHelperPage;
    public PolicySearch(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelperPage=new Wait_Helper_Page(driver,10);

    }

    @FindBy(xpath = "//span[contains(text(),'Policy Search')]")
    WebElement Policy_search_Tab;

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement Policy_search_TextBox;

    @FindBy(xpath = "//mat-table[starts-with(@class,'mat-table cdk-table mat-sort ng-tns')]/mat-row/mat-cell[10]/div")
    static
    WebElement Active;

    @FindBy(xpath = "//div[contains(text(),'Active')]")
    public WebElement Active_One;

    @FindBy(xpath = "//mat-table[starts-with(@class,'mat-table cdk-table mat-sort ng-tns')]/mat-row/mat-cell[1]/div")
    public WebElement PolicyNumber;

    @FindBy(xpath = "//mat-table[starts-with(@class,'mat-table cdk-table mat-sort ng-tns')]/mat-row/mat-cell[10]/div")
    public static WebElement TextNeedsRequirement;

    @FindBy(xpath = "//mat-table[starts-with(@class,'mat-table cdk-table mat-sort ng-tns')]/mat-row/mat-cell[5]/div/button/span[1]")
    WebElement Action_Three_Dots;

    @FindBy(xpath = "//mat-table[starts-with(@class,'mat-table cdk-table mat-sort ng-tns')]/mat-row/mat-cell[5]/div/button/span[1]")
    public WebElement Action_Three_Dot_One;

    @FindBy(xpath = "//span[contains(text(),'Begin Claim')]")
    public WebElement Begin_Claim;

    @FindBy(xpath = "//div[starts-with(@class,'checklists ng')]/div[1]")
    WebElement PolicyDetail;

    @FindBy(xpath = "//div[contains(text(),'GENERATE QUOTE')]")
    WebElement GenerateQuoteTab;

    @FindBy(xpath = "//span[contains(text(),'View Details')]")
    WebElement ViewDetail;

    @FindBy(xpath = "//div[contains(text(),'VIEW CHECKLIST')]")
    WebElement ViewChecklistTab;

    @FindBy(xpath = "//span[contains(text(),'START')]")
    WebElement StartButton;

    @FindBy(xpath = "//div[contains(text(),'GENERATE QUOTE')]")
    WebElement Generate_Quote_tab;
    /*
        Search Text Box
     */

    @FindBy(xpath = "//input[@placeholder='Type keywords and Press Enter....']")
    WebElement TypeKeyword;




    public void Go_to_Policy_Search_Tab(){
        waitHelperPage.Go_to_Wait_for_Element(Policy_search_Tab);
        Policy_search_Tab.click();
    }

    public void Go_to_Policy_Search_Text_Box(String Policy_Number){
        waitHelperPage.Go_to_Wait_for_Element(Policy_search_TextBox);
        Policy_search_TextBox.sendKeys(Policy_Number);
    }

    public void Wait_Search_Keyword(){
        waitHelperPage.Go_to_Wait_for_Element(TypeKeyword);

    }

    public void Wait_For_Active(){
        waitHelperPage.Go_to_Wait_for_Element(Active_One);
        waitHelperPage.Go_to_Wait_for_Element(Action_Three_Dot_One);
    }

    public void Go_to_Active_Policy(){
        waitHelperPage.Go_to_Wait_for_Element(Active);
        waitHelperPage.Go_to_Wait_for_Element(PolicyNumber);
        AssertionHelper.verifyElementPresent(Active);
        Action_Three_Dot_One.click();
        waitHelperPage.Go_to_Wait_for_Element(Begin_Claim);
        Begin_Claim.click();
    }

    public void Go_to_Needs_Requirement(){
        waitHelperPage.Go_to_Wait_for_Element(TextNeedsRequirement);
        waitHelperPage.Go_to_Wait_for_Element(PolicyNumber);
        AssertionHelper.verifyElementPresent(TextNeedsRequirement);
        Action_Three_Dots.click();
        waitHelperPage.Go_to_Wait_for_Element(ViewDetail);
        AssertionHelper.verifyElementPresent(ViewDetail);
        ViewDetail.click();
        waitHelperPage.Go_to_Wait_for_Element(ViewChecklistTab);
        AssertionHelper.verifyElementPresent(ViewChecklistTab);
    }

    public void Go_to_View_CheckList(){
        ViewChecklistTab.click();
        waitHelperPage.Go_to_Wait_for_Element(new InboxSetup(driver).Text_Inbox_Tab);
        waitHelperPage.Go_to_Wait_for_Element(StartButton);
        AssertionHelper.verifyElementPresent(StartButton);
    }























   /*public void Click_Begin_Claim(){
        Begin_Claim.click();
        waitHelper.waitForElement(driver,PolicyDetail,10);
        waitHelper.waitForElement(driver,GenerateQuoteTab,10);
    }*/

    public void Go_to_View_Detail(){
        WaitHelper.Wait_For_Element(driver,ViewDetail,10);
        AssertionHelper.verifyElementPresent(ViewDetail);
        ViewDetail.click();
    }

}
