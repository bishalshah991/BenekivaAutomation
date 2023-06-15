package helper.Event_Logs;

import BaseClass.TestBase;
import helper.Assign_to_me.Assign_to_me;
import helper.Inbox.InboxSetup;
import helper.Verification.WaitHelper;
import helper.View_Checklist.ViewChecklist;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventLogs extends TestBase {
    WaitHelper waitHelper;
    public EventLogs(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'EVENT LOGS')]")
    public WebElement Event_Log_Tab;

    public void Wait_For_Event_Log(){
        waitHelper.waitForElement(driver,Event_Log_Tab,10);
        waitHelper.waitForElement(driver,new Assign_to_me(driver).Assign_to_me_tab,10);
    }

    public void Go_to_Event_Logs(){
        Event_Log_Tab.click();
        waitHelper.waitForElement(driver,new InboxSetup(driver).Text_Inbox_Tab,10);
        waitHelper.waitForElement(driver,new ViewChecklist(driver).View_Check_List_Tab,10);
        new InboxSetup(driver).Click_Back_Button();
    }
}
