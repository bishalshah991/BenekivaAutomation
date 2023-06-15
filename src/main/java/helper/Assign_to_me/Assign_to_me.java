package helper.Assign_to_me;

import BaseClass.TestBase;
import helper.Verification.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Assign_to_me extends TestBase {
    WaitHelper waitHelper;

    public Assign_to_me(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'ASSIGN TO ME')]")
    public WebElement Assign_to_me_tab;

    @FindBy(xpath = "//span[contains(text(),'CONFIRM')]")
    WebElement ConfirmButton;
    @FindBy(xpath = "//div[contains(text(),'UNASSIGNED')]")
    WebElement Un_Assigned_tab;

    public void Go_to_Assign_to_me(){
        waitHelper.waitForElement(driver,Assign_to_me_tab,10);
        Assign_to_me_tab.click();
        waitHelper.waitForElement(driver,ConfirmButton,10);
    }

    public void Click_Confirm_Button(){
        ConfirmButton.click();
        waitHelper.waitForElement(driver,Un_Assigned_tab,10);
    }
}
