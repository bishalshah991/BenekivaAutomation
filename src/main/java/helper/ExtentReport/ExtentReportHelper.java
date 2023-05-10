package helper.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportHelper {

    static ExtentReports extentReports;

    public static ExtentReports extentReportGenerator(){
        String path=System.getProperty("user.dir")+"\\ExtentReportGenerate\\index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("UNITY Automation Result");
        reporter.config().setDocumentTitle("Unity Test Result");
        extentReports=new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("QA","Bishal Shah");
        extentReports.setSystemInfo("OS",System.getProperty("os.name"));
        return  extentReports;

    }


}
