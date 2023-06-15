package ExtentReport;

import BaseClass.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;

public class TestListner extends TestBase implements ITestListener {
    ExtentReports extentReports=ExtentReportHelper.extentReportGenerator();
    ExtentTest extentTest;
    @Override
    public void onTestStart(ITestResult result) {
        extentTest=extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,result.getMethod().getMethodName()+"is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath=null;
        screenshotPath=captureScreenshot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
        extentTest.addScreenCaptureFromPath(screenshotPath);
        extentTest.fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
