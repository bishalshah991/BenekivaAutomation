package helper.Texas_Recon;

import BaseClass.TestBase;
import helper.Verification.Wait_Helper_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Texas_Recon_Setup extends TestBase {
    Wait_Helper_Page waitHelperPage;
    public Texas_Recon_Setup(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelperPage=new Wait_Helper_Page(driver,10);
    }

    @FindBy(xpath = "//mat-icon[normalize-space()='edit_mode']")
    WebElement TexasReconEditXpath;

    @FindBy(xpath = "//button[@aria-label='SAVE']")
    WebElement SaveTexasReconXpath;

    @FindBy(xpath = "//*[@id='caseload']/div[1]/div[5]/div/div[1]/div[1]/mat-icon")
    WebElement Texas_Icon;

    @FindBy(xpath = "//button[@aria-label='Approve']/span[1]")
    WebElement ApproveTexasReconXpath;;

    public void Wait_Texas_Recon(){
        waitHelperPage.Go_to_Wait_for_Element(Texas_Icon);
    }
    public void Go_to_Texas_Recon() throws InterruptedException {
        TexasReconEditXpath.click();
        Thread.sleep(15000);
        SaveTexasReconXpath.click();
        Thread.sleep(15000);

    }

    public void Go_to_texas_Recon_Approve() throws InterruptedException {
        TexasReconEditXpath.click();
        Thread.sleep(15000);
        ApproveTexasReconXpath.click();
        Thread.sleep(15000);
    }



}
