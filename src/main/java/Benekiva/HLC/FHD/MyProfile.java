package Benekiva.HLC.FHD;

import BaseClass.TestBase;
import helper.Verification.Wait_Helper_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MyProfile extends TestBase {
    Wait_Helper_Page waitHelperPage;

    public MyProfile(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelperPage=new Wait_Helper_Page(driver,10);

    }
    @FindBy(xpath = "//button[starts-with(@class,'mat-focus-indicator mat-menu-trigger')]")
    WebElement MyProfileIcon;

    @FindBy(xpath = "//div[starts-with(@class,'mat-menu-content')]/button[1]/span")
    WebElement MyProfileTab;

    public void Click_My_Profile_Tab() throws InterruptedException {
        MyProfileIcon.click();
        waitHelperPage.Go_to_Wait_for_Element(MyProfileTab);
        MyProfileTab.click();
        Thread.sleep(3000);
    }


}
