package helper.NeedsRequirement;

import BaseClass.TestBase;
import helper.Assign_to_me.Assign_to_me;
import helper.Beneficiaries.Beneficiaries_Setup;
import helper.Inbox.InboxSetup;
import helper.Verification.AssertionHelper;
import helper.Verification.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class Needs_Requirement extends TestBase {

    WaitHelper waitHelper;
    public Needs_Requirement(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'VIEW CHECKLIST')]")
    WebElement ViewChecklistTab;

    @FindBy(xpath = "(//span[contains(text(),'VIEW')])[1]")
    public WebElement View_Xpath;

    @FindBy(xpath = "//span[contains(text(),'VIEW')]")
    List<WebElement>ListView;

    @FindBy(xpath = "//*[@id='doctracks']/mat-drawer-container/mat-drawer/div/core-sidebar/fuse-doctracks-claims-sidenav/div/div/div[2]/div[1]/mat-list/mat-list-item/div/span")
    WebElement Text_Texas_Recon;

    @FindBy(xpath = "//*[@id='doctracks']/mat-drawer-container/mat-drawer/div/core-sidebar/fuse-doctracks-claims-sidenav/div/div/div[2]/div[1]/div/button")
    WebElement SaveButton;

    @FindBy(xpath = "//*[@id='doctracks']/div/div[3]/button[2]/span[1]/mat-icon")
    WebElement Cancel_icon;

    public void Go_to_ViewCheckList() throws InterruptedException {
        waitHelper.waitForElement(driver,ViewChecklistTab,10);
        AssertionHelper.verifyElementPresent(ViewChecklistTab);
        ViewChecklistTab.click();
        Thread.sleep(5000);
    }

    public void Wait_for_View_Page() throws InterruptedException {
        waitHelper.waitForElement(driver,new InboxSetup(driver).Text_Inbox_Tab,10);
        waitHelper.waitForElement(driver,new Beneficiaries_Setup(driver).Beneficiaries_Tab,10);
        waitHelper.waitForElement(driver,View_Xpath,10);
        AssertionHelper.verifyElementPresent(View_Xpath);
        Thread.sleep(5000);
    }

    public void ClickView() throws InterruptedException {
        for (int i=0;i<=ListView.size();i++){
            System.out.println(ListView.get(i).getText());

            if (ListView.get(i).getText().contains(View_Xpath.getText())){
                ListView.get(i).click();
                break;
            }
            else{
                System.out.println("does not starts with B so not clicking");
            }
        }
        Thread.sleep(7000);
    }

    public void Click_Texas_Recon() throws InterruptedException {
        Text_Texas_Recon.click();
        Thread.sleep(2000);
        SaveButton.click();
        waitHelper.waitForElement(driver,new InboxSetup(driver).Text_Inbox_Tab,10);
        Thread.sleep(5000);
    }

    public void Check_Texas_Recon() throws InterruptedException {
        boolean text=Text_Texas_Recon.isDisplayed();
        if (text){
            System.out.println("Element is Present:-"+Text_Texas_Recon.getText());
            Text_Texas_Recon.click();
            Thread.sleep(3000);
            SaveButton.click();
            Thread.sleep(3000);
            waitHelper.waitForElement(driver,View_Xpath,10);
            waitHelper.waitForElement(driver, new Assign_to_me(driver).Assign_to_me_tab,10);
        }

        else {
            System.out.println("Element is not Found");
            Cancel_icon.click();
            Thread.sleep(5000);
        }
    }



}
