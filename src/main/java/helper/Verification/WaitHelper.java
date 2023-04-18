package helper.Verification;

import BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private WebDriver driver;
    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        System.out.println("WaitHelper :"+this.driver.hashCode());
        PageFactory.initElements(driver,this);
    }

    public void waitForElement(WebDriver driver, WebElement element, long timeout) {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));

        boolean status=element.isDisplayed();
        if (status){
            System.out.println("Element is Displayed:-"+element.getText());
        }
        else {
            System.out.println("Element is not Displayed");
        }

    }
}
