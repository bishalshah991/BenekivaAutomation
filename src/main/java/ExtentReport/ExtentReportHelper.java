package ExtentReport;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;

public class ExtentReportHelper extends TestBase {
    static String path=System.getProperty("user.dir")+"\\ExtentReportGenerate\\index.html";
    static ExtentReports extentReports;

    public static ExtentReports extentReportGenerator(){
        String path=System.getProperty("user.dir")+"\\ExtentReportGenerate\\index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("UNITY Automation Result");
        reporter.config().setDocumentTitle("Unity Test Result");
        extentReports=new ExtentReports();
        extentReports.attachReporter(reporter);
        WebElement element=driver.findElement(By.xpath("//span[starts-with(@class,'remember-me ng-tns')]"));
        extentReports.setSystemInfo("QA","Bishal Shah");
        extentReports.setSystemInfo("Current Version",element.getText());
        extentReports.setSystemInfo("OS",System.getProperty("os.name"));
        return  extentReports;

    }


}
