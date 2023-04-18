package helper.Pages;

import BaseClass.TestBase;
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
    WebElement calendar;
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


}
