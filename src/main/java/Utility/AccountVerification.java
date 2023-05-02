package Utility;

import BaseClass.TestBase;
import helper.Verification.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountVerification extends TestBase {
    WaitHelper waitHelper;

    public AccountVerification(WebDriver driver) {
        this.driver=driver;
        waitHelper=new WaitHelper(driver,10);
        PageFactory.initElements(driver,this);
    }

    /*
        Version of the Application
     */

    @FindBy(xpath = "//form[@name='loginForm']/child::div/span")
    WebElement Version;


    /*
        Xpath for Login Button
     */
    @FindBy(xpath = "//span[normalize-space()='LOGIN']")
    public WebElement LoginButton;

     /*
        Validation for Login Page
     */

    @FindBy(xpath = "//mat-error[contains(text(),' Email is required ')]")
    public WebElement ErrorEmail;

    @FindBy(xpath = "//mat-error[contains(text(),' Password is required ')]")
    public WebElement ErrorPassword;

     /*
        Unity Login page
     */

    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement UsernameXpath;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement PasswordXpath;


    @FindBy(xpath = "//h1[contains(text(),'LOGIN TO YOUR ACCOUNT')]")
    public WebElement TextLoginPage;

    @FindBy(xpath = "//div[@class='advanced-pie chart']")
    WebElement PaymentOverview;


    /*
        Logout From Application
     */

    @FindBy(xpath = "//div[starts-with(@class,'content-wrapper')]/fuse-toolbar/mat-toolbar/div/div[2]/button[2]/span[1]")
    public WebElement LogoutArrow;
    @FindBy(xpath = "//div[starts-with(@class,'mat-menu-content ng-tns')]/button/span[contains(text(),'Sign Out')]")
    public WebElement Sign_out_text;

    @FindBy(xpath = "//h1[contains(text(),'LOGIN TO YOUR ACCOUNT')]")
    WebElement LoginPageText;

    public void Check_Version_Application(){
        System.out.println("Version of the Application:-"+Version.getText());
    }

    public void Login_to_Application(String uname,String password){
        UsernameXpath.sendKeys(uname);
        PasswordXpath.sendKeys(password);
        LoginButton.click();
        waitHelper.waitForElement(PaymentOverview);
    }

    public void Logout_from_Application() throws InterruptedException {
        waitHelper.waitForElement(LogoutArrow);
        //Thread.sleep(2000);
        LogoutArrow.click();
        waitHelper.waitForElement(Sign_out_text);
        Sign_out_text.click();
    }




}
