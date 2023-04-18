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
        waitHelper=new WaitHelper(driver);
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

    @FindBy(xpath = "//mat-icon[contains(text(),'keyboard_arrow_down')]")
    public WebElement LogoutArrow;
    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    public WebElement Sign_out_text;

    public void Check_Version_Application(){
        System.out.println("Version of the Application:-"+Version.getText());
    }

    public void Login_to_Application(String uname,String password){
        UsernameXpath.sendKeys(uname);
        PasswordXpath.sendKeys(password);
        LoginButton.click();
        waitHelper.waitForElement(driver,PaymentOverview,10);
    }

    public void Logout_from_Application(){
        LogoutArrow.click();
        waitHelper.waitForElement(driver,Sign_out_text,10);
        Sign_out_text.click();
    }




}
