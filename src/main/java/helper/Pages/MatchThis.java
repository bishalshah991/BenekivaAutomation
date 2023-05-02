package helper.Pages;

import BaseClass.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MatchThis extends TestBase {
    WebElement element;
    public MatchThis(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    public void ClickMatchThis()
    {
        List<WebElement> element=driver.findElements(By.xpath("//span[normalize-space()='Match This']"));
        int count =element.size();
        System.out.println(count);
        for (int i=1;i<=count;i++){
            driver.findElement(By.xpath("//div[@fxlayoutalign='center']/div["+i+"]/div/div[3]/button")).click();
        }
    }
}
