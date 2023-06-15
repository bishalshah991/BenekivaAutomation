package helper.Lock_Out;

import BaseClass.TestBase;
import helper.Inbox.InboxSetup;
import helper.Verification.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LockOut extends TestBase {
    WaitHelper waitHelper;
    public LockOut(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'LOCK OUT')]")
    WebElement LockOut;

    @FindBy(xpath = "//a[contains(text(),'Click here to release lock')]")
    WebElement LockOutText;

    public void Wait_LockOut(){
        waitHelper.waitForElement(driver,LockOut,10);
    }

    public void Click_Lock_Out(){
        LockOut.click();
        waitHelper.waitForElement(driver,LockOutText,10);
        LockOutText.click();
        waitHelper.waitForElement(driver,new InboxSetup(driver).Text_Inbox_Tab,10);
        new InboxSetup(driver).Click_Back_Button();
    }
}
