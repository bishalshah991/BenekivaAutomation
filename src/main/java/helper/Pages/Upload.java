package helper.Pages;

import BaseClass.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class Upload extends TestBase {

    //String path="D:\\Benekiva\\Intelij\\Automation\\BenekivaAutomation\\Unity_Test_Data\\TestData1.pdf";
    String getPath=System.getProperty("user.dir")+ File.separator + "Unity_Test_Data" + File.separator + "TestData1.pdf";

    @FindBy(xpath = "//input[@type='file']")
    WebElement uploadDocumentXpath;


    public Upload(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addUploadDocument() throws InterruptedException {
        Thread.sleep(3000);
        uploadDocumentXpath.sendKeys(getPath);
        Thread.sleep(3000);


    }
    public void addProfilePicture() throws InterruptedException {
        Thread.sleep(3000);
        uploadDocumentXpath.sendKeys((getPath));
        Thread.sleep(3000);
    }


}
