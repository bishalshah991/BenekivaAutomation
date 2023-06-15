package helper.Claim_Tag;

import BaseClass.TestBase;
import helper.Pages.DropDown;
import helper.Verification.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClaimTag extends TestBase {
    WaitHelper waitHelper;

    public ClaimTag(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'CLAIM TAG')]")
    public WebElement Claim_Tag_Tab;

    @FindBy(xpath = "//span[contains(text(),'CONFIRM')]")
    WebElement ConfirmButton;

    @FindBy(xpath = "//input[starts-with(@class,'mat-autocomplete-trigger')]")
    WebElement Select_User_Tags;

    @FindBy(xpath = "//textarea[@id='ClaimTagReason']")
    WebElement Enter_Tag_Reason;


    public void Wait_For_Claim(){
        WaitHelper.Wait_For_Element(driver,Claim_Tag_Tab,10);
    }
    public void Go_to_Claim_Tag(){
        Claim_Tag_Tab.click();
        waitHelper.waitForElement(driver,ConfirmButton,10);
    }

    public void Remark_Dialog_Box() throws InterruptedException {
        Select_User_Tags.click();
        String text="Contestable";
        new DropDown(driver).Handling_Drop_Down(2,text);
        Enter_Tag_Reason.sendKeys("Text Tag Reason");
        ConfirmButton.click();
        Thread.sleep(3000);
    }



}
