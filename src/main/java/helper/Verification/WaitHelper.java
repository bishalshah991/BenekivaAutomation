package helper.Verification;

import BaseClass.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper extends TestBase {
    private WebDriver driver;
    WebDriverWait wait;
    public WaitHelper(WebDriver driver,int timeout) {
        this.driver = driver;
        System.out.println("WaitHelper :"+this.driver.hashCode());
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver,Duration.ofMinutes(timeout));
    }


    public void waitForElement(WebElement element) {
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
