package helper.Pages;

import BaseClass.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Signature extends TestBase {

    public Signature(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[normalize-space()='Sign']")
    WebElement sign;
    @FindBy(xpath = "//span[normalize-space()='Submit']") WebElement Submit;
    @FindBy(xpath = "//div[@role='region']//div//canvas") WebElement portfolioId;

    public void SignatureHelperClass() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        sign.click();
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(portfolioId, 200, 100).build().perform();
        actions.dragAndDropBy(portfolioId, 350, 200).build().perform();
        Thread.sleep(7000);
        Submit.click();
    }

}
