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



    @FindBy(xpath = "//div[contains(@class,'mat-select-arrow')]")
    WebElement classicDropdownXpath;

    public DropDown(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        objWaitHelper = new WaitHelper(driver);
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
}
