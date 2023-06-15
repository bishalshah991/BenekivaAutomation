package BaseClass;

import Benekiva.HLC.FHD.Dashboard;
import Utility.ReadJsonData;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Locale;

public class TestBase {
    private String Version;
    public static WebDriver driver;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    protected String path=System.getProperty("user.dir")+"\\ExtentReportGenerate\\index.html";


    @Parameters("browserName")
    @BeforeTest
    public void Setup(ITestContext context,@Optional("chrome") String browserName) throws IOException, ParseException {
        LaunchBrowser(browserName);
        Capabilities capabilities=((RemoteWebDriver)driver).getCapabilities();
        String device = capabilities.getBrowserName() + "" + capabilities.getBrowserVersion().substring(0, capabilities.getBrowserVersion().indexOf("."));
        String author = context.getCurrentXmlTest().getParameter("author");

        extentTest=extentReports.createTest(context.getName());
        extentTest.assignAuthor(author);
        extentTest.assignDevice(device);
    }

    @BeforeSuite
    public void initialiseExtentReports()
    {
        ExtentSparkReporter sparkReporter_all=new ExtentSparkReporter(path);
        sparkReporter_all.config().setReportName("UAT Automation Result");
        sparkReporter_all.config().setDocumentTitle("Test Result");

        extentReports=new ExtentReports();
        extentReports.attachReporter(sparkReporter_all );
        extentReports.setSystemInfo("QA Engineer","Bishal Shah");
        extentReports.setSystemInfo("Platform",System.getProperty("os.name"));
    }

    @AfterSuite
    public void generateReport() throws IOException {
        extentReports.flush();
        Desktop.getDesktop().browse(new File(path).toURI());
    }
    @AfterTest
    public void Quit() throws IOException, InterruptedException {
        driver.quit();
    }



    public void LaunchBrowser(String browser) throws IOException, ParseException {
        String environment=System.getProperty("os.name");
        System.out.println("Automation Script run on ......"+environment);

        switch (browser.toLowerCase(Locale.ROOT))
        {
            case "chrome":
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(ops);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "safari":
                driver=new SafariDriver();
                break;


            default:
                driver=null;
                break;
        }
        driver.manage().window().maximize();
    }

    public static String captureScreenshot(String filename){
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File sourcefile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("./Screenshots/"+filename);
        try {
            FileUtils.copyFile(sourcefile,destFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Screenshot saves successfully");
        return destFile.getAbsolutePath();
    }

    @AfterMethod
    public void CheckStatus(Method m,ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            String screenshotPath=null;
            screenshotPath=captureScreenshot(result.getTestContext().getName()+""+result.getMethod().getMethodName()+".jpg");
            extentTest.addScreenCaptureFromPath(screenshotPath);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus()==ITestResult.SUCCESS) {
            extentTest.pass(result.getMethod().getMethodName() + "is Passed");
        }
        extentTest.assignCategory(m.getAnnotation(Test.class).groups());
    }
}
