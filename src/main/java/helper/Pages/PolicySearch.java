package helper.Pages;

import BaseClass.TestBase;
import helper.Verification.AssertionHelper;
import helper.Verification.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PolicySearch extends TestBase {
    WaitHelper waitHelper;
    public static String State;

    AssertionHelper assertionHelper;
    public PolicySearch(WebDriver driver) {
        this.driver=driver;
        waitHelper=new WaitHelper(driver,10);
        assertionHelper=new AssertionHelper();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Policy Search')]")
    WebElement PolicySearchTab;

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement PolicySearchTextBox;

    @FindBy(xpath = "//div[contains(text(),'Active')]")
    WebElement Active;

    @FindBy(xpath = "//button[@aria-label='More']//mat-icon[@role='img']")
    WebElement ClickAction;
    @FindBy(xpath = "//div[starts-with(@class,'mat-menu-content')]")
    WebElement ActionPopup;

    @FindBy(xpath = "//div[starts-with(@class,'mat-menu-content')]/button[1]/span")
    WebElement BeginClaim;

    @FindBy(xpath = "//span[contains(text(),'Generate Quote')]")
    WaitHelper GenetrateQuote ;


    public void Go_to_Policy_Search_Tab(){
        PolicySearchTab.click();
        waitHelper.waitForElement(PolicySearchTextBox);
        assertionHelper.verifyElementPresent(PolicySearchTextBox);
    }

    public void Enter_Policy_Number(String policyNumber){
        PolicySearchTextBox.sendKeys(policyNumber);
        waitHelper.waitForElement(Active);
        assertionHelper.verifyElementPresent(Active);
    }

    public void Click_Action(){
        ClickAction.click();
        waitHelper.waitForElement(ActionPopup);
    }

    public void Click_Begin_Claim(){
        BeginClaim.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Generate Quote')]")));
    }

    public String States() {
        String NowState = State;
        return State;
    }



}
