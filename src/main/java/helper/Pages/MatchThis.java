package helper.Pages;

import BaseClass.TestBase;
import helper.Inbox.InboxSetup;
import helper.Verification.AssertionHelper;
import helper.Verification.WaitHelper;
import helper.NeedsRequirement.Needs_Requirement;
import helper.Verification.Wait_Helper_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MatchThis extends TestBase {
    WaitHelper waitHelper;
    Wait_Helper_Page waitHelperPage;

    public MatchThis(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver);
        waitHelperPage=new Wait_Helper_Page(driver,10);
    }

    @FindBy(xpath = "(//span[normalize-space()='Match This'])[1]")
    public WebElement Match_this;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    public WebElement SaveButton;

    @FindBy(xpath ="//span[normalize-space()='Match This']")
    List<WebElement> MatchThis_Count;

    /*
        View Button
     */

    @FindBy(xpath = "(//span[contains(text(),'VIEW')])[1]")
    WebElement ViewButton;

    @FindBy(xpath = "(//mat-icon[contains(text(),'close')])[5]")
    WebElement CloseIcon;

    public void Wait_For_Save(){
        waitHelperPage.Go_to_Wait_for_Element(SaveButton);
    }

    public void Click_Match_This_Each_Box() throws InterruptedException {
        int count=MatchThis_Count.size();
        System.out.println(count);
        for (int i = 1; i <= count; i++) {
            driver.findElement(By.xpath("//div[@fxlayoutalign='center']/div["+i+"]/div/div[3]/button")).click();
        }

        Thread.sleep(5000);
    }

    public void Click_Save_Button() throws InterruptedException {
        SaveButton.click();

        waitHelperPage.Go_to_Wait_for_Element(new InboxSetup(driver).Text_Inbox_Tab);
        AssertionHelper.verifyElementPresent(new InboxSetup(driver).Text_Inbox_Tab);
        waitHelperPage.Go_to_Wait_for_Element(new Needs_Requirement(driver).View_Xpath);
        AssertionHelper.verifyElementPresent(new Needs_Requirement(driver).View_Xpath);

        /*waitHelper.waitForElement(driver,new InboxSetup(driver).Text_Inbox_Tab,10);
        waitHelper.waitForElement(driver,new Needs_Requirement(driver).View_Xpath,10);
        AssertionHelper.verifyElementPresent(new Needs_Requirement(driver).View_Xpath);*/
        Thread.sleep(5000);

    }

    public void Click_View_Button() throws InterruptedException {
        waitHelperPage.Go_to_Wait_for_Element(ViewButton);
        ViewButton.click();
        Thread.sleep(10000);
        CloseIcon.click();
        Thread.sleep(60000);

    }
}
