package helper.View_Checklist;

import BaseClass.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewChecklist extends TestBase {

    public ViewChecklist(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[contains(text(),'VIEW CHECKLIST')]")
    public WebElement View_Check_List_Tab;

}
