package helper.Policy_Search;

import BaseClass.TestBase;
import com.beust.ah.A;
import helper.Verification.AssertionHelper;
import helper.Verification.Wait_Helper_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolicySearch1 extends TestBase {

    Wait_Helper_Page waitHelperPage;
    public PolicySearch1(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelperPage=new Wait_Helper_Page(driver,10);
    }

    @FindBy(xpath = "//span[contains(text(),'Policy Search')]")
    WebElement Policy_search_Tab;
    @FindBy(xpath = "//input[@placeholder='Type keywords and Press Enter....']")
    WebElement Type_Key_Enter;

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement Policy_search_Text_Box;

    @FindBy(xpath = "//div[contains(text(),'Active')]")
    public WebElement Active;

    @FindBy(xpath = "//div[contains(text(),'Settled')]")
    public WebElement Settled;

    @FindBy(xpath = "//mat-row[starts-with(@class,'mat-row cdk-row ng-tns')]/mat-cell[11]/div/button/span[1]")
    public WebElement Action_Three_Dots;

    @FindBy(xpath = "//span[contains(text(),'Begin Claim')]")
    public WebElement Begin_Claim;


    public void Go_to_Policy_Search_Tab(){
        waitHelperPage.Go_to_Wait_for_Element(Policy_search_Tab);
        AssertionHelper.Verify_the_an_Element(Policy_search_Tab);
        Policy_search_Tab.click();
    }

    public void Search_Text_Box(){
        waitHelperPage.Go_to_Wait_for_Element(Type_Key_Enter);
        AssertionHelper.verifyElementPresent(Type_Key_Enter);
    }

    public void Enter_Policy_Number(String policy_no) throws InterruptedException {

        Policy_search_Text_Box.sendKeys(policy_no);

        try {
            waitHelperPage.Go_to_Wait_for_Element(Active);
            AssertionHelper.verifyElementPresent(Active);
            Thread.sleep(3000);
        }
        catch (Exception e){
            System.out.println("The Element is not displayed:"+e);
            waitHelperPage.Go_to_Wait_for_Element(Settled);
            AssertionHelper.verifyElementPresent(Settled);
        }

    }

    public void Click_Action(){
        Action_Three_Dots.click();
        waitHelperPage.Go_to_Wait_for_Element(Begin_Claim);
    }

    public void Click_Begin_Claim(){
        Begin_Claim.click();
    }
}
