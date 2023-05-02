package helper.Pages;

import BaseClass.TestBase;
import helper.Verification.WaitHelper;
import org.json.simple.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Calendar extends TestBase {

    public Calendar(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@aria-label='Open calendar']")
    public WebElement calendar;
    @FindBy(xpath = "//div[@class='mat-calendar-content']")
    WebElement calandarList;
    @FindBy(xpath = "//span[normalize-space()='Next']")
    WebElement next;
    @FindBy(xpath = "//span[@id='mat-calendar-button-5']")
    WebElement date;
    @FindBy(xpath = "//button[@aria-label='Previous month']")
    WebElement previousMonthXpath;
    @FindBy(xpath = "//div[starts-with(@class,'content ng-tns')]/form/div[1]/fuse-input-date-control/mat-datepicker-toggle/button/span[1]")
    WebElement DateofDeath;
    @FindBy(xpath = "//div[contains(@class,'mat-calendar-arrow')]")
    WebElement PickYear;
    public static JSONArray json;

    /*
        Calendar
     */
    @FindBy(xpath = "//span[starts-with(@id,'mat-calendar-button')]")
    WebElement YearDropDown;









    public void PickDateFromCalender(String Year, String Month, String Day) throws IOException, org.json.simple.parser.ParseException {
        String year=Year;
        String month=Month;
        String day=Day;
        calendar.click();
        PickYear.click();
        driver.findElement(By.xpath("//div[contains(text(),'"+year+"')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'"+month+"')]")).click();
        driver.findElement(By.xpath("//table[@class='mat-calendar-table']/tbody/tr/td/div[contains(text(),'"+day+"')]")).click();
    }

    public void Click_Calendar(String year,String month,String day){

        calendar.click();
        YearDropDown.click();
        WebElement pickYear=driver.findElement(By.xpath("//div[starts-with(@class,'mat-calendar-content')]/mat-multi-year-view/table/tbody/tr/td/div[contains(text(),'"+year+"')]"));
        pickYear.click();

        WebElement pickMonth=driver.findElement(By.xpath("//div[starts-with(@class,'mat-calendar-content')]/mat-year-view/table/tbody/tr/td/div[contains(text(),'"+month+"')]"));
        new WaitHelper(driver,10).waitForElement(pickMonth);
        pickMonth.click();

        WebElement pickDay=driver.findElement(By.xpath("//div[starts-with(@class,'mat-calendar-content')]/mat-month-view/table/tbody/tr/td/div[contains(text(),'"+day+"')]"));
        new WaitHelper(driver,10).waitForElement(pickDay);
        pickDay.click();

    }


}
