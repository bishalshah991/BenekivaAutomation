package UfUnity_Pages.FHD;

import BaseClass.TestBase;
import helper.Verification.AssertionHelper;
import helper.Verification.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfile extends TestBase {
    WaitHelper waitHelper;
    AssertionHelper assertionHelper;

    public MyProfile(WebDriver driver) {
        this.driver=driver;
        waitHelper=new WaitHelper(driver,10);
        assertionHelper=new AssertionHelper();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[starts-with(@class,'mat-menu-content')]/button[1]/span[contains(text(),'My Profile')]")
    WebElement MyProfileTab;

    @FindBy(xpath = "//span[normalize-space()='My Profile']")
    WebElement MyProfileText;
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement FirstName;
    @FindBy(xpath = "//input[@name='middleInitial']")
    WebElement MiddleName;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement LastName;
    @FindBy(xpath = "//input[@name='title']")
    WebElement Title;
    @FindBy(xpath = "//mat-icon[normalize-space()='check_circle']")
    WebElement SaveButton;

    @FindBy(xpath = "//mat-dialog-content[@class='mat-dialog-content']")
    WebElement VerificationAlert;

    @FindBy(xpath = "//span[normalize-space()='CLOSE']")
    WebElement CloseButton ;

    public void Go_To_MyProfile(){
        waitHelper.waitForElement(MyProfileTab);
        MyProfileTab.click();
        waitHelper.waitForElement(MyProfileText);
        assertionHelper.verifyTextEquals(MyProfileText,"My Profile");
    }

    public void Go_To_MyProfile_Info(String f_name,String middle_name,String l_name){
        waitHelper.waitForElement(FirstName);
        FirstName.clear();
        FirstName.sendKeys(f_name);
        MiddleName.clear();
        MiddleName.sendKeys(middle_name);
        LastName.clear();
        LastName.sendKeys(l_name);
        SaveButton.click();
        waitHelper.waitForElement(VerificationAlert);
        CloseButton.click();
        waitHelper.waitForElement(MyProfileText);
    }



}
