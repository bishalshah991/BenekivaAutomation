package BaseClass;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.idealized.target.model.SessionID;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Locale;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class TestBase {
    public static WebDriver driver;

    public void LaunchBrowser(String browser) throws IOException, ParseException {
        String environment = System.getProperty("os.name");
        System.out.println("Automation Script run on ......" + environment);

        switch (browser.toLowerCase(Locale.ROOT)) {

            case "chrome":
                DesiredCapabilities chrome = new DesiredCapabilities();
                String sessionId = System.getProperty("webdriver.remote.sessionid");
                chrome.setCapability("browserName", "chrome");
                chrome.setCapability("webdriver.remote.sessionid", sessionId);
               
            
                driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), chrome);
                break;
            case "firefox":
                DesiredCapabilities firefox = new DesiredCapabilities();
                firefox.setCapability("browserName", "firefox");
                firefox.setCapability("name", Thread.currentThread().getName());
                driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), firefox);
                break;
            case "safari":
                DesiredCapabilities safari = new DesiredCapabilities();
                safari.setCapability("browserName", "safari");
                safari.setCapability("name", Thread.currentThread().getName());
                driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), safari);
                break;
            case "microsoft":
                DesiredCapabilities edge = new DesiredCapabilities();
                edge.setCapability("browserName", "microsoftedge");
                edge.setCapability("name", Thread.currentThread().getName());
                driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), edge);
                break;
            default:
                driver = null;
                break;
        }
   
        

    }
}
