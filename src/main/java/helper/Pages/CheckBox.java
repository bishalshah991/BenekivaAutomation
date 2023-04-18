package helper.Pages;

import BaseClass.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBox extends TestBase {
    public CheckBox(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//mat-list-option[@role='option']")
    WebElement CheckBox;

    public void Click_Check_Box(){
        CheckBox.click();
    }

}
