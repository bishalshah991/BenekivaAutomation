package BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.util.Locale;

public class TestBase {
    public static WebDriver driver;

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
}
