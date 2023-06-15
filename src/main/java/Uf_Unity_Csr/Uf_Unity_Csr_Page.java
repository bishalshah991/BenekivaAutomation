package Uf_Unity_Csr;

import BaseClass.TestBase;
import helper.Verification.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class Uf_Unity_Csr_Page extends TestBase {

    WaitHelper waitHelper;
    public Uf_Unity_Csr_Page(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver);
    }

    @FindBy(xpath = "//div[starts-with(@class,'content ng-tns')]/ngx-gridster/div/ngx-gridster-item[1]")
    public WebElement TextClaimActivity;

    public void Wait_for_Claim_Activity(){
       waitHelper.waitForElement(driver,TextClaimActivity,10);
    }
}
