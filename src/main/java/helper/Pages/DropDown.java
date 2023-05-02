package helper.Pages;

import BaseClass.TestBase;
import helper.Verification.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown extends TestBase {
    WaitHelper objWaitHelper;



    @FindBy(xpath = "//div[starts-with(@class,'mat-select-arrow-wrapper')]")
    WebElement classicDropdownXpath;

    @FindBy(xpath = "//div[starts-with(@role,'listbox')]/mat-option")
    List<WebElement> elements;

    @FindBy(xpath = "//div[starts-with(@role,'listbox')]/mat-option[2]/span")
    WebElement ScrollState;
    public DropDown(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        objWaitHelper = new WaitHelper(driver,10);
    }
    public void SelectUsingVisibleValue(WebElement element1, String visibleValue)
    {
        Select select = new Select(element1);
        select.selectByVisibleText(visibleValue);
    }

    public void BootStrapDropDown(String value) throws InterruptedException {
        classicDropdownXpath.click();
        List<WebElement> allDropDownValues=driver.findElements(By.xpath("//div[@role='listbox']/mat-option"));
        int dropDownCount= allDropDownValues.size();
        WebElement option = driver.findElement(By.xpath("//mat-option[@role='option']/span[contains(text(),'"+value+"')]"));
        System.out.println("Total items present in the dropdown : "+dropDownCount);
        option.click();
    }
    public void MultipleDropDown(String value){
        List<WebElement> allDropDownValues=driver.findElements(By.xpath("//div[@role='listbox']/mat-option"));
        int dropDownCount= allDropDownValues.size();
        WebElement option = driver.findElement(By.xpath("//mat-option[@role='option']/span[normalize-space(text()) = '"+value+"']"));
        System.out.println("Total items present in the dropdown : "+dropDownCount);
        option.click();

    }

    public void BootStrapDropDown1(String value){
        classicDropdownXpath.click();
        List<WebElement> allDropDownValues=driver.findElements(By.xpath("//div[@role='listbox']/mat-option"));
        for (int i=0;i<allDropDownValues.size();i++){
            //new WaitHelper(driver).waitForElement(driver,allDropDownValues.get(i).getText(),10);
        }
    }


    public void Get_Drop_Down_Value(String value) throws InterruptedException {
        driver.findElement(By.xpath("//div[starts-with(@class,'mat-select-arrow-wrapper')]")).click();
        List <WebElement >dropdown_list=driver.findElements(By.xpath("//div[starts-with(@class,'cdk-overlay-pane')]/div/div/mat-option"));
        new WaitHelper(driver,10).waitForElement((WebElement) dropdown_list);

        System.out.println("The Size="+dropdown_list.size());
        for (int i=0;i<=dropdown_list.size();i++){
            System.out.println(dropdown_list.get(i).getText());
            if (dropdown_list.get(i).getText().contains(value)){
                dropdown_list.get(i).click();
                break;
            }
        }
    }


}
