package helper.Beneficiaries;

import BaseClass.TestBase;
import Utility.RandomNames;
import helper.Pages.JavaScriptHelper;
import helper.Verification.WaitHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.security.Key;

public class Beneficiaries_Setup extends TestBase {

    WaitHelper waitHelper;
    public Beneficiaries_Setup(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'BENEFICIARIES')]")
    public WebElement Beneficiaries_Tab;

    @FindBy(xpath = "//div[@id='forms']/mat-toolbar/span[1]")
    public WebElement Beneficiaries_Box;

    @FindBy(xpath = "//mat-dialog-container[starts-with(@id,'mat-dialog')]/fuse-main-beneficiary-dialog/div/fuse-beneficiary-screen-new/div/div/button/span[1]")
    WebElement AddButton;

    @FindBy(xpath = "//input[@id='BusinessEntity']")
    WebElement Business_Entity;

    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement Text_First_name;

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement Text_Last_Name;

    @FindBy(xpath = "//input[@id='AddressLine1']")
    WebElement Address_1;

    @FindBy(xpath = "//input[@id='AddressLine2']")
    WebElement Address_2;

    @FindBy(xpath = "//input[@id='City']")
    WebElement Text_City;

    @FindBy(xpath = "//input[@id='State']")
    WebElement Text_State;

    @FindBy(xpath = "//input[@id='PostalCode']")
    WebElement Text_Post_Code;

    @FindBy(xpath = "//span[contains(text(),'SAVE RECORD')]")
    WebElement Save_Record_Button;

    /*
        Close Button
     */


    @FindBy(xpath = "//span[contains(text(),'CLOSE')]")
    static
    WebElement CloseButtton;

    @FindBy(xpath = "//div[contains(text(),'Beneficiary on File')]")
    WebElement BeneficiaryTab;

    @FindBy(xpath = "//div[@id='forms']/mat-toolbar/button[2]/span[2]")
    WebElement Cancel_Icon;


    public void Wait_for_Beneficiaries_tab(){
        waitHelper.waitForElement(driver,Beneficiaries_Tab,10);
    }

    public void Click_Beneficiaries(){
        Beneficiaries_Tab.click();
        waitHelper.waitForElement(driver,Beneficiaries_Box,10);
    }

    public void Add_Beneficiary(){
        new JavaScriptHelper(driver).scroll_to_View_And_Click(AddButton);
        waitHelper.waitForElement(driver,Save_Record_Button,10);
    }

    public void Enter_Business_Entity(){
        new JavaScriptHelper(driver).scroll_to_View(Business_Entity);
        Business_Entity.sendKeys("Test Business Entity");
    }

    public void Enter_First_Name_And_Last_Name(){

        String f_name=new RandomNames().GenerateRandomName();
        String l_name=new RandomNames().GenerateRandomName();
        Text_First_name.sendKeys(f_name);
        Text_Last_Name.sendKeys(l_name);
    }

    public void Enter_Address_One() throws InterruptedException {
        Address_1.sendKeys("New Link Road");
        Address_1.sendKeys(Keys.TAB);

        Address_2.sendKeys("Link Road");
        Address_2.sendKeys(Keys.TAB);
        Text_City.sendKeys("New York");
        Text_City.sendKeys(Keys.TAB);
        Text_State.sendKeys("OSA");
        Text_State.sendKeys(Keys.TAB);

        Text_Post_Code.sendKeys("898989");
        Save_Record_Button.click();
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        waitHelper.waitForElement(driver,new Beneficiaries_Setup(driver).Beneficiaries_Tab,10);
    }


    public void CloseButton() throws InterruptedException {
        waitHelper.waitForElement(driver,CloseButtton,10);
        CloseButtton.click();
        Thread.sleep(3000);
    }



}
