package helper.Pages;

import BaseClass.TestBase;
import helper.Verification.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signature extends TestBase {
    WaitHelper waitHelper;

    public Signature(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,10);
    }

    /*
        Signature Webelement
     */
    @FindBy(xpath = "//*[@id='sigPadButton']/span[1]/span")
    WebElement Sign_Button;

    @FindBy(xpath = "//span[contains(text(),'Signature Pad Dialog')]")
    WebElement Signature_pad;

    @FindBy(xpath = "//div[starts-with(@class,'mat-dialog-content signature-pad')]/mat-accordion/mat-expansion-panel[1]/div/div/canvas")
    WebElement Canvas;

    @FindBy(xpath = "//div[starts-with(@class,'mat-dialog-content signature-pad')]/div/button[2]/span[1]")
    WebElement Submit_Button;


    WebDriver driver;

    @FindBy(xpath = "//div[starts-with(@class,'text-center ng-tns')]/button/span[1]/span") public WebElement sign;

    @FindBy(xpath = "//span[normalize-space()='Submit']") WebElement Submit;
    @FindBy(xpath = "//div[@role='region']//div//canvas") WebElement portfolioId;


    public void SignatureHelperClass() throws InterruptedException
    {
        new WaitHelper(driver,10).waitForElement(sign);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        sign.click();
        new WaitHelper(driver,10).waitForElement(Submit);
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(portfolioId, 200, 100).build().perform();
        actions.dragAndDropBy(portfolioId, 350, 200).build().perform();
        //Thread.sleep(7000);
        Submit.click();
    }

    public void Get_Signature_Helper(){
            waitHelper.waitForElement(Sign_Button);
            Sign_Button.click();
            waitHelper.waitForElement(Signature_pad);

            Actions actions=new Actions(driver);
            actions.dragAndDropBy(Canvas, 200, 100).build().perform();
            actions.dragAndDropBy(Canvas, 350, 200).build().perform();
            Submit_Button.click();
        }


}
