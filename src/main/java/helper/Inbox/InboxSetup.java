package helper.Inbox;

import BaseClass.TestBase;
import helper.Verification.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxSetup extends TestBase {

    WaitHelper waitHelper;
    public InboxSetup(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'INBOX')]")
    public WebElement Text_Inbox_Tab;

    @FindBy(xpath = "//div[contains(text(),'Outbox')]")
    public WebElement Text_Outbox_tab;

    @FindBy(xpath = "//div[@id='inbox_empty']/span")
    public WebElement Text_Inbox_Mail;

    @FindBy(xpath = "//div[contains(text(),'BACK')]")
    public WebElement Back_Tab;


    public void Wait_For_Inbox(){
        waitHelper.waitForElement(driver,Text_Inbox_Tab,10);
    }

    public void Click_Inbox_Tab(){
        Text_Inbox_Tab.click();
        waitHelper.waitForElement(driver,Text_Outbox_tab,10);
        waitHelper.waitForElement(driver,Text_Inbox_Mail,10);
    }

    public void Click_Back_Button(){
        waitHelper.waitForElement(driver,Back_Tab,10);
        Back_Tab.click();
    }
}
