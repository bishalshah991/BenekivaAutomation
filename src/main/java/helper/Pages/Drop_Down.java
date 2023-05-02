package helper.Pages;

import BaseClass.TestBase;
import helper.Verification.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class Drop_Down extends TestBase {
    WaitHelper waitHelper;
    public Drop_Down(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,10);
    }

    @FindBy(xpath = "//div[starts-with(@class,'mat-select-trigger')]/div[2]")
    WebElement DropDownArrow;
    @FindBy(xpath = "//div[starts-with(@class,'cdk-overlay-pane')]/div/div/mat-option/span")
    List<WebElement> DropDownList;


    public void Pick_Drop_Down(String Value) throws InterruptedException {
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(DropDownArrow));

        try {
            DropDownArrow.click();
            WebElement element=webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@class,'cdk-overlay-pane')]/div/div/mat-option/span[contains(text(),'"+Value+"')]")));
            System.out.println("The Value of Drop Down:"+element.getText());
        }
        catch (NoSuchElementException exception){
            System.out.println("Element is not Found"+exception);
        }

        WebElement element=driver.findElement(By.xpath("//div[starts-with(@class,'cdk-overlay-pane')]/div/div/mat-option/span[contains(text(),'"+Value+"')]"));
        waitHelper.waitForElement(element);
        System.out.println("The Size of DropDown:-"+DropDownList.size());
        for (int i=0;i<=DropDownList.size();i++){
            System.out.println("The Value of DropDown:-"+DropDownList.get(i).getText());
            if (DropDownList.get(i).getText().contains(Value)){
                DropDownList.get(i).click();
                break;
            }
        }

    }



}
